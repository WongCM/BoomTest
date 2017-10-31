package com.sherlock.mvp.model.impl;

import android.content.Context;

import com.sherlock.mvp.model.IBoomModel;
import com.sherlock.mvp.util.BoomUtil;

/**
 * Created by SherlockHolmes on 2017/10/31.16:26
 */

public class BoomModel implements IBoomModel {

	private BoomUtil boomUtil = null;

	public BoomModel(Context context) {
		this.boomUtil = new BoomUtil(context);
	}

	@Override
	public void sendMessage(String phone) {
		boomUtil.startSMSBoom(phone);
	}

	@Override
	public void callPhone(String phone) {
		boomUtil.startPhoneBoom(phone);
	}
}
