package com.example.preparedtofun;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GetMyLocationActivity extends Activity {
	@SuppressWarnings("unused")
	private String str;
	@SuppressWarnings("unused")
	private WebView webView;// ������ʾ��ͼ�İٶ���ҳ
	public LocationClient mLocationClient = null;
	public TextView mTv;
	public Button mLocBtn;
	private double Latitude;
	private double Longitude;
	public MyLocationListenner myListener = new MyLocationListenner();
	private ImageView title_return_left_image;
	private TextView title_return_left_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		title_return_left_image = (ImageView) findViewById(R.id.title_return_left_image);
		title_return_left_text = (TextView) findViewById(R.id.title_return_left_text);
		title_return_left_text.setText("�ҵ�λ��");
		mLocBtn = (Button) findViewById(R.id.localButton);
		mTv = (TextView) findViewById(R.id.mapinfo);
		init();
	}

	private void init() {
		findView();
		title_return_left_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
	}

	private void findView() {
		/*
		 * fontPath = "fonts/huawenxinkai.ttf"; tf =
		 * Typeface.createFromAsset(getAssets(), fontPath);
		 */

		mLocationClient = new LocationClient(GetMyLocationActivity.this);
		mLocationClient.registerLocationListener(myListener);
		Log.e("Latitude+Latitude", Latitude + Longitude + "");

		// mLocBtn.setTypeface(tf);

		webView = (WebView) findViewById(R.id.webView);

		mLocationClient.start();
		mLocBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mLocationClient != null && mLocationClient.isStarted()) {
					setLocationOption();
					mLocationClient.requestLocation();
					Bundle bundle = new Bundle();
					bundle.putDouble("Latitude", Latitude);
					bundle.putDouble("Longitude", Longitude);
					Intent intent = new Intent(GetMyLocationActivity.this,
							com.example.preparedtofun.WebHAHAActivity.class);
					intent.putExtras(bundle);
					startActivity(intent);

				}
			}
		});
	}

	final class InJavaScriptLocalObj {
		public void showSource(String html) {
			try {
				str = html;
			} catch (Exception e) {
			}

		}
	}

	/**
	 * ��ʾ�ַ���
	 * 
	 * @param str
	 */
	public void logMsg(String str) {
		try {
			if (mTv != null)
				/*
				 * fontPath = "fonts/youyuan.ttf"; tf =
				 * Typeface.createFromAsset(getAssets(), fontPath);
				 */
				mTv.setText(str);
			// mTv.setTypeface(tf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������������λ�õ�ʱ�򣬸�ʽ�����ַ������������Ļ��
	 */
	public class MyLocationListenner implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null)
				return;
			if (location.getAddrStr() == null) {
				mLocationClient.requestLocation();
			}
			Latitude = location.getLatitude();
			Longitude = location.getLongitude();
			StringBuffer sb = new StringBuffer(256);
			sb.append("\n");
			sb.append("�ϴζ�λʱ�� : ");
			sb.append("\n");
			sb.append(location.getTime());
			sb.append("\n");
			sb.append("\n���� : ");
			sb.append("\n");
			sb.append(location.getLatitude());
			sb.append("\n");
			sb.append("\nγ�� : ");
			sb.append("\n");
			sb.append(location.getLongitude());
			sb.append("\n");
			sb.append("\n�뾶 : ");
			sb.append("\n");
			sb.append(location.getRadius());
			sb.append("\n");
			if (location.getLocType() == BDLocation.TypeGpsLocation) {
				sb.append("\nspeed : ");
				sb.append(location.getSpeed());
				sb.append("\nsatellite : ");
				sb.append(location.getSatelliteNumber());
			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
				if (location.getAddrStr() != null) {
					sb.append("\n��ַ : ");
					sb.append("\n");
					sb.append(location.getAddrStr());
				}
			}

			logMsg(sb.toString());
			Log.e("sb", sb.toString());
		}

		public void onReceivePoi(BDLocation poiLocation) {
			if (poiLocation == null) {
				return;
			}
			StringBuffer sb = new StringBuffer(256);
			sb.append("Poi time : ");
			sb.append(poiLocation.getTime());
			sb.append("\nerror code : ");
			sb.append(poiLocation.getLocType());
			sb.append("\nlatitude : ");
			sb.append(poiLocation.getLatitude());
			sb.append("\nlontitude : ");
			sb.append(poiLocation.getLongitude());
			sb.append("\nradius : ");
			sb.append(poiLocation.getRadius());
			if (poiLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
				sb.append("\naddr : ");
				sb.append(poiLocation.getAddrStr());
			}
			/*if (poiLocation.hasPoi()) {
				sb.append("\nPoi:");
				sb.append(poiLocation.getPoi());
			} else {
				sb.append("noPoi information");
			}*/
		}
	}

	private void setLocationOption() {
		LocationClientOption option = new LocationClientOption();
		option.setServiceName("com.baidu.location.service_v2.6");

		// ��Ҫ��ַ��Ϣ������Ϊ�����κ�ֵ��string���ͣ��Ҳ���Ϊnull��ʱ������ʾ�޵�ַ��Ϣ��
		option.setAddrType("all");
		// �����Ƿ񷵻�POI�ĵ绰�͵�ַ����ϸ��Ϣ��Ĭ��ֵΪfalse����������POI�ĵ绰�͵�ַ��Ϣ��
		//option.setPoiExtraInfo(true);

		// ���ò�Ʒ�����ơ�ǿ�ҽ�����ʹ���Զ���Ĳ�Ʒ�����ƣ����������Ժ�Ϊ���ṩ����Ч׼ȷ�Ķ�λ����
		option.setProdName("ͨ��GPS��λ�ҵ�ǰ��λ��");

		// ����GPS��ʹ��gpsǰ�����û�Ӳ����gps��Ĭ���ǲ���gps�ġ�
		option.setOpenGps(true);

		// ��λ��ʱ��������λ��ms
		// �����������ֵ���ڵ���1000��ms��ʱ����λSDK�ڲ�ʹ�ö�ʱ��λģʽ��
		option.setScanSpan(500);

		// ��ѯ��Χ��Ĭ��ֵΪ500�����Ե�ǰ��λλ��Ϊ���ĵİ뾶��С��
		//option.setPoiDistance(500);
		// �������û��涨λ����
		option.disableCache(true);

		// ����ϵ���ͣ��ٶ��ֻ���ͼ����ӿ��е�����ϵĬ����bd09ll
		option.setCoorType("bd09ll");

		// �������ɷ��ص�POI������Ĭ��ֵΪ3������POI��ѯ�ȽϺķ�������������෵�ص�POI�������Ա��ʡ������
		//option.setPoiNumber(3);

		// ���ö�λ��ʽ�����ȼ���
		// ��gps���ã����һ�ȡ�˶�λ���ʱ�����ٷ�����������ֱ�ӷ��ظ��û����ꡣ���ѡ���ʺ�ϣ���õ�׼ȷ����λ�õ��û������gps�����ã��ٷ����������󣬽��ж�λ��
		option.setPriority(LocationClientOption.GpsFirst);
		//option.setPoiExtraInfo(true);
		mLocationClient.setLocOption(option);
	}

}
