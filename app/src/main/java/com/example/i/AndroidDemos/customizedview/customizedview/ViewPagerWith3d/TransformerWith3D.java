package com.example.i.AndroidDemos.customizedview.customizedview.ViewPagerWith3d;

import android.support.v4.view.ViewPager;
import android.view.View;

/***
 * Created by I on 2017/11/8.
 */

public class TransformerWith3D implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;

    @Override
    public void transformPage(View page, float position) {
        float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
        float rotate = 10 * Math.abs(position);
        if (position <= -1) {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setRotationY(rotate);
        } else if (position < 0) {//position从0变化到-1，page逐渐向左滑动
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(rotate);
        } else if (position >= 0 && position < 1) {//position从0变化到1，page逐渐向右滑动
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        } else if (position >= 1) {//position大于等于1的时候，代表page已经位于中心item的最右边
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        }
    }
}
