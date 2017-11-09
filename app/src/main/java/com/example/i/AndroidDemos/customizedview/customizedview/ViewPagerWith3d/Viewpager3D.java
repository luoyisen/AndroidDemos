package com.example.i.AndroidDemos.customizedview.customizedview.ViewPagerWith3d;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/11/8.
 */

public class Viewpager3D extends ViewPager {
    private static final int[] drawableIDs = new int[]{
            R.mipmap.pager1,
            R.mipmap.pager2,
            R.mipmap.pager3,
            R.mipmap.pager4,
            R.mipmap.pager5
    };

    public Viewpager3D(Context context) {
        super(context);
    }

    public Viewpager3D(Context context, AttributeSet attrs) {
        super(context, attrs);
        PagerAdapterWith3D pagerAdapterWith3D = new PagerAdapterWith3D(drawableIDs, context);
        setAdapter(pagerAdapterWith3D);
        setPageTransformer(true, new TransformerWith3D());
        setOffscreenPageLimit(2);//加载正在显示的page两边各两个page，总共四个
        setPageMargin(2);
    }
}
