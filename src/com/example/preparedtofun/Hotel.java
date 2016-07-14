package com.example.preparedtofun;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class Hotel extends Activity {
	private Intent intent = null;
	private Bundle bundle = null;
	private String str;
	private ImageView image;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.hotel);
		image = (ImageView) findViewById(R.id.hotel_item);
		intent = getIntent();
		bundle = intent.getExtras();
		str = bundle.getString("Which");
		showup(str);
	}

	@SuppressLint("NewApi")
	private void showup(String which) {
		// TODO �Զ����ɵķ������
		str = which;
		switch (Integer.parseInt(str)) {/*
										 * { "����","ҽԺ","����","�Ƶ�", "��Ʊ", "��ʳ",
										 * "�ҵ�λ��" };
										 */
		case 1:
			image.setBackground(getResources()
					.getDrawable(R.drawable.hospital3));
			break;
		case 2:
			image.setBackground(getResources().getDrawable(R.drawable.bank3));
			break;
		case 3:
			image.setBackground(getResources()
					.getDrawable(R.drawable.hotel1234));
			break;
		case 4:
			image.setBackground(getResources().getDrawable(
					R.drawable.trainticket1234));
			/*
			 * Intent intent1 = new Intent(Hotel.this,
			 * GetMyLocationActivity.class); startActivity(intent1);
			 */
			break;
		case 5:
			image.setBackground(getResources().getDrawable(
					R.drawable.delisious1234));
			break;
		default:
			break;
		}
	}

}
