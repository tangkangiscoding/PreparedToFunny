package com.example.preparedtofun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ShowToast")
public class QueueForFunActivity extends Activity {

	private Intent intent = new Intent();
	private Bundle bundle = new Bundle();
	private static final int NOTIFICATION_FLAG = 1;
	private ListView search_lists;
	private List<Map<String, Object>> lists1 = new ArrayList<Map<String, Object>>();
	private boolean clickflag = true;
	private ImageView title_return_left_image;
	private TextView title_return_left_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_queue_for_fun);
		initView();
		initEvent();
	}

	@SuppressLint("NewApi")
	private void initView() {
		search_lists = (ListView) findViewById(R.id.search_for_fun_lists);
		lists1 = getData();
		title_return_left_image = (ImageView) findViewById(R.id.title_return_left_image);
		title_return_left_text = (TextView) findViewById(R.id.title_return_left_text);
		title_return_left_text.setText("我要排队");
	}

	private void initEvent() {

		MyAdapter mAdapter = new MyAdapter(this);// 得到一个MyAdapter对象
		search_lists.setAdapter(mAdapter);
		search_lists.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("MyListViewBase", "你点击了ListView条目" + arg2);// 在LogCat中输出信息
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

	private class MyAdapter extends BaseAdapter {
		private LayoutInflater mInflater;// 得到一个LayoutInfalter对象用来导入布局

		/** 构造函数 */
		public MyAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO 自动生成的方法存根
			return lists1.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO 自动生成的方法存根
			return 0;
		}

		@SuppressWarnings("deprecation")
		@SuppressLint("NewApi")
		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO 自动生成的方法存根
			ViewHolder holder = null;
			// 观察convertView随ListView滚动情况
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_hunalegu_item1,
						null);
				holder = new ViewHolder();
				/** 得到各个控件的对象 */
				// holder.imag = (ImageView)
				// convertView.findViewById(R.id.huanlegu_image_item);
				holder.tx1 = (TextView) convertView
						.findViewById(R.id.huanlegu_tx_item1);
				holder.tx2 = (TextView) convertView
						.findViewById(R.id.huanlegu_tx_item2);
				holder.tx3 = (TextView) convertView
						.findViewById(R.id.huanlegu_tx_item3);
				holder.btn = (Button) convertView
						.findViewById(R.id.huanlegu_btn);
				convertView.setTag(holder);// 绑定ViewHolder对象
			} else {
				holder = (ViewHolder) convertView.getTag();// 取出ViewHolder对象
			}
			/** 设置TextView显示的内容，即我们存放在动态数组中的数据 */
			holder.tx1.setText(lists1.get(position).get("tx1").toString());
			holder.tx2.setText(lists1.get(position).get("tx2").toString());
			holder.tx3.setText(lists1.get(position).get("tx3").toString());
			/** 为Button添加点击事件 */
			holder.btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Log.v("MyListViewBase", "你点击了按钮" + position);// 打印Button的点击信息
					clickflag = false;
					NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
			           //API level 11
			           Notification.Builder builder = new Notification.Builder(QueueForFunActivity.this);
			           builder.setAutoCancel(true);
			           builder.setDefaults(Notification.DEFAULT_SOUND);
			           builder.setContentTitle(lists1.get(position).get("tx1")
								.toString()
								+ "：恭喜您排队成功");
			           builder.setContentText("您的号码为17号，请按号游玩！");
			           builder.setSmallIcon(R.drawable.ic_launcher);
			           Notification notification = builder.getNotification();
			           manager.notify(R.drawable.ic_launcher, notification);
					/*// 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
					NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
					// 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以
					// 采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
					PendingIntent pendingIntent = PendingIntent.getActivity(
							QueueForFunActivity.this, 0, new Intent(
									QueueForFunActivity.this,
									QueueForFunActivity.class), 0);
					// 下面需兼容Android 2.x版本是的处理方式
					// Notification notify1 = new
					// Notification(R.drawable.message,
					// "TickerText:" + "您有新短消息，请注意查收！",
					// System.currentTimeMillis());
					Notification notify1 = new Notification();
					notify1.icon = R.drawable.luyudian11;
					notify1.tickerText = lists1.get(position).get("tx1")
							.toString()
							+ "：恭喜您排队成功";
					notify1.when = System.currentTimeMillis();
					notify1.setLatestEventInfo(QueueForFunActivity.this, lists1
							.get(position).get("tx1").toString()
							+ "：恭喜" + "您排队成功", "您的号码为17号，请按号游玩！", pendingIntent);
					notify1.defaults = Notification.DEFAULT_SOUND;
					notify1.number = 1;
					notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
					// 通过通知管理器来发起通知。如果id不同，则每click，在statu那里增加一个提示
					manager.notify(NOTIFICATION_FLAG, notify1);*/
				}
			});

			if (!clickflag) {
				holder.btn.setClickable(clickflag);
				holder.btn.setBackground(getResources().getDrawable(
						R.drawable.queueforoneno));
			}
			return convertView;
		}
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tx1", "霹雳神车");
		map.put("tx2", "推荐指数：2颗星");
		map.put("tx3", "当前平均排队人数：30人   等待时间：30分钟");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "太阳神车");
		map.put("tx2", "推荐指数：4颗星");
		map.put("tx3", "当前平均排队人数：60人   等待时间：15分钟");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "蒙地卡罗赛道");
		map.put("tx2", "推荐指数：3颗星");
		map.put("tx3", "当前平均排队人数：80人   等待时间：20分钟");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "激流勇进");
		map.put("tx2", "推荐指数：4颗星");
		map.put("tx3", "当前平均排队人数：60人   等待时间：25分钟");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "异度空间");
		map.put("tx2", "推荐指数：3颗星");
		map.put("tx3", "当前平均排队人数：35人   等待时间：15分钟");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "天地双雄");
		map.put("tx2", "推荐指数：4颗星");
		map.put("tx3", "当前平均排队人数：40人   等待时间：20分钟");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("tx1", "木翼双龙");
		map.put("tx2", "推荐指数：3颗星");
		map.put("tx3", "当前平均排队人数：50人   等待时间：25分钟");
		list.add(map);

		return list;
	}

	public void jumpto(int which) {
		// TODO 自动生成的方法存根
		switch (which) {
		case 0:
			intent = new Intent(QueueForFunActivity.this,
					QueueForFunActivity.class);
			bundle.putString("Which", "0");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(QueueForFunActivity.this,
					QueueForFunActivity.class);
			bundle.putString("Which", "1");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 2:
			intent = new Intent(QueueForFunActivity.this, QueueActivity.class);
			bundle.putString("Which", "2");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case 3:
			intent = new Intent(QueueForFunActivity.this, QueueActivity.class);
			bundle.putString("Which", "3");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		}
	}

	/** 存放控件 */

	public final class ViewHolder {

		public TextView tx1;

		public TextView tx2;

		public TextView tx3;

		private Button btn;

	}
}
