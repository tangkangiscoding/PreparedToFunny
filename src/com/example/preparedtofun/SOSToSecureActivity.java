package com.example.preparedtofun;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SOSToSecureActivity extends Activity {
	private ImageButton dialtosecure;
	private ImageView title_return_left_image;
	private TextView title_return_left_text;
	private LinearLayout ly_sos11;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sostosecure);
		initView();
		initEvent();

	}

	private void initView() {
		dialtosecure = (ImageButton) findViewById(R.id.dialtosecure111);
		title_return_left_image = (ImageView) findViewById(R.id.title_return_left_image);
		title_return_left_text = (TextView) findViewById(R.id.title_return_left_text);
		title_return_left_text.setText("一键SOS");
		ly_sos11 = (LinearLayout)findViewById(R.id.ly_sos11);
	}

	private void initEvent() {
		dialtosecure.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Uri uri = Uri.parse("tel:8765110");

				Intent intent = new Intent(Intent.ACTION_DIAL, uri);

				startActivity(intent);
			}
		});
		title_return_left_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
		ly_sos11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(SOSToSecureActivity.this, SharePosititionActivity.class);
				startActivity(intent);
			}
		});
	}

}
