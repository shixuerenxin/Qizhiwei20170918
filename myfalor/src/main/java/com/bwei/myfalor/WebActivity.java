package com.bwei.myfalor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    private WebView wvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wvShow = (WebView) findViewById(R.id.wv_show);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        wvShow.loadUrl(url);
    }
}
