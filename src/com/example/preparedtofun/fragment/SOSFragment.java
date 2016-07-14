package com.example.preparedtofun.fragment;

import java.util.ArrayList;
import java.util.List;
import com.example.preparedtofun.R;
import com.example.preparedtofun.SOSToSecureActivity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SOSFragment extends Fragment implements ActionBar.TabListener {
	Resources resources;
	private ViewPager mPager;
	ActionBar actionBar;
	public final static int num = 2;
	Fragment home1;
	Fragment home2;
	Context context;
	final List<MenuItem> menus = new ArrayList<MenuItem>();
	// ͼƬ��װΪһ������
	private Intent intent = new Intent();
	private LinearLayout ly_sos1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_sos, container, false);
		findView(view);
		return view;
	}

	private void findView(View v) {
		ly_sos1 = (LinearLayout) v.findViewById(R.id.ly_sos1);
		ly_sos1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				intent.setClass(getActivity(), SOSToSecureActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	// ��ָ��Tab��ѡ��ʱ�����÷���
	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		mPager.setCurrentItem(tab.getPosition()); // ��
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}
}
