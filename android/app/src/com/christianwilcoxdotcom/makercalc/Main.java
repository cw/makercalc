package com.christianwilcoxdotcom.makercalc;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Main extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    WebView myWebView = (WebView) findViewById(R.id.webview);
    WebSettings webSettings = myWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    myWebView.loadUrl("http://makercalc.appspot.com");
  }
}