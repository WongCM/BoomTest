package com.sherlock.mvp.presenter;

/**
 * Created by SherlockHolmes on 2017/10/31.16:29
 */

public interface IBoomPresenter {

	void startSMSBoom(String phone);

	void startPhoneBoom(String phone);

	void stopBoom();
}
