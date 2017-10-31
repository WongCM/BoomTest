package com.sherlock.mvp.view;

/**
 * Created by SherlockHolmes on 2017/10/31.16:23
 */

public interface IBoomView {

	void showProgressView(boolean show);

	void showCount(int count);

	void showToast(String msg);
}
