package com.example.preparedtofun.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.preparedtofun.R;
import com.example.preparedtofun.fragment.MainHomeFragment.MyCallBacks;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class SightFragment extends Fragment implements ActionBar.TabListener,
		OnClickListener {
	Resources resources;
	private ViewPager mPager;
	ActionBar actionBar;
	public final static int num = 2;
	Fragment home1;
	Fragment home2;

	Context context;
	final List<MenuItem> menus = new ArrayList<MenuItem>();

	// 图片封装为一个数组

	private ImageButton sbtn_around, sbtn_order, sbtn_choose;
	private ListView schlists;

	private MySightCallBacks mcallbacks;

	private TextView book_order_tx1, book_order_tx2,book_order_tx21,book_order_tx22, book_order_tx3,
					 book_order_tx31,book_order_tx32,book_order_tx33;

	@Override
	public void onAttach(Activity activity) {
		// TODO 自动生成的方法存根
		super.onAttach(activity);
		if (!(activity instanceof MyCallBacks)) {
			throw new IllegalStateException("很抱歉，MainHomeFragment程序出现错误!");
		}
		mcallbacks = (MySightCallBacks) activity;
	}

	public interface MySightCallBacks {
		public void onMySightCallBacks(int which);
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
		View view = inflater.inflate(R.layout.fragment_sight, container, false);
		findView(view);
		initView(view);
		initEvent();
		return view;
	}

	@SuppressLint("NewApi")
	private void findView(View v) {
		sbtn_around = (ImageButton) v.findViewById(R.id.sbtn_around);
		sbtn_order = (ImageButton) v.findViewById(R.id.sbtn_order);
		sbtn_choose = (ImageButton) v.findViewById(R.id.sbtn_choose);
		book_order_tx1 = (TextView) v.findViewById(R.id.book_order_tx1);
		book_order_tx2 = (TextView) v.findViewById(R.id.book_order_tx2);
		book_order_tx3 = (TextView) v.findViewById(R.id.book_order_tx3);
		book_order_tx21 = (TextView) v.findViewById(R.id.book_order_tx21);
		book_order_tx22 = (TextView) v.findViewById(R.id.book_order_tx22);
		book_order_tx31 = (TextView) v.findViewById(R.id.book_order_tx31);
		book_order_tx32 = (TextView) v.findViewById(R.id.book_order_tx32);
		book_order_tx33 = (TextView) v.findViewById(R.id.book_order_tx33);
		schlists = (ListView) v.findViewById(R.id.search_lists);

		sbtn_around.setBackground(getResources().getDrawable(
				R.drawable.blue_dot));
		sbtn_choose.setBackground(getResources().getDrawable(
				R.drawable.gray_dot0));
		sbtn_order.setBackground(getResources().getDrawable(
				R.drawable.gray_dot0));
	}

	private void initView(View parentView) {
		resources = getResources();
	}

	private void initEvent() {
		book_order_tx1.setOnClickListener(this);
		book_order_tx2.setOnClickListener(this);
		book_order_tx3.setOnClickListener(this);
		book_order_tx21.setOnClickListener(this);
		book_order_tx22.setOnClickListener(this);
		book_order_tx31.setOnClickListener(this);
		book_order_tx32.setOnClickListener(this);
		book_order_tx33.setOnClickListener(this);
		initAdapter(1);
	}
	
	private void initAdapter(int temp){
		SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData(temp),
				R.layout.list_search_item1, new String[] { "img", "tx1", "tx2",
						"tx3" }, new int[] { R.id.search_image_item,
						R.id.search_tx_item1, R.id.search_tx_item2,
						R.id.search_tx_item3 });
		schlists.setAdapter(adapter);
		schlists.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				mcallbacks.onMySightCallBacks(position);
				// jumpto(position);
			}
		});
	}

	private List<Map<String, Object>> getData(int temp) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		map1.put("img", R.drawable.huanlegu);
		map1.put("tx1", "欢乐谷");
		map1.put("tx2", "游泳项目--距离500米");
		map1.put("tx3", "当前平均排队人数：130人   等待时间：30分钟");
		
		map2.put("img", R.drawable.haunghelou);
		map2.put("tx1", "黄鹤楼");
		map2.put("tx2", "旅游景点--距离800米");
		map2.put("tx3", "当前平均排队人数：60人   等待时间：15分钟");

		map3.put("img", R.drawable.wandayinyuan);
		map3.put("tx1", "万达电影院");
		map3.put("tx2", "游乐项目--距离1.5千米");
		map3.put("tx3", "当前平均排队人数：100人   等待时间：20分钟");
		

		map4.put("img", R.drawable.luyu);
		map4.put("tx1", "鲈鱼山庄");
		map4.put("tx2", "美食店--距离2千米");
		map4.put("tx3", "当前平均排队人数：70人   等待时间：25分钟");
		
		if(temp==1){
			list.add(map1);
			list.add(map2);
			list.add(map3);
			list.add(map4);
		}else if(temp==2){
			list.add(map2);
			list.add(map4);
			list.add(map3);
			list.add(map1);
		}else if(temp==22){
			list.add(map2);
			list.add(map3);
			list.add(map4);
			list.add(map1);
		}else if(temp==3){
			list.add(map2);
			list.add(map1);
		}else if(temp==32){
			list.add(map3);
		}else if(temp==33){
			list.add(map4);
		}
		
		return list;
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

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.book_order_tx1:
			sbtn_around.setBackground(getResources().getDrawable(
					R.drawable.blue_dot));
			book_order_tx1.setTextColor(getResources().getColor(
					R.color.nw_bt_blue));
			sbtn_choose.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			book_order_tx2.setTextColor(getResources().getColor(
					R.color.nw_bg_black));
			sbtn_order.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			book_order_tx3.setTextColor(getResources().getColor(
					R.color.nw_bg_black));
			
			book_order_tx21.setVisibility(View.GONE);
			book_order_tx22.setVisibility(View.GONE);
			book_order_tx31.setVisibility(View.GONE);
			book_order_tx32.setVisibility(View.GONE);
			book_order_tx33.setVisibility(View.GONE);
			initAdapter(1);
			break;
		case R.id.book_order_tx3:
			sbtn_choose.setBackground(getResources().getDrawable(
					R.drawable.blue_dot));
			book_order_tx1.setTextColor(getResources().getColor(
					R.color.nw_bg_black));
			sbtn_around.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			book_order_tx3.setTextColor(getResources().getColor(
					R.color.nw_bt_blue));
			sbtn_order.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			book_order_tx2.setTextColor(getResources().getColor(
					R.color.nw_bg_black));
			
			book_order_tx21.setVisibility(View.GONE);
			book_order_tx22.setVisibility(View.GONE);
			book_order_tx31.setVisibility(View.VISIBLE);
			book_order_tx32.setVisibility(View.VISIBLE);
			book_order_tx33.setVisibility(View.VISIBLE);
			break;
		case R.id.book_order_tx2:
			sbtn_order.setBackground(getResources().getDrawable(
					R.drawable.blue_dot));
			book_order_tx1.setTextColor(getResources().getColor(
					R.color.nw_bg_black));
			sbtn_choose.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			book_order_tx3.setTextColor(getResources().getColor(
					R.color.nw_bg_black));
			sbtn_around.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			book_order_tx2.setTextColor(getResources().getColor(
					R.color.nw_bt_blue));
			
			book_order_tx21.setVisibility(View.VISIBLE);
			book_order_tx22.setVisibility(View.VISIBLE);
			book_order_tx31.setVisibility(View.GONE);
			book_order_tx32.setVisibility(View.GONE);
			book_order_tx33.setVisibility(View.GONE);
			initAdapter(2);
			break;
		case R.id.book_order_tx21:
			initAdapter(2);
			break;
		case R.id.book_order_tx22:
			initAdapter(22);
			break;
		case R.id.book_order_tx31:
			initAdapter(3);
			break;
		case R.id.book_order_tx32:
			initAdapter(32);
			break;
		case R.id.book_order_tx33:
			initAdapter(33);
			break;
		default:
			break;
		}
	}
}
