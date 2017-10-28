package drozd.dawid.dexode.com.secureme;

import android.app.Application;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gelldur on 25.10.17.
 */

public class App extends Application {

    private static App _instance;

    public static App getInstance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = this;
    }

    public static File getCacheFile(Context context, String file) throws IOException {
        File cacheFile = new File(context.getCacheDir(), file);
        try {
            cacheFile.getParentFile().mkdirs();
            InputStream inputStream = context.getAssets().open(file);
            try {
                FileOutputStream outputStream = new FileOutputStream(cacheFile);
                try {
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buf)) > 0) {
                        outputStream.write(buf, 0, len);
                    }
                } finally {
                    outputStream.close();
                }
            } finally {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new IOException("Could not open cache file", e);
        }
        return cacheFile;
    }
}
