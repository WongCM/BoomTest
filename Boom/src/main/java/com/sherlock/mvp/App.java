package com.sherlock.mvp;

import android.app.Application;
import android.os.Environment;

import com.okhttplib.OkHttpUtil;
import com.okhttplib.annotation.CacheType;
import com.okhttplib.annotation.Encoding;
import com.okhttplib.cookie.PersistentCookieJar;
import com.okhttplib.cookie.cache.SetCookieCache;
import com.okhttplib.cookie.persistence.SharedPrefsCookiePersistor;

import java.io.File;

/**
 * Created by SherlockHolmes on 2017/10/31.16:22
 */

public class App extends Application {
	/**
	 * Called when the application is starting, before any activity, service,
	 * or receiver objects (excluding content providers) have been created.
	 * Implementations should be as quick as possible (for example using
	 * lazy initialization of state) since the time spent in this function
	 * directly impacts the performance of starting the first activity,
	 * service, or receiver in a process.
	 * If you override this method, be sure to call super.onCreate().
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		String downloadFileDir = Environment.getExternalStorageDirectory().getPath() + "/okHttp_download/";
		String cacheDir = Environment.getExternalStorageDirectory().getPath() + "/okHttp_cache";
		OkHttpUtil.init(this)
				.setConnectTimeout(15)//连接超时时间
				.setWriteTimeout(15)//写超时时间
				.setReadTimeout(15)//读超时时间
				.setMaxCacheSize(10 * 1024 * 1024)//缓存空间大小
				.setCacheType(CacheType.FORCE_NETWORK)//缓存类型
				.setHttpLogTAG("HttpLog")//设置请求日志标识
				.setIsGzip(false)//Gzip压缩，需要服务端支持
				.setShowHttpLog(true)//显示请求日志
				.setShowLifecycleLog(false)//显示Activity销毁日志
				.setRetryOnConnectionFailure(false)//失败后不自动重连
				.setCachedDir(new File(cacheDir))//设置缓存目录
				.setDownloadFileDir(downloadFileDir)//文件下载保存目录
				.setResponseEncoding(Encoding.UTF_8)//设置全局的服务器响应编码
				.setRequestEncoding(Encoding.UTF_8)//设置全局的请求参数编码
				.setCookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(this)))
				.build();
	}
}