package com.Quang.Tin.homework05;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Quang on 4/27/17.
 */

public class LoadImage{
    public static Bitmap loadBitmap(String this_url) throws IOException {
        try {
            URL url = new URL(this_url);
            Bitmap mIcon_val = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return mIcon_val;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
