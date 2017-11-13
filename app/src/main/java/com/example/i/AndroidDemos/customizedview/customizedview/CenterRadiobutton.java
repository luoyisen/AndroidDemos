package com.example.i.AndroidDemos.customizedview.customizedview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/***
 * Created by I on 2017/11/13.
 */

public class CenterRadiobutton extends android.support.v7.widget.AppCompatRadioButton {
    public CenterRadiobutton(Context context) {
        super(context);
    }

    public CenterRadiobutton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterRadiobutton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {// TODO: 2017/11/13  to un
        Drawable[] drawables = getCompoundDrawables();
        Drawable drawableLeft = drawables[0];
        if (drawableLeft != null) {
            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth;
            drawableWidth = drawableLeft.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }
}
