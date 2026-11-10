package com.rafael.komik;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.net.Uri;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends Activity {

    private WebView webView;
    private static final int FILE_REQUEST = 1001;
    private android.webkit.ValueCallback<Uri[]> fileCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(0xFF0F0F14);
        getWindow().setNavigationBarColor(0xFF0F0F14);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);

        webView.setWebViewClient(new WebViewClient());

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(
                WebView view,
                android.webkit.ValueCallback<Uri[]> callback,
                FileChooserParams params) {

                fileCallback = callback;

                try {
                    startActivityForResult(
                        params.createIntent(),
                        FILE_REQUEST
                    );
                    return true;
                } catch (Exception e) {
                    fileCallback = null;
                    Toast.makeText(
                        MainActivity.this,
                        "Gagal membuka file",
                        Toast.LENGTH_SHORT
                    ).show();
                    return false;
                }
            }
        });

        webView.loadUrl(
            "https://heroic-nougat-89739d.netlify.app/"
        );
    }

    @Override
    protected void onActivityResult(
        int requestCode,
        int resultCode,
        Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FILE_REQUEST && fileCallback != null) {
            Uri[] result =
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode, data
                );

            fileCallback.onReceiveValue(result);
            fileCallback = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
