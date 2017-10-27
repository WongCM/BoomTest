package com.gg.unity_exchange;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

/**
 * Created by SherlockHolmes on 2017/10/27.
 */

public class SDKActivity extends Activity {

	private Toast toast;
	private Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.android_sdk);

		activity = this;
		String text = getIntent().getStringExtra("text");
		final EditText editText = (EditText) findViewById(R.id.textArea);
		editText.setText(text);
		editText.setSelection(text.length());
//		editText.setFocusableInTouchMode(true);
//		editText.requestFocus();
//		editText.setCursorVisible(true);
//		editText.setImeOptions(EditorInfo.IME_ACTION_SEND);
		//点击了软键盘的完成
		editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					toast("点击了键盘完成按钮：" + editText.getText().toString());
					SendData(0, editText.getText().toString());
					finish();
				}
				return false;
			}
		});

		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toast("点击了发送按钮：" + editText.getText().toString());
				if (editText.getText().toString().length() == 0) {
					return;
				}
				SendData(0, editText.getText().toString());
				finish();
			}
		});
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		overridePendingTransition(R.anim.slide_bottom_in, R.anim.slide_bottom_out);
	}

	// 向unity返回数据
	void SendData(int code, String info) {
		UnityPlayer.UnitySendMessage("Plugins", "OnCustomInputAction", info);
	}

	private void toast(final String msg) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (toast == null) {
					toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
				} else {
					toast.setText(msg);
				}
				toast.show();
			}
		});
	}
}
