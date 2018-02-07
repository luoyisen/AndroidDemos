package com.example.i.AndroidDemos.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.adapter.SearchHistoryAdapter;
import com.example.i.AndroidDemos.base.BaseActivity;
import com.example.i.AndroidDemos.constant.Constant;
import com.example.i.AndroidDemos.util.DisplayMetricsConvert;
import com.example.i.AndroidDemos.util.SharedPreferencesUtil;
import com.example.i.AndroidDemos.view.widget.viewgroup.TagGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;

import static com.example.i.AndroidDemos.constant.Constant.SEARCH_HISTORY_KEY;


/**
 * Created by HHX on 2018/2/6.
 */

public class ActivitySearchHistoryDemo extends BaseActivity {
    @BindView(R.id.searchview)
    SearchView searchView;
    @BindView(R.id.lvSearchHistory)
    ListView lvSearchHistory;
    @BindView(R.id.taggrouop)
    TagGroup tagGroup;

    private String searchKey;
    private ArrayAdapter<String> historySearchAdapter;
    private ListPopupWindow mListPopupWindow;
    private List<String> mHisList = new ArrayList<>();


    @Override
    protected void initView() {
        tagGroup.setTags(
                "Android",
                "Java",
                "Kotlin",
                "Github",
                "Stackoverflow",
                "Java编程思想",
                "算法导论",
                "网络是怎样连接的"
        );
        tagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                searchView.setQuery(tag, false);
                saveSearchHistory(tag);
            }
        });
        historySearchAdapter = new ArrayAdapter<String>(this, R.layout.item_search_history, mHisList);
        lvSearchHistory.setAdapter(historySearchAdapter);
        lvSearchHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchView.setQuery(historySearchAdapter.getItem(position), false);
                saveSearchHistory(historySearchAdapter.getItem(position));
            }
        });
        resetHistoryList();
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("type everything you want");
        LinearLayout ll_searchview = findViewById(R.id.search_edit_frame);
        ll_searchview.setBackground(getResources().getDrawable(R.drawable.shape_searchview));
        ll_searchview.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels - 100, DisplayMetricsConvert.pxToDp(getApplicationContext(), 32)));
        searchView.setSubmitButtonEnabled(false);
        LinearLayout search_bar = findViewById(R.id.search_bar);
        search_bar.setGravity(Gravity.CENTER);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchKey = query;
                saveSearchHistory(searchKey);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void saveSearchHistory(String searchKey) {
        //// TODO: 2018/2/7 下面这句话是如何将string转为list的？？
        List<String> historyList = SharedPreferencesUtil.getInstance().getObject(SEARCH_HISTORY_KEY, List.class);
        if (historyList == null) {
            historyList = new ArrayList<>();
            historyList.add(searchKey);
        } else {
            Iterator<String> iterator = historyList.iterator();
            while (iterator.hasNext()) {//遍历list里面所有string，和输入的key进行对比
                String s = iterator.next();
                if (TextUtils.equals(searchKey, s)) {
                    iterator.remove();//这个方法只能在iterator.next()方法执行之后执行一次
                }
            }
            historyList.add(0, searchKey);
        }
        int size = historyList.size();
        if (size > 10) {
            for (int i = size - 1; i >= 10; i--) {
                historyList.remove(i);
            }
        }
        SharedPreferencesUtil.getInstance().putObject(SEARCH_HISTORY_KEY, historyList);
        resetHistoryList();
    }

    private void resetHistoryList() {
        List<String> historyList = SharedPreferencesUtil.getInstance().getObject(SEARCH_HISTORY_KEY, List.class);
        historySearchAdapter.clear();
        if (historyList != null && historyList.size() > 0) {
            historySearchAdapter.addAll(historyList);
        }
        historySearchAdapter.notifyDataSetChanged();
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_search_history;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
