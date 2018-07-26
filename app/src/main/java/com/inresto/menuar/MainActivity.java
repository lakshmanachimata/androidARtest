package com.inresto.menuar;

import android.graphics.Bitmap;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    String ip = "http://10.0.2.2:3000";
    String urlPrep = ip + "/mdinein/";
    String restId = "laks1";
    WebInterface webInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webview);
        urlPrep = urlPrep +restId;
        setWebViewSettings();
        loadInRestoMenu();
    }

    void setWebViewSettings(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.clearCache(true);
        WebView.setWebContentsDebuggingEnabled(true);
        webInterface = new WebInterface(MainActivity.this);
        webView.addJavascriptInterface(webInterface,"inresto");
    }


    void  handleMessageWithData (final  String msg, final  String data){

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "message is" + msg + "\n" + "data is "+ data,Toast.LENGTH_LONG).show();
            }
        });

    }
    void loadInRestoMenu(){


        webView.loadUrl(urlPrep);


        webView.setWebChromeClient(new WebChromeClient(){

        });

        webView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
            }


            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return  super.shouldInterceptRequest(webView,request);
            }

        });
    }

}
