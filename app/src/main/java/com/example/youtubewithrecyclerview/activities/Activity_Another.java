package com.example.youtubewithrecyclerview.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.youtubewithrecyclerview.R;

public class Activity_Another extends AppCompatActivity {
    WebView webViewFullscreen;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__another);
        initUI();
    }

    private void initUI() {
        webViewFullscreen = findViewById(R.id.webView_fullScreen);
        link = getIntent().getStringExtra("link");
        webViewFullscreen.loadUrl(link);
        webViewFullscreen.setWebViewClient(new WebViewClient());
        webViewFullscreen.setWebChromeClient(new WebChromeClient());
        webViewFullscreen.getSettings().setJavaScriptEnabled(true);

    }
}
