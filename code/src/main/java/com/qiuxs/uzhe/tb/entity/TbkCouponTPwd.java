/*
 * 文件名称: TbkCouponTPwd.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-27
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.entity;

import com.qiuxs.fdn.entity.BaseEntity;

/**
 * 优惠券链接淘口令对象类
 * @author qiuxs created on 2017-12-27
 * @since
 */
public class TbkCouponTPwd extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;
	
	/***/		
	private Long couponId;
	
	/***/		
	private String tPwd;
	
	/***/		
	private String tPwdDesc;
	
	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	
	public String getTPwd() {
		return tPwd;
	}

	public void setTPwd(String tPwd) {
		this.tPwd = tPwd;
	}
	
	public String getTPwdDesc() {
		return tPwdDesc;
	}

	public void setTPwdDesc(String tPwdDesc) {
		this.tPwdDesc = tPwdDesc;
	}
	
}
