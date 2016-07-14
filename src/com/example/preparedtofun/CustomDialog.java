package com.example.preparedtofun;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * 自定义dialog
 * 
 * @author Administrator
 * 
 */
// 使用样例
/*
 * final CustomDialog dialog = new CustomDialog(LoginActivity.this);
 * dialog.setTitle("标题"); dialog.setDetial("内容"); dialog.setLeftOnClick(new
 * OnClickListener(){
 * 
 * @Override public void onClick(View v) { dialog.dismiss(); }}); dialog.show();
 */
public class CustomDialog {
	private TextView title;
	private TextView detial;
	private Button cancel;
	private Button ensure;
	private Dialog mDialog;
	private LayoutInflater mInflater;

	public CustomDialog(Context context) {
		mDialog = new Dialog(context, R.style.customDialog); // 一个无title样式
		mInflater = LayoutInflater.from(context);

		View dialogView = mInflater.inflate(R.layout.custom_dialog, null);

		Window window = mDialog.getWindow();
		window.setContentView(dialogView);

		findView(window);
	}

	private void findView(Window window) {
		title = (TextView) window.findViewById(R.id.custom_dialog_title);
		detial = (TextView) window.findViewById(R.id.custom_dialog_detial);
		cancel = (Button) window.findViewById(R.id.custom_dialog_cancel);
		ensure = (Button) window.findViewById(R.id.custom_dialog_ensure);
	}

	/**
	 * 左边按钮点击事件
	 * 
	 * @param listener
	 */
	public void setLeftOnClick(View.OnClickListener listener) {
		cancel.setOnClickListener(listener);
	}

	/**
	 * 右边按钮点击事件
	 * 
	 * @param listener
	 */
	public void setRightOnClick(View.OnClickListener listener) {
		ensure.setOnClickListener(listener);
	}

	/**
	 * 设置标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		if (title.equals("")) {
			this.title.setVisibility(View.GONE);
		} else {
			this.title.setText(title);
		}

	}

	/**
	 * 设置详情
	 * 
	 * @param detial
	 */
	public void setDetial(String detial) {
		this.detial.setText(detial);
	}

	/**
	 * 设置左边按钮背景
	 * 
	 * @param cancelBg
	 */
	public void setCancelBg(int cancelBg) {
		cancel.setBackgroundResource(cancelBg);
	}

	/**
	 * 设置右边按钮背景
	 * 
	 * @param cancelBg
	 */
	public void setEnsureBg(int ensureBg) {
		ensure.setBackgroundResource(ensureBg);
	}

	/**
	 * 设置隐藏左边按钮背景
	 * 
	 * @param cancelBg
	 */
	public void setLeftVisible(int ensureBg) {
		cancel.setVisibility(View.GONE);
	}

	public void show() {
		mDialog.show();
	}

	public void dismiss() {
		mDialog.dismiss();
	}
}
