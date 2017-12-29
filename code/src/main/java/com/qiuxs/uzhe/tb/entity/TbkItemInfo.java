/*
 * 文件名称: TbkGoodInfo.java
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

import com.alibaba.fastjson.annotation.JSONField;
import com.qiuxs.fdn.entity.BaseEntity;
import com.qiuxs.fdn.utils.converter.JsonUtils;
import com.taobao.api.domain.NTbkItem;

/**
 * 角色表对象类
 * @author qiuxs created on 2017-12-25
 * @since
 */
public class TbkItemInfo extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	/** 商品ID */
	@JSONField(name = "num_iid")
	private Long numIid;

	/** 商品标题 */
	@JSONField(name = "title")
	private String title;

	/** 商品主图 */
	@JSONField(name = "pict_url")
	private String pictUrl;

	/** 商品小图列表 */
	@JSONField(name = "small_images")
	private String smallImages;

	/** 一口价 */
	@JSONField(name = "reserve_price")
	private String reservePrice;

	/** 折后价 */
	@JSONField(name = "zk_final_price")
	private String zkFinalPrice;

	/** 卖家类型 */
	@JSONField(name = "user_type")
	private Integer userType;

	/** 宝贝所在地 */
	@JSONField(name = "provcity")
	private String provcity;

	/** 商品详情链接 */
	@JSONField(name = "item_url")
	private String itemUrl;

	/** 卖家昵称 */
	@JSONField(name = "nick")
	private String nick;

	/** 卖家ID */
	@JSONField(name = "seller_id")
	private Long sellerId;

	/** 30天销量 */
	@JSONField(name = "volume")
	private Long volume;

	/** 叶子类目名称 */
	@JSONField(name = "cat_leaf_name")
	private String catLeafName;

	/** 一级类目名称 */
	@JSONField(name = "cat_name")
	private String catName;

	/** 平台类型，1代表PC端，2代表移动端 */
	@JSONField(name = "platform")
	private Integer platform;

	public TbkItemInfo() {
	}

	public TbkItemInfo(NTbkItem item) {
		this.setNumIid(item.getNumIid());
		this.setTitle(item.getTitle());
		this.setPictUrl(item.getPictUrl());
		this.setSmallImages(JsonUtils.toJSONString(item.getSmallImages()));
		this.setReservePrice(item.getReservePrice());
		this.setZkFinalPrice(item.getZkFinalPrice());
		this.setUserType(item.getUserType().intValue());
		this.setProvcity(item.getProvcity());
		this.setItemUrl(item.getItemUrl());
		this.setNick(item.getNick());
		this.setSellerId(item.getSellerId());
		this.setVolume(item.getVolume());
		this.setCatLeafName(item.getCatLeafName());
		this.setCatName(item.getCatName());
	}

	public Long getNumIid() {
		return numIid;
	}

	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPictUrl() {
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}

	public String getSmallImages() {
		return smallImages;
	}

	public void setSmallImages(String smallImages) {
		this.smallImages = smallImages;
	}

	public String getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(String reservePrice) {
		this.reservePrice = reservePrice;
	}

	public String getZkFinalPrice() {
		return zkFinalPrice;
	}

	public void setZkFinalPrice(String zkFinalPrice) {
		this.zkFinalPrice = zkFinalPrice;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getProvcity() {
		return provcity;
	}

	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
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

	public String getCatLeafName() {
		return catLeafName;
	}

	public void setCatLeafName(String catLeafName) {
		this.catLeafName = catLeafName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

}
