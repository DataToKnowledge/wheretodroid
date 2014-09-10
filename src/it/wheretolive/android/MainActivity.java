/**
 * WhereToDroid
 * @copyright DataToKnowledge S.r.l.s.- September 2014 - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * @license Proprietary and confidential
 * @author Andrea Scarpino <andrea@datatoknowledge.it>
 */

package it.wheretolive.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
		myWebView.setWebViewClient(new WebViewClient());

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
}
