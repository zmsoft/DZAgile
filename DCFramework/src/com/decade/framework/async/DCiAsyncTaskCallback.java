package com.decade.framework.async;

/**
 * @description: 网络请求回调接口
 * @author: Decade
 * @date: 2013-9-16
 * @preserve protected
 */
public interface DCiAsyncTaskCallback {
	public void onJsonPaserError(String message);
	public void onNetDisconnected();
	public void onServerResponseError(String message);
	public void openTopLoadView();
	public void closeTopLoadView();
	public void onComplete(DCiResponse response, int requestCode);
}