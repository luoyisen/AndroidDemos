package com.example.i.AndroidDemos.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;

/***
 * Created by I on 2017/9/7.
 */

public class ActivityWithWebView extends
        BaseActivity {
    WebView webview;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.loadUrl("http://www.jianshu.com/p/2b634a7c49ec");
    }

}
