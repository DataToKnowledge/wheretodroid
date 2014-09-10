/**
 * WhereToDroid
 * @copyright DataToKnowledge S.r.l.s.- September 2014 - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * @license Proprietary and confidential
 * @author Andrea Scarpino <andrea@datatoknowledge.it>
 */

package it.wheretolive.android;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);

		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl("http://www.wheretolive.it/");
	}
}
