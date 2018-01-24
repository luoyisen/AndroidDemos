package com.example.i.AndroidDemos.view.TreeViewMethod2.bean;

import com.example.i.AndroidDemos.R;
import com.example.treeview.LayoutItemType;

/***
 * Created by I on 2017/11/12.
 */

public class File implements LayoutItemType{
    public String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_file;
    }
}
