package com.example.i.AndroidDemos.customizedview.customizedview.TagGroup;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * Created by commi on 2018/1/21.
 */

public class TagGroup extends ViewGroup {

    //Tag边界宽度
    private float borderStrokeWidth = 30;

    //Tag文字水平方向内边距
    private int horizontalPadding = 30;

    //Tag文字垂直方向内边距
    private int verticalPadding = 30;

    //字体大小
    private float textSize = 15;

    public TagGroup(Context context) {
        super(context);
    }

    public TagGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TagGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TagGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // TODO: 2018/1/21 to un
    // 这里的layoutparams 主要用在tagview里面
    public static class LayoutParams extends ViewGroup.LayoutParams {

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        /**
         * @param width  : 三种值： 1. wrapContent
         * @param height
         */
        public LayoutParams(int width, int height) {
            super(width, height);
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private class TagView extends AppCompatTextView {
        //Tag需要的三种颜色: 1.背景颜色 2.边界颜色 3.字体颜色
        private TagColor tagColor;
        //Tag当前状态 : 1.正常状态  2.点击状态  3. 选中状态
        private int currentState;

        public TagView(Context context, final int state, TagColor color, CharSequence text) {
            super(context);
            this.tagColor = color;
            this.currentState = state;

            //设置TagView的padding，可通过getPaddingleft(),getPaddintTop(),getPaddingRight(),getPaddingBottom()方法获取到这里设置的数值
            setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
            // TODO: 2018/1/21  用 viewgroup.layoutPrams.WRAP_CONTENT 代替行不行
            // // TODO: 2018/1/21  为什么要用tagGroup的布局参数??
            setLayoutParams(new TagGroup.LayoutParams(TagGroup.LayoutParams.WRAP_CONTENT, TagGroup.LayoutParams.WRAP_CONTENT));
            setGravity(Gravity.CENTER);
            setText(text);
            // 第一个参数用来指定第二个参数的单位，px,sp,dp........
            setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);



        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }


    }
}
