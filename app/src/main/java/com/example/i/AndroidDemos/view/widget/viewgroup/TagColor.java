package com.example.i.AndroidDemos.view.widget.viewgroup;

import android.graphics.Color;

import com.example.i.AndroidDemos.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by commi on 2018/1/25.
 */

public class TagColor {

    public int borderColor = Color.parseColor("#49C120");
    public int backgroundColor = Color.parseColor("#49C120");
    public int textColor = Color.WHITE;

    public static List<TagColor> getRandomColors(int size){

        List<TagColor> list = new ArrayList<>();
        for(int i=0; i< size; i++){
            TagColor color = new TagColor();
            color.borderColor = color.backgroundColor = Constant.tagColors[i % Constant.tagColors.length];
            list.add(color);
        }
        return list;
    }
}
