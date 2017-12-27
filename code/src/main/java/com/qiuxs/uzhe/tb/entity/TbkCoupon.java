/*
 * 文件名称: TbkCoupon.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-25
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.qiuxs.fdn.entity.BaseEntity;
import com.qiuxs.fdn.utils.converter.JsonUtils;
import com.qiuxs.fdn.utils.date.DateFormatUtils;

/**
 * 角色表对象类
 * @author qiuxs created on 2017-12-25
 * @since
 */
public class TbkCoupon extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	/** 商品标题 */
	@JSONField(name = "shop_title")
	private String shopTitle;

	/** 卖家类型，0表示集市，1表示商城 */
	@JSONField(name = "user_type")
	private Integer userType;

	/** 商品标题 */
	@JSONField(name = "title")
	private String title;

	/** 卖家昵称 */
	@JSONField(name = "nick")
	private String nick;

	/** 卖家id */
	@JSONField(name = "seller_id")
	private Long sellerId;

	/** 30天销量 */
	@JSONField(name = "volume")
	private Long volume;

	/** 折扣价 */
	@JSONField(name = "zk_final_price")
	private String zkFinalPrice;

	/** 商品小图列表 */
	@JSONField(name = "small_images")
	private String smallImages;
	private JSONArray jsmallImages;

	/** 商品主图 */
	@JSONField(name = "pict_url")
	private String pictUrl;

	/** 商品详情页链接地址 */
	@JSONField(name = "item_url")
	private String itemUrl;

	/** 优惠券总量 */
	@JSONField(name = "coupon_total_count")
	private Long couponTotalCount;

	/** 佣金比率(%) */
	@JSONField(name = "commission_rate")
	private String commissionRate;

	/** 优惠券面额 */
	@JSONField(name = "coupon_info")
	private String couponInfo;

	/** 后台一级类目 */
	@JSONField(name = "category")
	private Long category;

	/** 商品ID */
	@JSONField(name = "num_iid")
	private Long numIid;

	/** 优惠券剩余量 */
	@JSONField(name = "coupon_remain_count")
	private Long couponRemainCount;

	/** 优惠券开始时间 */
	@JSONField(name = "coupon_start_time")
	private Date couponStartTime;

	/** 优惠券结束时间 */
	@JSONField(name = "coupon_end_time")
	private Date couponEndTime;

	/** 商品优惠券推广链接 */
	@JSONField(name = "coupon_click_url")
	private String couponClickUrl;

	/** 宝贝描述（推荐理由） */
	@JSONField(name = "item_description")
	private String itemDescription;

	public TbkCoupon() {
	}

	/**
	 * 转换淘宝bean
	 * @param src
	 */
	public TbkCoupon(com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon src) {
		this.setShopTitle(src.getShopTitle());
		this.setUserType(src.getUserType().intValue());
		this.setTitle(src.getTitle());
		this.setNick(src.getNick());
		this.setSellerId(src.getSellerId());
		this.setVolume(src.getVolume());
		this.setZkFinalPrice(src.getZkFinalPrice());
		this.setSmallImages(JsonUtils.toJSONString(src.getSmallImages()));
		this.setPictUrl(src.getPictUrl());
		this.setItemUrl(src.getItemUrl());
		this.setCouponTotalCount(src.getCouponTotalCount());
		this.setCommissionRate(src.getCommissionRate());
		this.setCouponInfo(src.getCouponInfo());
		this.setCategory(src.getCategory());
		this.setNumIid(src.getNumIid());
		this.setCouponRemainCount(src.getCouponRemainCount());
		this.setCouponStartTime(DateFormatUtils.parseDate(src.getCouponStartTime()));
		this.setCouponEndTime(DateFormatUtils.parseDate(src.getCouponEndTime()));
		this.setCouponClickUrl(src.getCouponClickUrl());
		this.setItemDescription(src.getItemDescription());
	}

	public String getShopTitle() {
		return shopTitle;
	}

	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public String getZkFinalPrice() {
		return zkFinalPrice;
	}

	public void setZkFinalPrice(String zkFinalPrice) {
		this.zkFinalPrice = zkFinalPrice;
	}

	public String getSmallImages() {
		return smallImages;
	}

	public void setSmallImages(String smallImages) {
		this.smallImages = smallImages;
		this.setJsmallImages(JsonUtils.toJSONArray(smallImages));
	}

	/**
	 * @return the jsmallImages
	 */
	public JSONArray getJsmallImages() {
		return jsmallImages;
	}

	/**
	 * @param jsmallImages the jsmallImages to set
	 */
	public void setJsmallImages(JSONArray jsmallImages) {
		this.jsmallImages = jsmallImages;
	}

	public String getPictUrl() {
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public Long getCouponTotalCount() {
		return couponTotalCount;
	}

	public void setCouponTotalCount(Long couponTotalCount) {
		this.couponTotalCount = couponTotalCount;
	}

	public String getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public void setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getNumIid() {
		return numIid;
	}

	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

	public Long getCouponRemainCount() {
		return couponRemainCount;
	}

	public void setCouponRemainCount(Long couponRemainCount) {
		this.couponRemainCount = couponRemainCount;
	}

	public Date getCouponStartTime() {
		return couponStartTime;
	}

	public void setCouponStartTime(Date couponStartTime) {
		this.couponStartTime = couponStartTime;
	}

	public Date getCouponEndTime() {
		return couponEndTime;
	}

	public void setCouponEndTime(Date couponEndTime) {
		this.couponEndTime = couponEndTime;
	}

	public String getCouponClickUrl() {
		return couponClickUrl;
	}

	public void setCouponClickUrl(String couponClickUrl) {
		this.couponClickUrl = couponClickUrl;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

}
