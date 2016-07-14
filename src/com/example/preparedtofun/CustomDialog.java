package com.example.preparedtofun;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * �Զ���dialog
 * 
 * @author Administrator
 * 
 */
// ʹ������
/*
 * final CustomDialog dialog = new CustomDialog(LoginActivity.this);
 * dialog.setTitle("����"); dialog.setDetial("����"); dialog.setLeftOnClick(new
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
		mDialog = new Dialog(context, R.style.customDialog); // һ����title��ʽ
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
	 * ��߰�ť����¼�
	 * 
	 * @param listener
	 */
	public void setLeftOnClick(View.OnClickListener listener) {
		cancel.setOnClickListener(listener);
	}

	/**
	 * �ұ߰�ť����¼�
	 * 
	 * @param listener
	 */
	public void setRightOnClick(View.OnClickListener listener) {
		ensure.setOnClickListener(listener);
	}

	/**
	 * ���ñ���
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
	 * ��������
	 * 
	 * @param detial
	 */
	public void setDetial(String detial) {
		this.detial.setText(detial);
	}

	/**
	 * ������߰�ť����
	 * 
	 * @param cancelBg
	 */
	public void setCancelBg(int cancelBg) {
		cancel.setBackgroundResource(cancelBg);
	}

	/**
	 * �����ұ߰�ť����
	 * 
	 * @param cancelBg
	 */
	public void setEnsureBg(int ensureBg) {
		ensure.setBackgroundResource(ensureBg);
	}

	/**
	 * ����������߰�ť����
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
