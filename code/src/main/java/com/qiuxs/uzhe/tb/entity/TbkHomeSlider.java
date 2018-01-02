/*
 * 文件名称: TbkHomeSlider.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2018-1-2
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.entity;

import com.qiuxs.fdn.entity.BaseEntity;
import com.qiuxs.fdn.entity.IStatus;

/**
 * 首页轮播图对象类
 * @author qiuxs created on 2018-1-2
 * @since
 */
public class TbkHomeSlider extends BaseEntity<Long> implements IStatus {
	private static final long serialVersionUID = 1L;

	/** 图片地址 */
	private String imgUrl;

	/** 点击跳转地址 */
	private String clickUrl;

	/** 状态 */
	private Integer flag;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getClickUrl() {
		return clickUrl;
	}

	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
