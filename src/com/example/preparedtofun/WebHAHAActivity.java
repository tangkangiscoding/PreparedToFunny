package com.example.preparedtofun;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebHAHAActivity extends Activity {
	@SuppressWarnings("unused")
	private String str;
	private WebView webView;// ������ʾ��ͼ�İٶ���ҳ

	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.webview);
		webView = (WebView) this.findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);// ����javaScript����
		webView.addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
		// ����һ��Activity��ȡ���ٶȵ�ͼ�������
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		Double Longitude = bundle.getDouble("Longitude");
		Double Latitude = bundle.getDouble("Latitude");
		// ����ҳ��ʾ����
		webView.loadUrl("http://api.map.baidu.com/marker?location=" + Latitude
				+ "," + Longitude + "&title=�ҵ�λ��&output=html");
	}

	final class MyWebViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}

		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
		}

		public void onPageFinished(WebView view, String url) {
			view.loadUrl("javascript:var my = document.getElementById('tools');if (my != null)my.parentNode.removeChild(my);");
			super.onPageFinished(view, url);
		}
	}

	final class InJavaScriptLocalObj {
		public void showSource(String html) {
			try {
				str = html;
			} catch (Exception e) {
			}

		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		this.finish();
		return super.onKeyDown(keyCode, event);
	}

}