package com.sherlock.mvp.presenter.impl;

import android.content.Context;

import com.sherlock.mvp.model.impl.BoomModel;
import com.sherlock.mvp.presenter.IBoomPresenter;
import com.sherlock.mvp.view.IBoomView;

/**
 * Created by SherlockHolmes on 2017/10/31.16:31
 */

public class BoomPresenter implements IBoomPresenter {

	private BoomModel boomModel;
	private IBoomView iBoomView;

	public BoomPresenter(Context context, IBoomView iBoomView) {
		this.iBoomView = iBoomView;
		boomModel = new BoomModel(context);
	}

	@Override
	public void startSMSBoom(String phone) {
		iBoomView.showProgressView(true);
		boomModel.sendMessage(phone);
	}

	@Override
	public void startPhoneBoom(String phone) {
		iBoomView.showProgressView(true);
		boomModel.callPhone(phone);
	}

	@Override
	public void stopBoom() {
		iBoomView.showProgressView(false);
	}
}
