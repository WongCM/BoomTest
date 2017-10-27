package com.gg.unity_exchange;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

	private Toast toast;
	private Activity activity;
	private static String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity = this;
	}

	public void getEditText() {
		toast("getEditText");
		Log.d(TAG, "getEditText: getEditText");
		View rootview = activity.getWindow().getDecorView();
		rootview.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (v instanceof Button) {
					toast("Button:" + v.getId());
					Log.d(TAG, "Button:" + v.getId());
				} else if (v instanceof TextView) {
					toast("TextView:" + v.getId());
					Log.d(TAG, "TextView:" + v.getId());
				} else if (v instanceof EditText) {
					toast("EditText:" + v.getId());
					Log.d(TAG, "EditText:" + v.getId());
				} else {
					toast("其他类型:" + v.getId());
					Log.d(TAG, "其他类型:" + v.getId());
				}
				return false;
			}
		});
		View view = rootview.findFocus();
		if (view instanceof EditText) {
			((EditText) view).setOnEditorActionListener(new TextView.OnEditorActionListener() {
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
					toast(actionId + "");
					Log.d(TAG, "onEditorAction:" + v.getId());
					return false;
				}
			});
		}
	}

	public void toast(final String msg) {
		if (activity == null) {
			activity = UnityPlayer.currentActivity;
		}
		if (activity == null) {
			activity = MainActivity.this;
		}
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
