package com.example.preparedtofun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ShowToast")
public class QueueNextActivity extends Activity {
	private Intent intent = new Intent();
	private LinearLayout horily;
	private ImageView item_ima1;
	private TextView item_tx1, item_tx2;
	private ListView schlists;
	private int[] pic_id = { R.drawable.shengui11, R.drawable.jintianmodaotuan,
			R.drawable.zhiqingchun, R.drawable.hanzhan2,
			R.drawable.shangjinlieren };
	private String[] tx1_id = { "忍者神龟", "今天魔盗团", "致青春", "寒战2", "赏金猎人" };
	private String[] tx2_id = { "8.7分", "8.6分", "8.9分", "9.0分", "8.6分" };

	private ImageView title_return_left_image;
	private TextView title_return_left_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_queue_next);
		initView();
		initEvent();
	}

	@SuppressLint("NewApi")
	private void initView() {
		schlists = (ListView) findViewById(R.id.search_lists);
		horily = (LinearLayout) findViewById(R.id.horily);
		title_return_left_image = (ImageView) findViewById(R.id.title_return_left_image);
		title_return_left_text = (TextView) findViewById(R.id.title_return_left_text);
		title_return_left_text.setText("电影票预订");
		for (int k = 0; k < pic_id.length; k++) {
			View dayofcliamte = LayoutInflater.from(QueueNextActivity.this)
					.inflate(R.layout.movie_item_detail, null);
			item_ima1 = (ImageView) dayofcliamte
					.findViewById(R.id.movie_bk_item_ima1);
			item_tx1 = (TextView) dayofcliamte
					.findViewById(R.id.movie_bk_item_tx1);
			item_tx2 = (TextView) dayofcliamte
					.findViewById(R.id.movie_bk_item_tx2);
			item_ima1.setBackground(getResources().getDrawable(pic_id[k]));
			item_tx1.setText(tx1_id[k]);
			item_tx2.setText(tx2_id[k]);
			horily.addView(dayofcliamte);
		}
	}

	private void initEvent() {
		SimpleAdapter adapter = new SimpleAdapter(QueueNextActivity.this,
				getData(), R.layout.list_movie_item1, new String[] { "tx1",
						"tx2", "tx3", "tx4" }, new int[] { R.id.ls_tx_item1,
						R.id.ls_tx_item2, R.id.ls_tx_item3, R.id.ls_tx_item4 });
		schlists.setAdapter(adapter);
		schlists.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				jumpto();
			}
		});

		title_return_left_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tx1", "天河欢乐汇影城");
		map.put("tx2", "¥25起");
		map.put("tx3", "当前平均排队情况：30人  等待所需时间：15分钟");
		map.put("tx4", "750m");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "百瑞景天河国际影城");
		map.put("tx2", "¥28起");
		map.put("tx3", "当前平均排队情况：20人  等待所需时间：15分钟");
		map.put("tx4", "980m");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "洪山天河国际影城");
		map.put("tx2", "¥28起");
		map.put("tx3", "当前平均排队情况：12人  等待所需时间：10分钟");
		map.put("tx4", "1280m");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "百老汇影城");
		map.put("tx2", "¥26起");
		map.put("tx3", "当前平均排队情况：18人  等待所需时间：14分钟");
		map.put("tx4", "1950m");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "金逸影城（南湖店）");
		map.put("tx2", "¥29起");
		map.put("tx3", "当前平均排队情况：40人  等待所需时间：30分钟");
		map.put("tx4", "2.0km");
		list.add(map);
		return list;
	}

	private void jumpto() {
		intent.setClass(QueueNextActivity.this, BuyMovieTicketActivity.class);
		startActivity(intent);
	}
}
