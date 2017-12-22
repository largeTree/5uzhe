package com.qiuxs.uzhe.thirdparty.alimama;

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
	/** 要求的响应格式 */
	private static final String FORMAT = "format";
	/** 是否使用简单json格式 */
	private static final String SIMPLIFY = "simplify";

	/** ApiUrl */
	private String url;
	/** AppKey */
	private String app_key;
	/** AppSecret */
	private String app_secret;
	/** 格式 */
	private String format;
	/** 是否启用简单格式 */
	private boolean simplify;

	private static class InstanceHolder {
		private static final TaoBaoConfig instance = new TaoBaoConfig();
	}

	private TaoBaoConfig() {
		IConfiguration config = UConfigUtils.getConfig(CONFIG_DOMAIN);
		this.url = config.getString(URL);
		this.app_key = config.getString(APP_KEY);
		this.app_secret = config.getString(APP_SECRET);
		this.format = config.getString(FORMAT, "json");
		this.simplify = config.getBoolean(SIMPLIFY, true);
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

	/**
	 * 获取响应格式
	 * @return
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * 是否启用简单格式
	 * @return the simplify
	 */
	public boolean isSimplify() {
		return this.simplify;
	}

}
