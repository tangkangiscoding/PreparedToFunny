package com.example.preparedtofun.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.preparedtofun.QueueActivity;
import com.example.preparedtofun.R;
import com.example.preparedtofun.SearchClearEditText;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainHomeFragment extends Fragment implements ActionBar.TabListener {

	Resources resources;
	private ViewPager mPager;
	ActionBar actionBar;
	public final static int num = 2;
	Fragment home1;
	Fragment home2;

	Context context;
	final List<MenuItem> menus = new ArrayList<MenuItem>();

	private GridView gview;
	private List<Map<String, Object>> data_list;
	private SimpleAdapter sim_adapter;
	// 图片封装为一个数组
	private int[] icon = { R.drawable.scene2, R.drawable.hospital3,
			R.drawable.bank3, R.drawable.fly, R.drawable.delicious11,
			R.drawable.map11 };
	private String[] iconName = { "景点", "医院", "银行", "机票", "美食", "我的位置" };

	private Intent intent = new Intent();

	private MyCallBacks mcallbacks;

	private TextView search_bar_finish;
	private SearchClearEditText edit1;

	@Override
	public void onAttach(Activity activity) {
		// TODO 自动生成的方法存根
		super.onAttach(activity);
		if (!(activity instanceof MyCallBacks)) {
			throw new IllegalStateException("很抱歉，MainHomeFragment程序出现错误!");
		}
		mcallbacks = (MyCallBacks) activity;
	}

	public interface MyCallBacks {
		public void onMyCallBacks(int which);
	}

	@Override
	public void onDetach() {
		// TODO 自动生成的方法存根
		super.onDetach();
		mcallbacks = null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_home, container,
				false);
		findView(view);
		init();
		initView(view);
		initEvent();
		return view;
	}

	private void findView(View v) {
		// home_grid = (GridView) v.findViewById(R.id.home_grid);
	}

	private void initView(View parentView) {
		gview = (GridView) parentView.findViewById(R.id.gview);
		search_bar_finish = (TextView) parentView
				.findViewById(R.id.search_bar_finish);
		edit1 = (SearchClearEditText) parentView
				.findViewById(R.id.search_bar_text);
		resources = getResources();

		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

	}

	@SuppressLint("ShowToast")
	private void initEvent() {
		search_bar_finish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				String edittext = edit1.getText().toString();
				if (!edittext.equals("") && !edittext.equals(null)) {
					if (edittext.equals("欢乐谷")) {
						intent.setClass(getActivity(), QueueActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(getActivity(), "搜索内容检索不到！",
								Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(getActivity(), "搜索内容不能为空！",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 新建List
		data_list = new ArrayList<Map<String, Object>>();
		// 获取数据
		getData();
		// 新建适配器
		String[] from = { "image", "text" };
		int[] to = { R.id.item_image, R.id.item_text };
		sim_adapter = new SimpleAdapter(getActivity(), data_list,
				R.layout.item, from, to);
		// 配置适配器
		gview.setAdapter(sim_adapter);
		gview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				mcallbacks.onMyCallBacks(position);
			}
		});
	}

	private void init() {
		context = this.getActivity();
	}

	public List<Map<String, Object>> getData() {
		// cion和iconName的长度是相同的，这里任选其一都可以
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			data_list.add(map);
		}

		return data_list;
	}

	/*
	 * private void jumpTo(int position){ bundle = new Bundle(); intent = new
	 * Intent(); switch (position) { case 0: //MainHomeFragment ma1 = new
	 * MainHomeFragment();
	 * 
	 * bundle.putInt("Which", 0); //ma1.setArguments(bundle);
	 * intent.putExtras(bundle); intent = new Intent(getActivity(),
	 * Hotel.class); startActivity(intent); break; case 1:
	 * bundle.putInt("Which", 1); intent.putExtras(bundle); intent = new
	 * Intent(getActivity(), Hotel.class); startActivity(intent); break; case 2:
	 * bundle.putInt("Which", 2); intent.putExtras(bundle); intent = new
	 * Intent(getActivity(), Hotel.class); startActivity(intent); break; case 3:
	 * bundle.putInt("Which", 3); intent.putExtras(bundle); intent = new
	 * Intent(getActivity(), Hotel.class); startActivity(intent); case 4:
	 * bundle.putInt("Which", 4); intent.putExtras(bundle); intent = new
	 * Intent(getActivity(), PeopleFragment.class); startActivity(intent);
	 * break; case 5: bundle.putString("Which", "5"); intent.putExtras(bundle);
	 * intent = new Intent(getActivity(), Hotel.class); startActivity(intent);
	 * case 6: bundle.putString("Which", "3"); intent.putExtras(bundle); intent
	 * = new Intent(getActivity(), Hotel.class); startActivity(intent); case 7:
	 * bundle.putString("Which", "4"); intent.putExtras(bundle); intent = new
	 * Intent(getActivity(), Hotel.class); startActivity(intent); break; case 8:
	 * bundle.putString("Which", "5"); intent.putExtras(bundle); intent = new
	 * Intent(getActivity(), Hotel.class); startActivity(intent); break;
	 * default: break; } }
	 */

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
