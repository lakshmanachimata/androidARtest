package com.inresto.menuar;

import android.webkit.JavascriptInterface;


public class WebInterface {

    public MainActivity mainActivity;

    /** Instantiate the interface and set the context */
    WebInterface(MainActivity c) {
        mainActivity = c;
    }

    @JavascriptInterface
    public void webToNavtiveMessage(String message, String data) {
        mainActivity.handleMessageWithData(message, data);
    }
}