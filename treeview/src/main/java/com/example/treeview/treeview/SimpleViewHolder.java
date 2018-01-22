package com.example.treeview.treeview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;


/**
 * Created by commi on 2018/1/21.
 */

public class SimpleViewHolder extends TreeNode.BaseNodeViewHolder<Object> {

    public SimpleViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, Object value) {
        final TextView tv = new TextView(context);
        tv.setText(String.valueOf(value));
        return tv;
    }

    @Override
    public void toggle(boolean active) {

    }
}
