package com.example.i.AndroidDemos.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

/***
 * Created by I on 2017/9/21.
 */

public class AlbumUtils {

    public static Bitmap getCroppedBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int crop;
        final int color = 0xff424242;
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);

        if (width > height) {
            crop = (width - height) / 2;
            Bitmap output = Bitmap.createBitmap(height, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            final Rect rect = new Rect(crop, 0, width - crop, height);
            final Rect dst_rect = new Rect(0, 0, height, height);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawCircle(height / 2, height / 2, height / 2, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, dst_rect, paint);
            return output;
        } else {
            crop = (height - width) / 2;
            Bitmap output = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            final Rect rect = new Rect(0, crop, width, height - crop);
            final Rect dst_rect = new Rect(0, 0, width, width);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawCircle(width / 2, width / 2, width / 2, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, dst_rect, paint);
            return output;
        }

    }
}
