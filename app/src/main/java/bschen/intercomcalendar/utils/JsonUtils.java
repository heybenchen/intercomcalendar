package bschen.intercomcalendar.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public final class JsonUtils {

    public static String loadJsonFromAsset(final Context context, final String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
