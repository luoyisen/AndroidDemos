package com.example.i.AndroidDemos.algorithm.TreeViewMethod2.bean;

import com.example.i.AndroidDemos.R;
import com.example.treeview.LayoutItemType;

/***
 * Created by I on 2017/11/12.
 */

public class Dir implements LayoutItemType {
    public String dirName;

    public Dir(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_dir;
    }
}
