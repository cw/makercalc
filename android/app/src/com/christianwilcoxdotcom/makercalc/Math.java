package com.christianwilcoxdotcom.makercalc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Math extends Activity {
	
	  private static final String LOG_TAG = "WebViewDemo";
	  private WebView myWebView;
	  private Handler mHandler = new Handler();

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.math);
	    WebView myWebView = (WebView) findViewById(R.id.webview_math);
	    myWebView.setWebViewClient(new MyWebViewClient());
	    myWebView.addJavascriptInterface(new DemoJavaScriptInterface(), "demo");
	    WebSettings webSettings = myWebView.getSettings();
	    webSettings.setJavaScriptEnabled(true);
	    
	    String ua = webSettings.getUserAgentString();
	    webSettings.setUserAgentString(ua + "; makercalc_android_app");
	    myWebView.loadUrl("http://makercalc.appspot.com/math");
	  }
	
	  final class DemoJavaScriptInterface {

		    DemoJavaScriptInterface() {
		    }

		    /**
		     * This is not called on the UI thread. Post a runnable to invoke
		     * loadUrl on the UI thread.
		     */
		    public void clickOnAndroid() {
		        mHandler.post(new Runnable() {
		            public void run() {
		            	try {
		            		myWebView.loadUrl("javascript:window.wave()");
		            	} catch (Exception err) {
		            		Log.d(LOG_TAG, "why isn't this working?");
		            	}
		            }
		        });

		    }
		}

	  class MyWebViewClient extends WebViewClient {
			
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        if (Uri.parse(url).getHost().equals("makercalc.appspot.com")) {
		            // This is my web site, so do not override; let my WebView load the page
		            return false;
		        }
		        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
		        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		        //startActivity(intent);
		        return true;
		    }
		}

	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.settings, menu);
	      return true;
	  }
	  
	  public void onCncItemClick(MenuItem item) {
		  Intent intent = new Intent(this, Cnc.class);
		  startActivity(intent);
	  }

	  public void onMathItemClick(MenuItem item) {
		  Intent intent = new Intent(this, Math.class);
		  startActivity(intent);
	  }

	  public void onVizItemClick(MenuItem item) {
		  Intent intent = new Intent(this, Visualization.class);
		  startActivity(intent);
	  }
}