/*
 * 文件名称: Movie.java
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

import java.util.Date;

import com.qiuxs.fdn.entity.IStatus;

/**
 * 电影对象类
 * @author qiuxs created on 2017-12-15
 * @since
 */
public class Movie extends BaseEntity<Long> implements IStatus {
	private static final long serialVersionUID = 1L;

	/** 电影名 */
	private String name;

	/** 封面 */
	private String cover;

	/** 标签列表 */
	private String tagIds;

	/** 电影类别 */
	private Long classId;

	/** 上映时间 */
	private Date marketDate;

	/** 描述 */
	private String desc;

	/** 状态 */
	private Integer flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Date getMarketDate() {
		return marketDate;
	}

	public void setMarketDate(Date marketDate) {
		this.marketDate = marketDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
