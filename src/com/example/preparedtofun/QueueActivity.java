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
		// TODO �Զ����ɵķ������
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
		title_return_left_text.setText("�Ŷ�ԤԼ");
		if (str.equals("0")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.huanlegu123));
			queue_btn1.setText("��ƱԤ��");
			queue_btn1.setVisibility(View.VISIBLE);
			queue_btn2.setText("��Ҫ�Ŷ�");
			tx1.setText("���ֹȣ�Ʊ�ۣ�120Ԫ��");
			tx2.setText("ʱ�䣺12��00~18:00 18:00~00:00");
			tx3.setText("��ַ������ʡ�人�к�ɽ�����ִ��196��");
			tx4.setText("��飺�人���ֹ������ڻ��ȳǼ��ż����ڡ��������ɶ����Ϻ�֮�����ҹ��в�������������ĸ����͡�"
					+ "��̬�ͺʹ����͵Ĵ����Ļ���԰���人���ֹ�ӵ����������˫��ľ�ʹ�ɽ�������������˹�����ɳ̲�������"
					+ "�ڼ�ͥ�����������ġ��人����רҵ�糡��50����������ʩ��");
		} else if (str.equals("1")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.haunghelou));
			queue_btn1.setText("��ƱԤ��");
			queue_btn1.setVisibility(View.VISIBLE);
			queue_btn2.setVisibility(View.GONE);
			tx1.setText("�ƺ�¥��Ʊ�ۣ�60Ԫ��");
			tx2.setText("ʱ�䣺9��00~20:00");
			tx3.setText("��ַ������·����");
			tx4.setText("��飺�ƺ�¥λ�ں���ʡ�人�г����ϰ��������ɽ֮�ۣ�Ϊ����5A�����ξ��������С����½�ɽ��һ¥��"
					+ "�������¾�����֮�ơ��ƺ�¥���人�б�־�Խ��������紨�󡢹���̨���ơ��人������ʤ�����ý���Ҳ�������"
					+ "��¥�������ϲ������󲢳�Ϊ������������¥����");
		} else if (str.equals("2")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.wandayinyuan));
			queue_btn1.setVisibility(View.VISIBLE);
			queue_btn2.setVisibility(View.GONE);
			tx1.setText("�Ƽ���׽���ǣ�Ʊ�ۣ�35Ԫ��");
			tx2.setText("ʱ�䣺09��00~11:30 18:00~20:30");
			tx3.setText("��ַ������ʡ�人���������ϼ·1��");
			tx4.setText("��飺��׽���ǡ����������ִ�����װٺΡ�����Ȼ����־ΰ������硢��������ݡ�ӰƬ��2015��7��16����"
					+ "IMAX 3D��ʽ���й��ڵع�ӳ��ӰƬ��Ҫ������С����������������ػ����˼���������С����������������ʦС"
					+ "�һ·�����Ŷ���������֡���Ȼ���˽�����С�������˸��飬С�ȴ������ֻΪ����ֻ�����ۺ��С�������ü�"
					+ "Ǯ�����������ӵ���������ǵ��������ɽ�ǣ�����ġ���׽���ǡ�����ӳ����ˢ�ºʹ�����200������");
		} else if (str.equals("3")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.luyudian11));
			queue_btn1.setVisibility(View.GONE);
			queue_btn2.setText("����ȡ��");
			queue_btn2.setVisibility(View.VISIBLE);
			tx1.setText("�Ƽ�����ɫ���㣨�˾���80Ԫ��");
			tx2.setText("Ӫҵʱ��ʱ�䣺11:00~22:00");
			tx3.setText("��ַ���人�ֵ��ڴ����8¥");
			tx4.setText("��飺���������żҲ���������2013��7�����Ƴ�����Ʒ�Ʋ�������ֻ����㽭һ·�ε��人��ÿһ�ε�����"
					+ "�������˲�С���ȳ���Ŀǰ�����żҡ�¯�㡱�����Ѿ������Ϻ������ݡ����ݡ����ݡ����ڡ��人�ȳ��С�������"
					+ "�żҼ��ŵĹ滮��2014�ꡰ¯�㡱ȫ�濪��ȫ������ģʽ�����Ⱥ��ڱ��Ϲ����18��һ�߻�ʡ�����ĳ��п���22���ŵꡣ");
		} else if (str.equals("11")) {
			queue_ly1.setBackground(getResources().getDrawable(
					R.drawable.fengwujiutian));
			queue_btn1.setVisibility(View.GONE);
			queue_btn2.setText("��Ҫ�Ŷ�");
			queue_btn2.setVisibility(View.VISIBLE);
			tx1.setText("��Ŀ���������");
			tx2.setText("�Ƽ�ָ����4����");
			tx3.setText("ע�⣺�����ಡ�ȼ���������ʷ�������ѡ��");
			tx4.setText("��飺���������һ���������������֮����û���������Ŀ������������ߴ���Ȼ�󻺻����䲢�ڿ�����"
					+ "Ťת�˶���Ȼ����ڻ��ι��������һ�����أ���������˲��ͽ����ˡ���֮��ס�Ǹ�ԭ�򣬷��ɾͺá�");
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
				// TODO �Զ����ɵķ������
				finish();
			}
		});
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO �Զ����ɵķ������
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
			if (queue_btn1.getText().toString().equals("��ƱԤ��")) {
				if (tx1.getText().toString().contains("�ƺ�¥")) {
					final CustomDialog dialog2 = new CustomDialog(
							QueueActivity.this);
					dialog2.setTitle("��ƱԤ��");
					dialog2.setDetial("�Ƿ�ȷ��Ԥ����");
					dialog2.setLeftOnClick(new OnClickListener() {

						@Override
						public void onClick(View v) {
							dialog2.dismiss();
							Toast.makeText(QueueActivity.this, "����ȡ��Ԥ��!",
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
							Toast.makeText(QueueActivity.this, "��ϲ��Ԥ���ɹ�!",
									Toast.LENGTH_SHORT).show();
							
							NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
					           //API level 11
					           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
					           builder.setAutoCancel(true);
					           builder.setDefaults(Notification.DEFAULT_SOUND);
					           builder.setContentTitle("�ƺ�¥����ϲ��Ԥ���ɹ�");
					           builder.setContentText("�ƺ�¥��ӭ����");
					           builder.setSmallIcon(R.drawable.ic_launcher);
					           Notification notification = builder.getNotification();
					           manager.notify(R.drawable.ic_launcher, notification);


							/*// ��Android����֪ͨ����������Ҫ��ϵͳ������֪ͨ������NotificationManager������һ��ϵͳService��
							NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
							// ����һ��PendingIntent����Intent���ƣ���ͬ�������ڲ������ϵ��ã���Ҫ������״̬��������activity�����Բ��õ���PendingIntent,�����Notification��ת�������ĸ�Activity
							PendingIntent pendingIntent = PendingIntent
									.getActivity(QueueActivity.this, 0,
											new Intent(QueueActivity.this,
													QueueActivity.class), 0);
							// ���������Android 2.x�汾�ǵĴ���ʽ
							// Notification notify1 = new
							// Notification(R.drawable.message,
							// "TickerText:" + "�����¶���Ϣ����ע����գ�",
							// System.currentTimeMillis());
							Notification notify1 = new Notification();
							notify1.icon = R.drawable.luyudian11;
							notify1.tickerText = "�ƺ�¥����ϲ��Ԥ���ɹ�";
							notify1.when = System.currentTimeMillis();
							notify1.setLatestEventInfo(QueueActivity.this,
									"�ƺ�¥����ϲ��Ԥ���ɹ�", "�ƺ�¥��ӭ����", pendingIntent);
							notify1.defaults = Notification.DEFAULT_SOUND;
							notify1.number = 1;
							notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL������֪ͨ���û����ʱ��֪ͨ���������
							// ͨ��֪ͨ������������֪ͨ�����id��ͬ����ÿclick����statu��������һ����ʾ
							manager.notify(NOTIFICATION_FLAG, notify1);*/
						}
					});
					dialog2.show();
				} else {
					final CustomDialog dialog2 = new CustomDialog(
							QueueActivity.this);
					dialog2.setTitle("��ƱԤ��");
					dialog2.setDetial("�Ƿ�ȷ��Ԥ����");
					dialog2.setLeftOnClick(new OnClickListener() {

						@Override
						public void onClick(View v) {
							dialog2.dismiss();
							Toast.makeText(QueueActivity.this, "����ȡ��Ԥ��!",
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
							Toast.makeText(QueueActivity.this, "��ϲ��Ԥ���ɹ�!",
									Toast.LENGTH_SHORT).show();

							NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
					           //API level 11
					           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
					           builder.setAutoCancel(true);
					           builder.setDefaults(Notification.DEFAULT_SOUND);
					           builder.setContentTitle("���ֹȣ���ϲ��Ԥ���ɹ�");
					           builder.setContentText("��Ԥ�����ǻ��ֹ��ճ�");
					           builder.setSmallIcon(R.drawable.ic_launcher);
					           Notification notification = builder.getNotification();
					           manager.notify(R.drawable.ic_launcher, notification);
							/*// ��Android����֪ͨ����������Ҫ��ϵͳ������֪ͨ������NotificationManager������һ��ϵͳService��
							NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
							// ����һ��PendingIntent����Intent���ƣ���ͬ�������ڲ������ϵ��ã���Ҫ������״̬��������activity�����Բ��õ���PendingIntent,�����Notification��ת�������ĸ�Activity
							PendingIntent pendingIntent = PendingIntent
									.getActivity(QueueActivity.this, 0,
											new Intent(QueueActivity.this,
													QueueActivity.class), 0);
							// ���������Android 2.x�汾�ǵĴ���ʽ
							// Notification notify1 = new
							// Notification(R.drawable.message,
							// "TickerText:" + "�����¶���Ϣ����ע����գ�",
							// System.currentTimeMillis());
							Notification notify1 = new Notification();
							notify1.icon = R.drawable.luyudian11;
							notify1.tickerText = "���ֹȣ���ϲ��Ԥ���ɹ�";
							notify1.when = System.currentTimeMillis();
							notify1.setLatestEventInfo(QueueActivity.this,
									"���ֹȣ���ϲ��Ԥ���ɹ�", "��Ԥ�����ǻ��ֹ��ճ���", pendingIntent);
							notify1.defaults = Notification.DEFAULT_SOUND;
							notify1.number = 1;
							notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL������֪ͨ���û����ʱ��֪ͨ���������
							// ͨ��֪ͨ������������֪ͨ�����id��ͬ����ÿclick����statu��������һ����ʾ
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
			if (queue_btn2.getText().toString().equals("��Ҫ�Ŷ�")
					&& !tx1.getText().toString().contains("����")) {
				intent = new Intent(QueueActivity.this,
						QueueForFunActivity.class);
				startActivity(intent);
			} else if (queue_btn2.getText().toString().equals("��Ҫ�Ŷ�")
					&& tx1.getText().toString().contains("����")) {
				final CustomDialog dialog2 = new CustomDialog(
						QueueActivity.this);
				dialog2.setTitle("�Ŷ���Ŀ���������");
				dialog2.setDetial("�Ƿ�ȷ�Ͽ�ʼ�Ŷӣ�");
				dialog2.setLeftOnClick(new OnClickListener() {

					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						Toast.makeText(QueueActivity.this, "����ȡ��Ԥ��!",
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
						Toast.makeText(QueueActivity.this, "���ѳɹ��������������!",
								Toast.LENGTH_SHORT).show();

						NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				           //API level 11
				           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
				           builder.setAutoCancel(true);
				           builder.setDefaults(Notification.DEFAULT_SOUND);
				           builder.setContentTitle("���ѳɹ��������������!");
				           builder.setContentText("���ĺ���Ϊ22�ţ��밴ʱ����");
				           builder.setSmallIcon(R.drawable.ic_launcher);
				           Notification notification = builder.getNotification();
				           manager.notify(R.drawable.ic_launcher, notification);
						
						/*// ��Android����֪ͨ����������Ҫ��ϵͳ������֪ͨ������NotificationManager������һ��ϵͳService��
						NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
						// ����һ��PendingIntent����Intent���ƣ���ͬ�������ڲ������ϵ��ã���Ҫ������״̬��������activity�����Բ��õ���PendingIntent,�����Notification��ת�������ĸ�Activity
						PendingIntent pendingIntent = PendingIntent
								.getActivity(QueueActivity.this, 0,
										new Intent(QueueActivity.this,
												QueueActivity.class), 0);
						// ���������Android 2.x�汾�ǵĴ���ʽ
						// Notification notify1 = new
						// Notification(R.drawable.message,
						// "TickerText:" + "�����¶���Ϣ����ע����գ�",
						// System.currentTimeMillis());
						Notification notify1 = new Notification();
						notify1.icon = R.drawable.luyudian11;
						notify1.tickerText = "���ѳɹ�������飡";
						notify1.when = System.currentTimeMillis();
						notify1.setLatestEventInfo(QueueActivity.this,
								"���ѳɹ��������������!", "���ĺ���Ϊ22�ţ��밴ʱ���棡",
								pendingIntent);
						notify1.defaults = Notification.DEFAULT_SOUND;
						notify1.number = 1;
						notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL������֪ͨ���û����ʱ��֪ͨ���������
						// ͨ��֪ͨ������������֪ͨ�����id��ͬ����ÿclick����statu��������һ����ʾ
						manager.notify(NOTIFICATION_FLAG, notify1);*/

					}
				});
				dialog2.show();
			} else {
				final CustomDialog dialog2 = new CustomDialog(
						QueueActivity.this);
				dialog2.setTitle("��λԤ��");
				dialog2.setDetial("�Ƿ�ȷ��Ԥ����");
				dialog2.setLeftOnClick(new OnClickListener() {

					@Override
					public void onClick(View v) {
						dialog2.dismiss();
						Toast.makeText(QueueActivity.this, "����ȡ��Ԥ��!",
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
						Toast.makeText(QueueActivity.this, "��ϲ��Ԥ���ɹ�!",
								Toast.LENGTH_SHORT).show();

						
						NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				           //API level 11
				           Notification.Builder builder = new Notification.Builder(QueueActivity.this);
				           builder.setAutoCancel(true);
				           builder.setDefaults(Notification.DEFAULT_SOUND);
				           builder.setContentTitle("����꣺��ϲ��Ԥ���ɹ�");
				           builder.setContentText("���ĺ���Ϊ36�ţ��밴�žͲͣ�");
				           builder.setSmallIcon(R.drawable.ic_launcher);
				           Notification notification = builder.getNotification();
				           manager.notify(R.drawable.ic_launcher, notification);
						
						/*// ��Android����֪ͨ����������Ҫ��ϵͳ������֪ͨ������NotificationManager������һ��ϵͳService��
						NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
						// ����һ��PendingIntent����Intent���ƣ���ͬ�������ڲ������ϵ��ã���Ҫ������״̬��������activity�����Բ��õ���PendingIntent,�����Notification��ת�������ĸ�Activity
						PendingIntent pendingIntent = PendingIntent
								.getActivity(QueueActivity.this, 0,
										new Intent(QueueActivity.this,
												QueueActivity.class), 0);
						// ���������Android 2.x�汾�ǵĴ���ʽ
						// Notification notify1 = new
						// Notification(R.drawable.message,
						// "TickerText:" + "�����¶���Ϣ����ע����գ�",
						// System.currentTimeMillis());
						Notification notify1 = new Notification();
						notify1.icon = R.drawable.luyudian11;
						notify1.tickerText = "����꣺��ϲ��Ԥ���ɹ�";
						notify1.when = System.currentTimeMillis();
						notify1.setLatestEventInfo(QueueActivity.this,
								"����꣺��ϲ��Ԥ���ɹ�", "���ĺ���Ϊ36�ţ��밴�žͲͣ�", pendingIntent);
						notify1.defaults = Notification.DEFAULT_SOUND;
						notify1.number = 1;
						notify1.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL������֪ͨ���û����ʱ��֪ͨ���������
						// ͨ��֪ͨ������������֪ͨ�����id��ͬ����ÿclick����statu��������һ����ʾ
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
