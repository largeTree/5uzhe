/*
 * 文件名称: MovieTag.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-15
 * 修改内容: 
 */
package com.qiuxs.movie.entity;

import com.qiuxs.fdn.entity.BaseEntity;
import com.qiuxs.fdn.entity.IStatus;

/**
 * 电影标签对象类
 * @author qiuxs created on 2017-12-15
 * @since
 */
public class MovieTag extends BaseEntity<Long> implements IStatus {
	private static final long serialVersionUID = 1L;

	/** 标签名 */
	private String name;

	/** 标签编码 */
	private String code;

	/** 状态 */
	private Integer flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public Integer getFlag() {
		return flag;
	}

	@Override
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
