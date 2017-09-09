package com.example.i.AndroidDemos.noteandtools.note;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by I on 2017/8/22.
 */

public class MyViewGroup extends LinearLayout {
    public int dispatchMode;
    public int interceptMode;
    public int touchMode;

    public int getDispatchMode() {
        return dispatchMode;
    }

    public int getInterceptMode() {
        return interceptMode;
    }

    public int getTouchMode() {
        return touchMode;
    }

    public void setDispatchMode(int dispatchTouchEventMode) {
        this.dispatchMode = dispatchTouchEventMode;
    }

    public void setInterceptMode(int onInterceptTouchEventMode) {
        this.interceptMode = onInterceptTouchEventMode;
    }

    public void setTouchMode(int onTouchEventMode) {
        this.touchMode = onTouchEventMode;
    }

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    /**
//     * 1、决定该ViewGroup的LayoutParams
//     * 对于我们这个例子，我们只需要ViewGroup能够支持margin即可，那么我们直接使用系统的MarginLayoutParams
//     * <p>
//     * 重写父类的该方法，返回MarginLayoutParams的实例，这样就为我们的ViewGroup指定了其LayoutParams为MarginLayoutParams。
//     * <p>
//     * 遍历所有的childView，根据childView的宽和高以及margin，然后分别将0，1，2，3位置的childView依次设置到左上、右上、左下、右下的位置。
//     */
//    @Override
//    public LayoutParams generateLayoutParams(AttributeSet attrs) {
//        return new MarginLayoutParams(getContext(), attrs);
//    }
//
//    /**
//     * 2、onMeasure
//     * 在onMeasure中计算childView的测量值以及模式，以及设置自己的宽和高：
//     * <p>
//     * 计算所有childview 的宽度和高度 然后根据childview的计算结果,设置自己的宽高
//     */
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
////        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        Log.e("----->", "onMeasure");
//        /**
//         * 获得此ViewGroup上级容器为其推荐的宽和高,以及计算模式
//         */
//        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
//        int modeHight = MeasureSpec.getMode(heightMeasureSpec);
//        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
//
//        // 计算出所有的childview的宽和高  *************
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//
//        /**
//         * 记录如果是warp_content是设置的宽和高
//         */
//        // viewgroup的宽高
//        int width = 0;
//        int height = 0;
//
//        // childview的宽高
//        int cWidth = 0;
//        int cHeight = 0;
//        MarginLayoutParams cParams = null;
//
//        int childCount = getChildCount();
//
//        //用于计算左边两个childview的高度和
//        int lHeight = 0;
//        //用于计算右边两个childview的高度和,最终取最大值
//        int rHeight = 0;
//        //用于计算上边两个childview的宽度和
//        int tWidth = 0;
//        //用于计算下面两个childview的宽度和,最终取最大值
//        int bWidth = 0;
//
//        /**
//         * 根据childview计算出的宽和高,以及设置的margin计算容器的宽和高,主要用于容器是warp_content时
//         */
//        for (int i = 0; i < childCount; i++) {
//            View childView = getChildAt(i);
////            cWidth = childView.getWidth();// 为什么不是这个????
//            cWidth = childView.getMeasuredWidth();// childview的宽
//            cHeight = childView.getMeasuredHeight();// childview的高
//            cParams = (MarginLayoutParams) childView.getLayoutParams();
//
//            // 上面两个childview
//            if (i == 0 || i == 1) {// 上面的宽度
//                tWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
//            }
//            if (i == 2 || i == 3) {// 下面的宽度
//                bWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
//            }
//            if (i == 0 || i == 2) {//左边的高度
//                lHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
//            }
//            if (i == 1 || i == 3) {//右边的高度
//                rHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
//            }
//        }
//        width = Math.max(tWidth, bWidth);
//        height = Math.max(lHeight, rHeight);
//        /**
//         * 如果是wrap_content设置为我们计算的值
//         * 否则：直接设置为父容器计算的值
//         */
//        // 是精确的类型就直接取得到的值; 不是则用计算的值
//        setMeasuredDimension(modeWidth == MeasureSpec.EXACTLY ? sizeWidth : width, modeHight == MeasureSpec.EXACTLY ? sizeHeight : height);
//    }
//
//    /**
//     * 3、onLayout对其所有childView进行定位（设置childView的绘制区域）
//     * abstract method in viewgroup
//     */
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        Log.e("----->", "onLayout");
//        int childCount = getChildCount();
//        int childWidth = 0;
//        int childHeight = 0;
//        MarginLayoutParams childParams = null;
//        /**
//         * 遍历所有childview根据其宽和高,以及margin进行布局
//         */
//        for (int i = 0; i < childCount; i++) {
//            View childView = getChildAt(i);
//            childWidth = childView.getMeasuredWidth();
//            childHeight = childView.getMeasuredHeight();
//            childParams = (MarginLayoutParams) childView.getLayoutParams();
//
//            int cl = 0, ct = 0, cr = 0, cb = 0;
//            switch (i) {
//                case 0:
//                    cl = childParams.leftMargin;
//                    ct = childParams.topMargin;
//                    break;
//                case 1:
////                    cl = getMeasuredWidth() - childWidth - childParams.rightMargin;
//                    // getMeasuredWidth()也是可以的,得到的是在ViewGroup里的宽
//                    cl = getWidth() - childWidth - childParams.rightMargin;
//                    ct = childParams.topMargin;
//                    break;
//                case 2:
//                    cl = childParams.leftMargin;
////                    ct = getMeasuredHeight() - childHeight - childParams.bottomMargin;
//                    ct = getHeight() - childHeight - childParams.bottomMargin;
//                    break;
//                case 3:
//                    cl = getWidth() - childWidth - childParams.rightMargin;
//                    ct = getHeight() - childHeight - childParams.bottomMargin;
//                    break;
//            }
//            cr = childWidth + cl;
//            cb = childHeight + ct;
//            childView.layout(cl, ct, cr, cb);
//        }
//
//    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int i = getDispatchMode();
        if (i == 0) {
            return super.dispatchTouchEvent(ev);
        } else if (i == 1) {
            return false;
        } else if (i == 2) {
            return true;
        } else
            return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int i = getInterceptMode();
        if (i == 0) {
            return super.onInterceptTouchEvent(ev);
        } else if (i == 1) {
            return false;
        } else if (i == 2) {
            return true;
        } else
            return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = getTouchMode();
        if (i == 0) {
            processEvent(event);
            return super.onTouchEvent(event);
        } else if (i == 1) {
            processEvent(event);
            return false;
        } else if (i == 2) {
            processEvent(event);
            return true;
        } else
            return super.onTouchEvent(event);
    }

    public void processEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(getContext(), "ViewGroup---ACTION_DOWN事件", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Toast.makeText(getContext(), "ViewGroup---ACTION_MOVE事件", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Toast.makeText(getContext(), "ViewGroup---ACTION_UP事件", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //**************************************************************************************
//    public static class Builder {
//        private Context context;
//        public static int dispatchTouchEventMode;
//        public static int onInterceptTouchEventMode;
//        public static int onTouchEventMode;
//
//        public Builder(Context context) {
//            this.context = context;
//        }
//
//        public Builder setDispatchTouchEventMode(int dispatchTouchEventMode) {
//            this.dispatchTouchEventMode = dispatchTouchEventMode;
//            return this;
//        }
//
//        public Builder setOnInterceptTouchEventMode(int onInterceptTouchEventMode) {
//            this.onInterceptTouchEventMode = onInterceptTouchEventMode;
//            return this;
//        }
//
//        public Builder setOnTouchEventMode(int onTouchEventMode) {
//            this.onTouchEventMode = onTouchEventMode;
//            return this;
//        }
//
//        public MyViewGroup Create() {
//            MyViewGroup myViewGroup = new MyViewGroup(context);
//            myViewGroup.setDispatchMode(dispatchTouchEventMode);
//            myViewGroup.setInterceptMode(onInterceptTouchEventMode);
//            myViewGroup.setTouchMode(onTouchEventMode);
//            return myViewGroup;
//        }
//    }


}

 