package com.example.i.AndroidDemos.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.view.widget.viewgroup.TagColor;
import com.example.i.AndroidDemos.view.widget.viewgroup.TagGroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * Created by I on 2017/10/26.
 */

public class FragmentHashSet extends Fragment {
    /**
     * HashSet底层使用的HashMap实现的，底层使用HashMap保存数据。
     */
    Set<String> set;

    private TagGroup taggrouop;
    private List<String> strings = Arrays.asList(
            "wodesijie",
            "nideshijie",
            "heheda",
            "还有谁",
            "我的世界开始写夏旭了",
            "dsafhjjjjj",
            "总有人要死",
            "屠洪刚"
    );
    int hotIndex = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set, container, false);
        taggrouop = view.findViewById(R.id.taggrouop);
        taggrouop.setTags(
                "fasf","fasdf","fsadf",
                "fasf","fasdf","wfweoigfajdsogjowiefjasdkjf;owaeifjasdifowe",
                "fasf","sejfoiwfjasjsafjas","fsadf",
                "sjfasfjio收到i圣诞放假我i额发生飞洒都i附件为偶分啊师傅教我欸放假啊","fasdf","fsadf",
                "fasf","fasdf","fsadf",
                "fasf","fasdf","fsadf",
                "fasf","fasdf","fsadf"
        );
        return inflater.inflate(R.layout.fragment_set, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");//重复操作，不会添加，set集合中还是只有两个值

    }

    private synchronized void showHotWord() {
        int tagSize = 8;
        String[] tags = new String[tagSize];
        for (int j = 0; j < tagSize && j < strings.size(); hotIndex++, j++) {
            tags[j] = strings.get(hotIndex % strings.size());
        }
        List<TagColor> colors = TagColor.getRandomColors(tagSize);
        taggrouop.setTags(colors, tags);
    }
}
