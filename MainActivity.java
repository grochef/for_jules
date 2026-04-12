package com.gregg.macrotracker;

import android.os.Bundle;
import android.webkit.WebChromeClient; // Added this import
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();

        // This is the magic that makes the app actually work
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Keep this to handle page loading within the app
        myWebView.setWebViewClient(new WebViewClient());

        // ADD THIS LINE: This enables JavaScript dialogs (like your 'Clear Day' confirm box)
        myWebView.setWebChromeClient(new WebChromeClient());

        myWebView.loadUrl("file:///android_asset/index.html");
    }
}