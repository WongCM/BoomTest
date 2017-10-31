package com.sherlock.mvp.view.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sherlock.mvp.presenter.impl.BoomPresenter;
import com.sherlock.mvp.util.BoomUtil;
import com.sherlock.mvp.view.IBoomView;
import com.sherlock.test.R;

public class MainActivity extends AppCompatActivity implements IBoomView{

	private EditText editText;
	private EditText editText2;
	private EditText editText3;
	private EditText editText4;
	private EditText editText5;
	private CheckBox checkBox;
	private TextView tvCount;
	private ProgressBar progressBar;

	private Context context;
	private BoomUtil boomUtil;
	private BoomPresenter boomPresenter;

	private boolean isStart = false;
	private boolean isStop = false;
	private boolean usePhoneBoom = false;

	private int count = 0;
	private String countTitle = "已轰炸 ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
		
		boomUtil = new BoomUtil(context);
		boomPresenter = new BoomPresenter(context, this);

		iniView();
	}

	private void iniView() {
		editText = (EditText) findViewById(R.id.et_phone);
		editText2 = (EditText) findViewById(R.id.et_phone2);
		editText3 = (EditText) findViewById(R.id.et_phone3);
		editText4 = (EditText) findViewById(R.id.et_phone4);
		editText5 = (EditText) findViewById(R.id.et_phone5);

		findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (boomUtil.checkPhoneNumber(editText.getText().toString())) {
					boomUtil.toast("已开始轰炸！");
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
					boomUtil.toast("傻逼，你还没开始轰炸！");
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
				boomUtil.toast("已停止轰炸！");
				boomPresenter.stopBoom();
			}
		});

		checkBox = (CheckBox) findViewById(R.id.checkBox);
		checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					usePhoneBoom = true;
					boomUtil.toast("已启用电话轰炸");
				} else {
					usePhoneBoom = false;
					boomUtil.toast("已停止电话轰炸");
				}
			}
		});
		tvCount = (TextView) findViewById(R.id.tv_count);
		progressBar = (ProgressBar) findViewById(R.id.progress);
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
					boomUtil.toast("本波轰炸已完成！下一波将在60s以后开始！");
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

	private void boomSMS() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String phone1 = editText.getText().toString();
				String phone2 = editText2.getText().toString();
				String phone3 = editText3.getText().toString();
				String phone4 = editText4.getText().toString();
				String phone5 = editText5.getText().toString();

				boomPresenter.startSMSBoom(phone1);
				boomPresenter.startSMSBoom(phone2);
				boomPresenter.startSMSBoom(phone3);
				boomPresenter.startSMSBoom(phone4);
				boomPresenter.startSMSBoom(phone5);

				if (usePhoneBoom) {
					boomPresenter.startPhoneBoom(phone1);
					boomPresenter.startPhoneBoom(phone2);
					boomPresenter.startPhoneBoom(phone3);
					boomPresenter.startPhoneBoom(phone4);
					boomPresenter.startPhoneBoom(phone5);
				}
				handler.sendEmptyMessage(2);
			}
		}).start();
	}

	@Override
	public void showProgressView(final boolean show) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (show) {
					progressBar.setVisibility(View.VISIBLE);
				} else {
					progressBar.setVisibility(View.GONE);
				}
			}
		});
	}

	@Override
	public void showCount(int count) {

	}

	@Override
	public void showToast(String msg) {

	}
}