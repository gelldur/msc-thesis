package drozd.dawid.dexode.com.secureme;

import dalvik.system.DexClassLoader;

import java.io.*;

public class DecryptClassLoader extends ClassLoader {

    public static boolean TRACE = BuildConfig.DEBUG;

    public DecryptClassLoader(final ClassLoader parent, final File encryptedDexFile, final File optimizeDirectory) {
        super(parent);

        _encryptedFile = encryptedDexFile;
        _optimizationPath = optimizeDirectory;
    }

    public void clean() {
        if (_decryptedFile != null) {
            _decryptedFile.delete();
        }
        if (_optimizationPath != null) {
            _optimizationPath.delete();
        }
    }

    public Class loadClass(final String name, final boolean resolve)
            throws ClassNotFoundException {
        if (TRACE) System.out.println("loadClass (" + name + ", " + resolve + ")");

        // check maybe it is already loaded
        Class clazz = findLoadedClass(name);
        if (clazz != null) {
            return clazz;
        }

        return findClass(name);
    }

    protected Class findClass(final String name) throws ClassNotFoundException {
        if (TRACE) System.out.println("findClass (" + name + ")");

        //Decrypt, I know it is not secure.... In android 26 we have InMemoryDexClassLoader so this could be improved
        _decryptedFile = new File(_encryptedFile.getParent() + File.separator + "decrypted.dex");
        _decryptedFile.deleteOnExit();
        try {
            decrypt(_encryptedFile, _decryptedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //We could consider use of ClassLoader::defineClass but Android do not support this method
        try {
            DexClassLoader dexClassLoader = new DexClassLoader(_decryptedFile.getAbsolutePath(), _optimizationPath.getAbsolutePath(), null, getParent());
            return dexClassLoader.loadClass(name);
        } finally {
            clean();//Super unsecure :/
        }
    }

    /**
     * De/encrypts binary data in a given byte array. Calling the method again
     * reverses the encryption.
     */
    private static void crypt(final byte[] data) {
        for (int i = 8; i < data.length; ++i) data[i] ^= 0x5A;
    }

    private static boolean decrypt(File file, File output) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);

            final byte[] decryptedDex = readFully(inputStream);

            crypt(decryptedDex);//Decrypt
            if (TRACE) System.out.println("decrypted [" + file.getPath() + "]");

            FileOutputStream out = new FileOutputStream(output);
            try {
                out.write(decryptedDex);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } finally {
            if (inputStream != null) try {
                inputStream.close();
            } catch (Exception ignore) {
            }
        }
        return true;
    }

    /**
     * Reads the entire contents of a given stream into a flat byte array.
     */
    private static byte[] readFully(final InputStream in)
            throws IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        final byte[] tmpBuffer = new byte[4 * 1024];

        for (int read; (read = in.read(tmpBuffer)) > 0; ) {
            buffer.write(tmpBuffer, 0, read);
        }

        return buffer.toByteArray();
    }

    private File _decryptedFile;
    private File _encryptedFile;
    private File _optimizationPath;
}