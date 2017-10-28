package drozd.dawid.dexode.com.secureme;

import java.io.*;

// ----------------------------------------------------------------------------

/**
 * Sample usage
 * java -encrypt <dir with classes to be encrypted> <full class name1> <full class name1> ...
 */
public class Encrypter {

    public static final String USAGE = "usage: Encrypter " +
            "(" +
            "-encrypt <classpath dir> <class 1> <class 2> ..." +
            ")";

    public static boolean TRACE = true;

    public static void main(final String[] args)
            throws Exception {
        if (args.length == 1)
            throw new IllegalArgumentException(USAGE);

        if ("-encrypt".equals(args[0]) == false || args.length < 3) {
            throw new IllegalArgumentException(USAGE);
        }

        final File outputDirectory = new File(args[1]);

        for (int i = 2; i < args.length; ++i) {
            final File file = new File(args[i]);
            final byte[] classBytes;

            InputStream inputStream = null;
            final File srcFile = new File(outputDirectory, file.getPath());
            try {
                srcFile.getParentFile().mkdirs();

                inputStream = new FileInputStream(srcFile);

                classBytes = readFully(inputStream);
                crypt(classBytes);//encrypt
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception ignore) {
                    }
                }
            }

            OutputStream out = null;
            try {
                final File outputFile = new File(outputDirectory, file.getPath());
                outputFile.getParentFile().mkdirs();

                out = new FileOutputStream(outputFile);
                out.write(classBytes);
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (Exception ignore) {
                    }
                }
            }

            if (TRACE) System.out.println("encrypted [" + file + "]");
        }
    }

    /**
     * De/encrypts binary data in a given byte array. Calling the method again
     * reverses the encryption.
     */
    private static void crypt(final byte[] data) {
        for (int i = 8; i < data.length; ++i) data[i] ^= 0x5A;
    }

    /**
     * Reads the entire contents of a given stream into a flat byte array.
     */
    private static byte[] readFully(final InputStream in)
            throws IOException {
        final ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        final byte[] buf2 = new byte[8 * 1024];

        for (int read; (read = in.read(buf2)) > 0; ) {
            buf1.write(buf2, 0, read);
        }

        return buf1.toByteArray();
    }

}