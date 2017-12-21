package com.qiuxs.uzhe.alimama;

import com.qiuxs.fdn.uconfig.IConfiguration;
import com.qiuxs.fdn.uconfig.UConfigUtils;

/**
 * 淘宝配置管理
 * @author qiuxs
 *
 */
public class TaoBaoConfig {

	/*
	 * 配置信息来自于 淘宝开放平台
	 * http://open.taobao.com/
	 */

	/** 配置域 */
	private static final String CONFIG_DOMAIN = "taobao";
	/** ApiUrl配置Key */
	private static final String URL = "url";
	/** AppKey配置Key */
	private static final String APP_KEY = "AppKey";
	/** AppSecret配置Key */
	private static final String APP_SECRET = "AppSecret";

	/** ApiUrl */
	private String url;
	/** AppKey */
	private String app_key;
	/** AppSecret */
	private String app_secret;

	private static class InstanceHolder {
		private static final TaoBaoConfig instance = new TaoBaoConfig();
	}

	private TaoBaoConfig() {
		IConfiguration config = UConfigUtils.getConfig(CONFIG_DOMAIN);
		this.url = config.getString(URL);
		this.app_key = config.getString(APP_KEY);
		this.app_secret = config.getString(APP_SECRET);
	}

	/**
	 * 获取实例
	 * @return
	 */
	public static TaoBaoConfig getInstance() {
		return InstanceHolder.instance;
	}

	/**
	 * 获取ApiUrl
	 * @return
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 获取AppKey
	 * @return
	 */
	public String getAppKey() {
		return this.app_key;
	}

	/**
	 * 获取AppSecret
	 * @return
	 */
	public String getAppSecret() {
		return this.app_secret;
	}
}
