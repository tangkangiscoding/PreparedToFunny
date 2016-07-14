package com.example.preparedtofun;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class QueueActivity extends Activity implements OnClickListener {
	private LinearLayout ly_tk1, ly_tk2, ly_tk3;
	private ImageButton btn_tk1, btn_tk2, btn_tk3;
	private Button queue_btn1, queue_btn2;
	private TextView tx1, tx2, tx3, tx4;
	private LinearLayout queue_ly1;
	private String str = "0";
	private Intent intent = new Intent();
	private static final int NOTIFICATION_FLAG = 1;
	private ImageView title_return_left_image;
	private TextView title_return_left_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_queue);
		initData();
		initView();
		initEvent();
	}

	private void initData() {
		intent = getIntent();
		if (intent != null) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				str = bundle.getString("Which");
			}
		}
	}

	@SuppressLint("NewApi")
	private void initView() {
		ly_tk1 = (LinearLayout) findViewById(R.id.ly_ticket1);
		ly_tk2 = (LinearLayout) findViewById(R.id.ly_ticket2);
		ly_tk3 = (LinearLayout) findViewById(R.id.ly_ticket3);
		btn_tk1 = (ImageButton) findViewById(R.id.sbtn_around1);
		btn_tk2 = (ImageButton) findViewById(R.id.sbtn_order1);
		btn_tk3 = (ImageButton) findViewById(R.id.sbtn_choose1);
		queue_btn1 = (Button) findViewById(R.id.queue_btn1);
		queue_btn2 = (Button) findViewById(R.id.queue_btn2);
		tx2 = (TextView) findViewById(R.id.queue_tx2);
		tx1 = (TextView) findViewById(R.id.queue_tx1);
		tx3 = (TextView) findViewById(R.id.queue_tx3);
		tx4 = (TextView) findViewById(R.id.queue_tx4);
		queue_ly1 = (LinearLayout) findViewById(R.id.queue_ly1);
		title_return_left_image = (ImageView) findViewById(R.id.title_return_left_image);
		title_return_left_text = (TextView) findViewById(R.id.title_return_left_text);
		title_return_left_text.setText("排队预约");
		if (str.equals("0")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.huanlegu123));
			queue_btn1.setText("门票预订");
			queue_btn1.setVisibility(View.VISIBLE);
			queue_btn2.setText("我要排队");
			tx1.setText("欢乐谷（票价：120元）");
			tx2.setText("时间：12：00~18:00 18:00~00:00");
			tx3.setText("地址：湖北省武汉市洪山区欢乐大道196号");
			tx4.setText("简介：武汉欢乐谷是深圳华侨城集团继深圳、北京、成都、上海之后，在我国中部地区倾力打造的复合型、"
					+ "生态型和创新型的大型文化公园。武汉欢乐谷拥有亚洲首座双龙木质过山车、国内最大的人工造浪沙滩、最大室"
					+ "内家庭数字娱乐中心、武汉最大的专业剧场等50多项游乐设施。");
		} else if (str.equals("1")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.haunghelou));
			queue_btn1.setText("门票预订");
			queue_btn1.setVisibility(View.VISIBLE);
			queue_btn2.setVisibility(View.GONE);
			tx1.setText("黄鹤楼（票价：60元）");
			tx2.setText("时间：9：00~20:00");
			tx3.setText("地址：武珞路阅马场");
			tx4.setText("简介：黄鹤楼位于湖北省武汉市长江南岸的武昌蛇山之巅，为国家5A级旅游景区，享有“天下江山第一楼“"
					+ "、”天下绝景“之称。黄鹤楼是武汉市标志性建筑，与晴川阁、古琴台并称“武汉三大名胜”。该建筑也与湖南岳"
					+ "阳楼、江西南昌滕王阁并称为“江南三大名楼”。");
		} else if (str.equals("2")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.wandayinyuan));
			queue_btn1.setVisibility(View.VISIBLE);
			queue_btn2.setVisibility(View.GONE);
			tx1.setText("推荐：捉妖记（票价：35元）");
			tx2.setText("时间：09：00~11:30 18:00~20:30");
			tx3.setText("地址：湖北省武汉市武昌区烟霞路1号");
			tx4.setText("简介：《捉妖记》是由许诚毅执导，白百何、井柏然、曾志伟、吴君如、姜武等主演。影片于2015年7月16日以"
					+ "IMAX 3D格式在中国内地公映。影片主要讲述了小伙子天荫阴差阳错地怀上了即将降世的小妖王，他被降妖天师小"
					+ "岚一路保护着躲过各种妖怪。虽然二人渐渐对小妖产生了感情，小岚却明白她只为把这只惹人眼红的小妖卖个好价"
					+ "钱，在人妖混杂的世界里，他们的命运无疑将牵动人心。《捉妖记》自上映以来刷新和创造了200余条。");
		} else if (str.equals("3")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.luyudian11));
			queue_btn1.setVisibility(View.GONE);
			queue_btn2.setText("立即取号");
			queue_btn2.setVisibility(View.VISIBLE);
			tx1.setText("推荐：特色鲈鱼（人均：80元）");
			tx2.setText("营业时间时间：11:00~22:00");
			tx3.setText("地址：武汉街道口创意城8楼");
			tx4.setText("简介：鲈鱼是外婆家餐饮集团于2013年7月新推出的子品牌餐厅，这只鱼从浙江一路游到武汉，每一次的亮相"
					+ "都引发了不小的热潮。目前，外婆家“炉鱼”餐厅已经进入上海、杭州、苏州、湖州、深圳、武汉等城市。根据外"
					+ "婆家集团的规划，2014年“炉鱼”全面开启全国扩张模式，将先后在北上广深等18个一线或省级中心城市开出22家门店。");
		} else if (str.equals("11")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.fengwujiutian));
			queue_btn1.setVisibility(View.GONE);
			queue_btn2.setText("我要排队");
			queue_btn2.setVisibility(View.VISIBLE);
			tx1.setText("项目：凤舞九天");
			tx2.setText("推荐指数：4颗星");
			tx3.setText("注意：有心脏病等急发疾病历史的请谨慎选择！");
			tx4.setText("简介：凤舞九天是一个看起来吓人玩过之后觉得还不过瘾的项目。先上升到最高处，然后缓缓下落并在空中做"
					+ "扭转运动，然后就在环形轨道中往返一个来回，整个过程瞬间就结束了。总之记住那个原则，放松就好。");
		}
	}

	private void initEvent() {
		ly_tk1.setOnClickListener(this);
		ly_tk2.setOnClickListener(this);
		ly_tk3.setOnClickListener(this);
		queue_btn1.setOnClickListener(this);
		queue_btn2.setOnClickListener(this);
		title_return_left_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.ly_ticket1:
			btn_tk1.setBackground(getResources().getDrawable(
					R.drawable.blue_dot));
			tx1.setTextColor(getResources().getColor(R.color.nw_bt_blue));
			btn_tk2.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			tx2.setTextColor(getResources().getColor(R.color.nw_bg_black));
			btn_tk3.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			tx3.setTextColor(getResources().getColor(R.color.nw_bg_black));
			break;
		case R.id.ly_ticket2:
			btn_tk1.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			tx1.setTextColor(getResources().getColor(R.color.nw_bg_black));
			btn_tk2.setBackground(getResources().getDrawable(
					R.drawable.blue_dot));
			tx2.setTextColor(getResources().getColor(R.color.nw_bt_blue));
			btn_tk3.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			tx3.setTextColor(getResources().getColor(R.color.nw_bg_black));
			break;
		case R.id.ly_ticket3:
			btn_tk1.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			tx1.setTextColor(getResources().getColor(R.color.nw_bg_black));
			btn_tk2.setBackground(getResources().getDrawable(
					R.drawable.gray_dot0));
			tx2.setTextColor(getResources().getColor(R.color.nw_bg_black));
			btn_tk3.setBackground(getResources().getDrawable(
					R.drawable.blue_dot));
			tx3.setTextColor(getResources().getColor(R.color.nw_bt_blue));
			break;
		case R.id.queue_btn1:
			if (queue_btn1.getText().toString().equals("门票预订")) {
				if (tx1.getText().toString().contains("黄鹤楼")) {
					final CustomDialog dialog2 = new CustomDialog(
							QueueActivity.this);
					dialog2.setTitle("门票预订");
					dialog2.setDetial("是否确认预订？");
					dialog2.setLeftOnClick(new OnClickListener() {

						@Override
						public void onClick(View v) {
							dialog2.dismiss();
							Toast.makeText(QueueActivity.this, "您已取消预订!",
									Toast.LENGTH_SHORT).show();
						}
					});
					dialog2.show();
					dialog2.setRightOnClick(new OnClickListener() {

						@SuppressWarnings("deprecation")
						@Override
						public void onClick(View v) {
							dialog2.dismiss();
							queue_btn1.setClickable(false);
							queue_btn1.setBackground(getResources()
									.getDrawable(R.drawable.queueforoneno));
							Toast.makeText(QueueActivity.this, "恭喜您预订成功!",
									Toast.LENGTH_SHORT).show();
							
							NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
					           //API level 11
					           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
					           builder.setAutoCancel(true);
					           builder.setDefaults(Notification.DEFAULT_SOUND);
					           builder.setContentTitle("黄鹤楼：恭喜您预订成功");
					           builder.setContentText("黄鹤楼欢迎您！");
					           builder.setSmallIcon(R.drawable.ic_launcher);
					           Notification notification = builder.getNotification();
					           manager.notify(R.drawable.ic_launcher, notification);


							/*// 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
							NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
							// 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
							PendingIntent pendingIntent = PendingIntent
									.getActivity(QueueActivity.this, 0,
											new Intent(QueueActivity.this,
													QueueActivity.class), 0);
							// 下面需兼容Android 2.x版本是的处理方式
							// Notification notify1 = new
							// Notification(R.drawable.message,
							// "TickerText:" + "您有新短消息，请注意查收！",
							// System.currentTimeMillis());
							Notification notify1 = new Notification();
							notify1.icon = R.drawable.luyudian11;
							notify1.tickerText = "黄鹤楼：恭喜您预订成功";
							notify1.when = System.currentTimeMillis();
							notify1.setLatestEventInfo(QueueActivity.this,
									"黄鹤楼：恭喜您预订成功", "黄鹤楼欢迎您！", pendingIntent);
							notify1.defaults = Notification.DEFAULT_SOUND;
							notify1.number = 1;
							notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
							// 通过通知管理器来发起通知。如果id不同，则每click，在statu那里增加一个提示
							manager.notify(NOTIFICATION_FLAG, notify1);*/
						}
					});
					dialog2.show();
				} else {
					final CustomDialog dialog2 = new CustomDialog(
							QueueActivity.this);
					dialog2.setTitle("门票预订");
					dialog2.setDetial("是否确认预订？");
					dialog2.setLeftOnClick(new OnClickListener() {

						@Override
						public void onClick(View v) {
							dialog2.dismiss();
							Toast.makeText(QueueActivity.this, "您已取消预订!",
									Toast.LENGTH_SHORT).show();
						}
					});
					dialog2.show();
					dialog2.setRightOnClick(new OnClickListener() {

						@SuppressWarnings("deprecation")
						@Override
						public void onClick(View v) {
							dialog2.dismiss();
							queue_btn1.setClickable(false);
							queue_btn1.setBackground(getResources()
									.getDrawable(R.drawable.queueforoneno));
							Toast.makeText(QueueActivity.this, "恭喜您预订成功!",
									Toast.LENGTH_SHORT).show();

							NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
					           //API level 11
					           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
					           builder.setAutoCancel(true);
					           builder.setDefaults(Notification.DEFAULT_SOUND);
					           builder.setContentTitle("欢乐谷：恭喜您预订成功");
					           builder.setContentText("您预订的是欢乐谷日场");
					           builder.setSmallIcon(R.drawable.ic_launcher);
					           Notification notification = builder.getNotification();
					           manager.notify(R.drawable.ic_launcher, notification);
							/*// 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
							NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
							// 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
							PendingIntent pendingIntent = PendingIntent
									.getActivity(QueueActivity.this, 0,
											new Intent(QueueActivity.this,
													QueueActivity.class), 0);
							// 下面需兼容Android 2.x版本是的处理方式
							// Notification notify1 = new
							// Notification(R.drawable.message,
							// "TickerText:" + "您有新短消息，请注意查收！",
							// System.currentTimeMillis());
							Notification notify1 = new Notification();
							notify1.icon = R.drawable.luyudian11;
							notify1.tickerText = "欢乐谷：恭喜您预订成功";
							notify1.when = System.currentTimeMillis();
							notify1.setLatestEventInfo(QueueActivity.this,
									"欢乐谷：恭喜您预订成功", "您预订的是欢乐谷日场！", pendingIntent);
							notify1.defaults = Notification.DEFAULT_SOUND;
							notify1.number = 1;
							notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
							// 通过通知管理器来发起通知。如果id不同，则每click，在statu那里增加一个提示
							manager.notify(NOTIFICATION_FLAG, notify1);*/

						}
					});
					dialog2.show();
				}

			} else {
				intent = new Intent(QueueActivity.this, QueueNextActivity.class);
				startActivity(intent);
			}
			break;
		case R.id.queue_btn2:
			if (queue_btn2.getText().toString().equals("我要排队")
					&& !tx1.getText().toString().contains("凤舞")) {
				intent = new Intent(QueueActivity.this,
						QueueForFunActivity.class);
				startActivity(intent);
			} else if (queue_btn2.getText().toString().equals("我要排队")
					&& tx1.getText().toString().contains("凤舞")) {
				final CustomDialog dialog2 = new CustomDialog(
						QueueActivity.this);
				dialog2.setTitle("排队项目：凤舞九天");
				dialog2.setDetial("是否确认开始排队？");
				dialog2.setLeftOnClick(new OnClickListener() {

					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						Toast.makeText(QueueActivity.this, "您已取消预订!",
								Toast.LENGTH_SHORT).show();
					}
				});
				dialog2.show();
				dialog2.setRightOnClick(new OnClickListener() {

					@SuppressWarnings("deprecation")
					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						queue_btn2.setClickable(false);
						queue_btn2.setBackground(getResources().getDrawable(
								R.drawable.queueforoneno));
						Toast.makeText(QueueActivity.this, "您已成功加入凤舞九天队伍!",
								Toast.LENGTH_SHORT).show();

						NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				           //API level 11
				           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
				           builder.setAutoCancel(true);
				           builder.setDefaults(Notification.DEFAULT_SOUND);
				           builder.setContentTitle("您已成功加入凤舞九天队伍!");
				           builder.setContentText("您的号码为22号，请按时游玩");
				           builder.setSmallIcon(R.drawable.ic_launcher);
				           Notification notification = builder.getNotification();
				           manager.notify(R.drawable.ic_launcher, notification);
						
						/*// 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
						NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
						// 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
						PendingIntent pendingIntent = PendingIntent
								.getActivity(QueueActivity.this, 0,
										new Intent(QueueActivity.this,
												QueueActivity.class), 0);
						// 下面需兼容Android 2.x版本是的处理方式
						// Notification notify1 = new
						// Notification(R.drawable.message,
						// "TickerText:" + "您有新短消息，请注意查收！",
						// System.currentTimeMillis());
						Notification notify1 = new Notification();
						notify1.icon = R.drawable.luyudian11;
						notify1.tickerText = "您已成功加入队伍！";
						notify1.when = System.currentTimeMillis();
						notify1.setLatestEventInfo(QueueActivity.this,
								"您已成功加入凤舞九天队伍!", "您的号码为22号，请按时游玩！",
								pendingIntent);
						notify1.defaults = Notification.DEFAULT_SOUND;
						notify1.number = 1;
						notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
						// 通过通知管理器来发起通知。如果id不同，则每click，在statu那里增加一个提示
						manager.notify(NOTIFICATION_FLAG, notify1);*/

					}
				});
				dialog2.show();
			} else {
				final CustomDialog dialog2 = new CustomDialog(
						QueueActivity.this);
				dialog2.setTitle("餐位预订");
				dialog2.setDetial("是否确认预订？");
				dialog2.setLeftOnClick(new OnClickListener() {

					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						Toast.makeText(QueueActivity.this, "您已取消预订!",
								Toast.LENGTH_SHORT).show();
					}
				});
				dialog2.show();
				dialog2.setRightOnClick(new OnClickListener() {

					@SuppressWarnings("deprecation")
					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						queue_btn2.setClickable(false);
						queue_btn2.setBackground(getResources().getDrawable(
								R.drawable.queueforoneno));
						Toast.makeText(QueueActivity.this, "恭喜您预订成功!",
								Toast.LENGTH_SHORT).show();

						
						NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				           //API level 11
				           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
				           builder.setAutoCancel(true);
				           builder.setDefaults(Notification.DEFAULT_SOUND);
				           builder.setContentTitle("鲈鱼店：恭喜您预订成功");
				           builder.setContentText("您的号码为36号，请按号就餐！");
				           builder.setSmallIcon(R.drawable.ic_launcher);
				           Notification notification = builder.getNotification();
				           manager.notify(R.drawable.ic_launcher, notification);
						
						/*// 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
						NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
						// 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
						PendingIntent pendingIntent = PendingIntent
								.getActivity(QueueActivity.this, 0,
										new Intent(QueueActivity.this,
												QueueActivity.class), 0);
						// 下面需兼容Android 2.x版本是的处理方式
						// Notification notify1 = new
						// Notification(R.drawable.message,
						// "TickerText:" + "您有新短消息，请注意查收！",
						// System.currentTimeMillis());
						Notification notify1 = new Notification();
						notify1.icon = R.drawable.luyudian11;
						notify1.tickerText = "鲈鱼店：恭喜您预订成功";
						notify1.when = System.currentTimeMillis();
						notify1.setLatestEventInfo(QueueActivity.this,
								"鲈鱼店：恭喜您预订成功", "您的号码为36号，请按号就餐！", pendingIntent);
						notify1.defaults = Notification.DEFAULT_SOUND;
						notify1.number = 1;
						notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
						// 通过通知管理器来发起通知。如果id不同，则每click，在statu那里增加一个提示
						manager.notify(NOTIFICATION_FLAG, notify1);*/

					}
				});
				dialog2.show();
			}
			break;
		default:
			break;
		}
	}
}
