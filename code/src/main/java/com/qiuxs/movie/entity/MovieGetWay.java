/*
 * 文件名称: MovieGetWay.java
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
 * 电影获取方式对象类
 * @author qiuxs created on 2017-12-15
 * @since
 */
public class MovieGetWay extends BaseEntity<Long> implements IStatus {
	private static final long serialVersionUID = 1L;

	/** 电影ID */
	private Long movieId;

	/** 获取方式类型 */
	private Integer typeId;

	/** 目标 */
	private String target;

	/** 状态 */
	private Integer flag;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
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
