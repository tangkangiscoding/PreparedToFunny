package com.example.preparedtofun.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.preparedtofun.QueueActivity;
import com.example.preparedtofun.R;

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
import android.widget.ImageView;
import android.widget.TextView;

public class PeopleFragment extends Fragment implements ActionBar.TabListener {
	Resources resources;
	private ViewPager mPager;
	ActionBar actionBar;
	public final static int num = 2;
	Fragment home1;
	Fragment home2;
	private ImageView ima1, ima2, ima3;
	private TextView tx1;
	Context context;
	final List<MenuItem> menus = new ArrayList<MenuItem>();
	private boolean visibility_Flag;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_people, container, false);
		findView(view);
		init();
		initEvent();
		return view;
	}

	private void findView(View v) {
		ima1 = (ImageView) v.findViewById(R.id.dengious_pic1);
		ima2 = (ImageView) v.findViewById(R.id.dengious_pic2);
		ima3 = (ImageView) v.findViewById(R.id.dengious_pic3);
		tx1 = (TextView) v.findViewById(R.id.dengious_tex1);
		ima1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if (visibility_Flag) {
					ima2.setVisibility(View.INVISIBLE);
					tx1.setVisibility(View.INVISIBLE);
					visibility_Flag = false;
				} else {
					ima2.setVisibility(View.VISIBLE);
					tx1.setVisibility(View.VISIBLE);
					visibility_Flag = true;
				}
			}
		});
		ima3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(getActivity(), QueueActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("Which", "11");
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}

	private void initEvent() {

	}

	private void init() {
		context = this.getActivity();
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	// 当指定Tab被选中时激发该方法
	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		mPager.setCurrentItem(tab.getPosition()); // ②
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}
}
