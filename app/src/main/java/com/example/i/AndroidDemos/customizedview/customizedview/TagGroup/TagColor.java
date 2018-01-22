package com.example.i.AndroidDemos.customizedview.customizedview.TagGroup;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by commi on 2018/1/21.
 */

public class TagColor {
    public int borderColor = Color.parseColor("#ff0000");
    public int backgroundColor = Color.parseColor("#000000");
    public int textColor = Color.WHITE;

    public static List<TagColor> getRandomColors(int size) {
        List<TagColor> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TagColor color = new TagColor();
//            color.borderColor = color.backgroundColor = Constant.tagColors[i % Constant.tagColors.length];
            list.add(color);
        }
        return list;
    }

}
