package com.example.instudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Preview extends AppCompatActivity {

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent i = new Intent(this,Resource.class);
            startActivity(i);
            finish();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preview);

            String url = getIntent().getStringExtra("url");
            WebView webView = (WebView) findViewById(R.id.preview);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl(url);
        }
}
