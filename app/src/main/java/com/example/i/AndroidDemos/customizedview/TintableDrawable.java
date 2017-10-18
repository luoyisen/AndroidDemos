package com.example.i.AndroidDemos.customizedview;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/***
 * Created by I on 2017/9/14.
 */

public interface TintableDrawable {

    void setTint(@ColorInt int tintColor);

    void setTintList(@Nullable ColorStateList tint);

    void setTintMode(@NonNull PorterDuff.Mode tintMode);
}
