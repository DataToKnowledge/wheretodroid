/**
 * WhereToLive
 * @copyright DataToKnowledge S.r.l.s.- September 2014 - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * @license Proprietary and confidential
 */

package it.wheretolive.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 *
 * @author Andrea Scarpino <andrea@datatoknowledge.it>
 *
 */
public class MainActivity extends Activity {

	private WebView myWebView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		myWebView = (WebView) findViewById(R.id.webview);

		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		// Open links into this app
		myWebView.setWebViewClient(new MyWebViewClient());

		myWebView.loadUrl("http://www.wheretolive.it/");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Check if the key event was the Back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
			myWebView.goBack();
			return true;
		}

		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}

	private class MyWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (Uri.parse(url).getHost().equals("www.wheretolive.it")) {
				// This is my web site, so do not override; let my WebView load
				// the page
				return false;
			}

			// Otherwise, the link is not for a page on my site, so launch
			// another Activity that handles URLs
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			startActivity(intent);
			return true;
		}
	}
}
