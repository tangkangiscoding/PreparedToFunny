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
import android.widget.Toast;

@SuppressLint("ShowToast")
public class BuyMovieTicketActivity extends Activity implements OnClickListener {
	private Button sure_buy_btn;
	private static final int NOTIFICATION_FLAG = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_queue_buy);
		initView();
		initEvent();
	}

	@SuppressLint("NewApi")
	private void initView() {
		sure_buy_btn = (Button) findViewById(R.id.sure_buy_btn);
	}

	private void initEvent() {
		sure_buy_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				final CustomDialog dialog2 = new CustomDialog(
						BuyMovieTicketActivity.this);
				dialog2.setTitle("电影票预订");
				dialog2.setDetial("是否确认预订？");
				dialog2.setLeftOnClick(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						Toast.makeText(BuyMovieTicketActivity.this, "您已取消预订!",
								Toast.LENGTH_SHORT);
					}
				});
				dialog2.show();
				dialog2.setRightOnClick(new OnClickListener() {
					@SuppressWarnings("deprecation")
					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						Toast.makeText(BuyMovieTicketActivity.this, "恭喜您预订成功!",
								Toast.LENGTH_SHORT);
						
						NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				           //API level 11
				           Notification.Builder builder = new Notification.Builder(BuyMovieTicketActivity.this);
				           builder.setAutoCancel(true);
				           builder.setDefaults(Notification.DEFAULT_SOUND);
				           builder.setContentTitle("电影世界：恭喜您预订成功");
				           builder.setContentText("您的取票码是为201607011450，请按时观影！");
				           builder.setSmallIcon(R.drawable.ic_launcher);
				           Notification notification = builder.getNotification();
				           manager.notify(R.drawable.ic_launcher, notification);
						
					/*	// 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
						NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
						// 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
						PendingIntent pendingIntent = PendingIntent
								.getActivity(BuyMovieTicketActivity.this, 0,
										new Intent(BuyMovieTicketActivity.this,
												QueueActivity.class), 0);
						// 下面需兼容Android 2.x版本是的处理方式
						// Notification notify1 = new
						// Notification(R.drawable.message,
						// "TickerText:" + "您有新短消息，请注意查收！",
						// System.currentTimeMillis());
						Notification notify1 = new Notification();
						notify1.icon = R.drawable.luyudian11;
						notify1.tickerText = "电影世界：恭喜您预订成功！";
						notify1.when = System.currentTimeMillis();
						notify1.setLatestEventInfo(BuyMovieTicketActivity.this,
								"电影世界：恭喜您预订成功！", "您的取票码是为201607011450，请按时观影！",
								pendingIntent);
						notify1.defaults = Notification.DEFAULT_SOUND;
						notify1.number = 1;
						notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
						// 通过通知管理器来发起通知。如果id不同，则每click，在statu那里增加一个提示
						manager.notify(NOTIFICATION_FLAG, notify1);*/
					}
				});
				dialog2.show();
			}
		});
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
	}
}
