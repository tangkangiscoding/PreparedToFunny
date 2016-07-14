package com.example.preparedtofun;

import java.util.ArrayList;

import com.example.preparedtofun.fragment.MainHomeFragment;
import com.example.preparedtofun.fragment.MainHomeFragment.MyCallBacks;
import com.example.preparedtofun.fragment.SightFragment.MySightCallBacks;
import com.example.preparedtofun.fragment.PeopleFragment;
import com.example.preparedtofun.fragment.SOSFragment;
import com.example.preparedtofun.fragment.SettingFragment;
import com.example.preparedtofun.fragment.SightFragment;

import android.os.Build;
import android.os.Bundle;
import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressLint("Override")
public class MainActivity extends FragmentActivity implements MyCallBacks,
		MySightCallBacks {
	private final int SDK_PERMISSION_REQUEST = 127;
	private RadioGroup bottomRg;
	private FragmentManager fragmentManager;
	private FragmentTransaction transaction;
	private Intent intent = new Intent();
	private Bundle bundle = new Bundle();
	@SuppressWarnings("unused")
	private static final int NOTIFICATION_FLAG = 1;
	@SuppressWarnings("unused")
	private RadioButton main_radio_home, main_radio_sight, main_radio_people,
			main_radio_share, main_radio_my;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initEvent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initData() {
		fragmentManager = getSupportFragmentManager();
		transaction = fragmentManager.beginTransaction();
		Fragment fragment = new MainHomeFragment();
		transaction.replace(R.id.content, fragment);
		transaction.commit();
		getPersimmions();
	}

	private void initView() {
		bottomRg = (RadioGroup) findViewById(R.id.main_radiogroup);
		main_radio_home = (RadioButton) findViewById(R.id.main_radio_home);
		main_radio_sight = (RadioButton) findViewById(R.id.main_radio_sight);
		main_radio_people = (RadioButton) findViewById(R.id.main_radio_people);
		main_radio_share = (RadioButton) findViewById(R.id.main_radio_share);
		main_radio_my = (RadioButton) findViewById(R.id.main_radio_my);

		// ������������Ϣ������

		// main_bt_message = (Button)findViewById(R.id.main_bt_message);
		// mFragments = new Fragment[5];
		fragmentManager = getSupportFragmentManager();
	}

	private void initEvent() {

		bottomRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.main_radio_home:
					transaction = fragmentManager.beginTransaction();
					Fragment homeFragment = new MainHomeFragment();
					transaction.replace(R.id.content, homeFragment);
					transaction.commit();
					break;
				case R.id.main_radio_sight:
					transaction = fragmentManager.beginTransaction();
					Fragment sightFragment = new SightFragment();
					transaction.replace(R.id.content, sightFragment);
					transaction.commit();

					// messagebadge.setText(String.valueOf(unreadnum));
					/*
					 * if(unreadnum == 0){ messagebadge.hide();//Ӱ����ʾ }else{
					 * messagebadge.show();// ֻ����ʾ
					 * messagebadge.setText(String.valueOf(unreadnum)); }
					 */
					break;
				case R.id.main_radio_people:
					transaction = fragmentManager.beginTransaction();
					Fragment peopleFragment = new PeopleFragment();
					transaction.replace(R.id.content, peopleFragment);
					transaction.commit();
					break;
				case R.id.main_radio_share:
					transaction = fragmentManager.beginTransaction();
					Fragment SosFragment = new SOSFragment();
					transaction.replace(R.id.content, SosFragment);
					transaction.commit();
					break;
				case R.id.main_radio_my:
					transaction = fragmentManager.beginTransaction();
					Fragment settingFragment = new SettingFragment();
					transaction.replace(R.id.content, settingFragment);
					transaction.commit();
					break;

				default:
					break;
				}
			}
		});
	}
	
	@TargetApi(23)
	private void getPersimmions() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			ArrayList<String> permissions = new ArrayList<String>();
			/***
			 * ��λȨ��Ϊ����Ȩ�ޣ��û������ֹ����ÿ�ν��붼������
			 */
			// ��λ��ȷλ��
			if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
				permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
			}
			if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
				permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
			}
			/*
			 * ��дȨ�޺͵绰״̬Ȩ�޷Ǳ�ҪȨ��(��������)ֻ������һ�Σ��û�ͬ����߽�ֹ��ֻ�ᵯһ��
			 */
			/*// ��дȨ��
			if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
				permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
			}
			// ��ȡ�绰״̬Ȩ��
			if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
				permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
			}*/
			
			if (permissions.size() > 0) {
				requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
			}
		}
	}
	
	@TargetApi(23)
	private boolean addPermission(ArrayList<String> permissionsList, String permission) {
		if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // ���Ӧ��û�л�ö�ӦȨ��,����ӵ��б���,׼����������	
			if (shouldShowRequestPermissionRationale(permission)){
				return true;
			}else{
				permissionsList.add(permission);
				return false;
			}
				
		}else{
			return true;
		}
	}

	/*@TargetApi(23)
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		
	}*/


	/* { "����","ҽԺ","����","�Ƶ�", "��Ʊ", "��ʳ", "�ҵ�λ��" }; */
	@Override
	public void onMyCallBacks(int which) {
		// TODO �Զ����ɵķ������
		switch (which) {
		case 0:// ����
			transaction = fragmentManager.beginTransaction();
			Fragment sightFragment = new SightFragment();
			transaction.replace(R.id.content, sightFragment);
			transaction.commit();
			break;
		case 1:// ҽԺ
			intent = new Intent(MainActivity.this, Hotel.class);
			bundle.putString("Which", "1");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 2:// ����
			intent = new Intent(MainActivity.this, Hotel.class);
			bundle.putString("Which", "2");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		/*
		 * case 3://�Ƶ� intent = new Intent(MainActivity.this, Hotel.class);
		 * bundle.putString("Which", "3"); intent.putExtras(bundle);
		 * startActivity(intent); break;
		 */
		case 3:// ��Ʊ
			intent = new Intent(MainActivity.this, Hotel.class);
			bundle.putString("Which", "4");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 4:// û��
			intent = new Intent(MainActivity.this, Hotel.class);
			bundle.putString("Which", "5");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 5:// �ҵ�λ��
			Intent intent1 = new Intent(MainActivity.this,
					LocationFilter.class);
			startActivity(intent1);
			break;

		}
	}

	@SuppressLint("ShowToast")
	@Override
	public void onMySightCallBacks(int which) {
		// TODO �Զ����ɵķ������
		switch (which) {
		case 0:
			intent = new Intent(MainActivity.this, QueueActivity.class);
			bundle.putString("Which", "0");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(MainActivity.this, QueueActivity.class);
			bundle.putString("Which", "1");
			intent.putExtras(bundle);
			startActivity(intent);

			break;
		case 2:
			intent = new Intent(MainActivity.this, QueueActivity.class);
			bundle.putString("Which", "2");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 3:
			intent = new Intent(MainActivity.this, QueueActivity.class);
			bundle.putString("Which", "3");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		}
	}
}
