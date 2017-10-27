package com.sherlock.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gg.unity_exchange.SDKActivity;

public class MainActivity extends AppCompatActivity {

	private EditText editText;
	private EditText editText2;
	private EditText editText3;
	private EditText editText4;
	private EditText editText5;
	private CheckBox checkBox;
	private TextView tvCount;
	private Activity activity;
	private Toast toast;
	private HttpUtils httpUtils;
	private boolean isStart = false;
	private boolean isStop = false;
	private boolean usePhoneBoom = false;

	private int count = 0;
	private String countTitle = "已轰炸 ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		activity = this;
		httpUtils = new HttpUtils(activity);

		editText = (EditText) findViewById(R.id.et_phone);
		editText2 = (EditText) findViewById(R.id.et_phone2);
		editText3 = (EditText) findViewById(R.id.et_phone3);
		editText4 = (EditText) findViewById(R.id.et_phone4);
		editText5 = (EditText) findViewById(R.id.et_phone5);

		editText.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(activity, SDKActivity.class);
				intent.putExtra("text", "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈hh");
				activity.startActivity(intent);
			}
		});

		findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkPhoneNumber(editText.getText().toString())) {
					toast("已开始轰炸！");
					new Handler(getMainLooper()).postDelayed(new Runnable() {
						@Override
						public void run() {
							isStart = true;
							isStop = false;
							handler.sendEmptyMessage(1);
						}
					}, 1000);
				}
			}
		});
		findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!isStart) {
					toast("傻逼，你还没开始轰炸！");
					return;
				}
				try {
					handler.removeMessages(1);
					handler.removeCallbacksAndMessages(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				isStart = false;
				isStop = true;
				toast("已停止轰炸！");
			}
		});

		checkBox = (CheckBox) findViewById(R.id.checkBox);
		checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					usePhoneBoom = true;
					toast("已启用电话轰炸");
				} else {
					usePhoneBoom = false;
					toast("已停止电话轰炸");
				}
			}
		});
		tvCount = (TextView) findViewById(R.id.tv_count);
	}

	private boolean checkPhoneNumber(String phoneNumber) {
		if (TextUtils.isEmpty(phoneNumber)) {
			toast("智障，请输入手机号码！");
			return false;
		}
		if (phoneNumber.length() != 11) {
			toast("智障，请输入正确的手机号码！");
			return false;
		}
		return true;
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
				case 1:
					if (isStop) {
						return;
					}
					boomSMS();
					count++;
					tvCount.setText(countTitle + count + " 波");
					handler.sendEmptyMessageDelayed(1, 70 * 1000);
					break;
				case 2:
					toast("本波轰炸已完成！下一波将在60s以后开始！");
					break;
				default:
					break;
			}
		}
	};

	@Override
	public void onBackPressed() {
		Intent home = new Intent(Intent.ACTION_MAIN);
		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		home.addCategory(Intent.CATEGORY_HOME);
		startActivity(home);
	}

	private void toast(String msg) {
		if (toast == null) {
			toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}

	private void boomSMS() {
		toast("开始一波新的轰炸！");
		new Thread(new Runnable() {
			@Override
			public void run() {
				httpUtils.sendSMSBoom1(editText.getText().toString());
				httpUtils.sendSMSBoom2(editText.getText().toString());
				httpUtils.sendSMSBoom3(editText.getText().toString());
				if (usePhoneBoom) {
					httpUtils.sendSMSBoom4(editText.getText().toString());
				}
				httpUtils.sendSMSBoom5(editText.getText().toString());
				httpUtils.sendSMSBoom6(editText.getText().toString());
				httpUtils.sendSMSBoom7(editText.getText().toString());
				httpUtils.sendSMSBoom8(editText.getText().toString());
				httpUtils.sendSMSBoom9(editText.getText().toString());

				httpUtils.sendSMSBoom1(editText2.getText().toString());
				httpUtils.sendSMSBoom2(editText2.getText().toString());
				httpUtils.sendSMSBoom3(editText2.getText().toString());
				if (usePhoneBoom) {
					httpUtils.sendSMSBoom4(editText2.getText().toString());
				}
				httpUtils.sendSMSBoom5(editText2.getText().toString());
				httpUtils.sendSMSBoom6(editText2.getText().toString());
				httpUtils.sendSMSBoom7(editText2.getText().toString());
				httpUtils.sendSMSBoom8(editText2.getText().toString());
				httpUtils.sendSMSBoom9(editText2.getText().toString());

				httpUtils.sendSMSBoom1(editText3.getText().toString());
				httpUtils.sendSMSBoom2(editText3.getText().toString());
				httpUtils.sendSMSBoom3(editText3.getText().toString());
				if (usePhoneBoom) {
					httpUtils.sendSMSBoom4(editText3.getText().toString());
				}
				httpUtils.sendSMSBoom5(editText3.getText().toString());
				httpUtils.sendSMSBoom6(editText3.getText().toString());
				httpUtils.sendSMSBoom7(editText3.getText().toString());
				httpUtils.sendSMSBoom8(editText3.getText().toString());
				httpUtils.sendSMSBoom9(editText3.getText().toString());

				httpUtils.sendSMSBoom1(editText4.getText().toString());
				httpUtils.sendSMSBoom2(editText4.getText().toString());
				httpUtils.sendSMSBoom3(editText4.getText().toString());
				if (usePhoneBoom) {
					httpUtils.sendSMSBoom4(editText4.getText().toString());
				}
				httpUtils.sendSMSBoom5(editText4.getText().toString());
				httpUtils.sendSMSBoom6(editText4.getText().toString());
				httpUtils.sendSMSBoom7(editText4.getText().toString());
				httpUtils.sendSMSBoom8(editText4.getText().toString());
				httpUtils.sendSMSBoom9(editText4.getText().toString());

				httpUtils.sendSMSBoom1(editText5.getText().toString());
				httpUtils.sendSMSBoom2(editText5.getText().toString());
				httpUtils.sendSMSBoom3(editText5.getText().toString());
				if (usePhoneBoom) {
					httpUtils.sendSMSBoom4(editText5.getText().toString());
				}
				httpUtils.sendSMSBoom5(editText5.getText().toString());
				httpUtils.sendSMSBoom6(editText5.getText().toString());
				httpUtils.sendSMSBoom7(editText5.getText().toString());
				httpUtils.sendSMSBoom8(editText5.getText().toString());
				httpUtils.sendSMSBoom9(editText5.getText().toString());

				handler.sendEmptyMessage(2);
			}
		}).start();
	}

}
