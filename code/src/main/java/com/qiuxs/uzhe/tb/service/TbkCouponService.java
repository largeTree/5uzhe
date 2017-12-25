/*
 * 文件名称: TbkCouponService.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-25
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiuxs.bizfdn.frm.bean.BaseField;
import com.qiuxs.bizfdn.frm.bean.ViewIndex;
import com.qiuxs.bizfdn.frm.bean.ViewProperty;
import com.qiuxs.bizfdn.frm.service.AbstractService;
import com.qiuxs.frm.service.filter.IServiceFilter;
import com.qiuxs.frm.service.impl.IdServiceFilter;
import com.qiuxs.uzhe.tb.dao.TbkCouponDao;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;

/**
 * 角色表服务实现类
 * @author qiuxs created on 2017-12-25
 * @since 
 */
@Service("TbkCouponService")
public class TbkCouponService extends AbstractService<Long, TbkCoupon, TbkCouponDao>
{

	@Resource
	private TbkCouponDao tbkCouponDao;

	private final static String TABLE_NAME = "tbk_coupon";
	public final static String VIEW_TBKCOUPON = "tbkCoupon";

	/**
	 * 构造函数
	 */
	public TbkCouponService() {
		super();
		this.pojoClass = TbkCoupon.class;
		this.tableName = TABLE_NAME;
		this.description = "角色表";
		ViewIndex.putService(VIEW_TBKCOUPON, this);// , ViewIndex.TOPIC_BASE
	}

	@Override
	public TbkCouponDao getDao() {
		return tbkCouponDao;
	}

	@Override
	protected void initCreate(TbkCoupon tbkCoupon) {
		super.initCreate(tbkCoupon);
	}

	@Override
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void create(TbkCoupon tbkCoupon) {
		if (!this.isExistByBizKeys(tbkCoupon.getNumIid())) {
			super.create(tbkCoupon);
		}
		else
			throw new RuntimeException("指定的信息已经存在!");
	}

	/**
	 * 根据业务主键查询数据，返回单条记录
	 * @return
	 */
	public TbkCoupon getByBizKeys(Long numIid) {
		return super.getByBizKeysInner("numIid", numIid);
	}

	/**
	 * 根据业务主键修改数据
	 */
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void updateByBizKeys(TbkCoupon object) {
		super.updateByBizKeys(object);
	}

	/**
	 * 根据业务主键删除数据
	 */
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void deleteByBizKeys(Long numIid) {
		TbkCoupon bean = getByBizKeys(numIid);
		if (bean != null)
			delete(bean);
	}

	/**
	 * 是否存在指定的业务主键记录
	 * @return
	 */
	public boolean isExistByBizKeys(Long numIid) {
		return super.isExistByBizKeysInner("numIid", numIid);
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter> filters) {
		filters.add(new IdServiceFilter<Long, TbkCoupon>(tableName));// 为了主键生成
	}

	// -------------------------------- 以下为增删改查表单元数据配置
	// -------------------------------- //
	@Override
	protected String[] collectQueryProps() {
		return new String[] { "id" };
	}

	@Override
	protected String[] collectInputProps() {
		return new String[] { "id", "shopTitle", "userType", "title", "nick", "sellerId", "volume", "zkFinalPrice", "smallImages", "pictUrl", "itemUrl", "couponTotalCount", "commissionRate", "couponInfo", "category", "numIid", "couponRemainCount", "couponStartTime", "couponEndTime", "couponClickUrl", "itemDescription" };
	}

	@Override
	protected void initQueryProps(Map<String, ViewProperty<?>> queryPropMap, String viewId) {
		super.initQueryProps(queryPropMap, viewId);
	}

	@Override
	protected void initInputProps(Map<String, ViewProperty<?>> inputPropMap, String viewId) {
		super.initInputProps(inputPropMap, viewId);
	}

	@Override
	protected void initPropMapInner(List<ViewProperty<?>> props) {
		ViewProperty<?> prop = null;

		prop = new ViewProperty<Object>(new BaseField("id", "编号", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("shopTitle", "shopTitle", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("userType", "userType", "Integer"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("title", "title", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("nick", "nick", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("sellerId", "sellerId", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("volume", "volume", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("zkFinalPrice", "zkFinalPrice", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("smallImages", "smallImages", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("pictUrl", "pictUrl", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("itemUrl", "itemUrl", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("couponTotalCount", "couponTotalCount", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("commissionRate", "commissionRate", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("couponInfo", "couponInfo", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("category", "category", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("numIid", "numIid", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("couponRemainCount", "couponRemainCount", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("couponStartTime", "couponStartTime", "Date"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("couponEndTime", "couponEndTime", "Date"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("couponClickUrl", "couponClickUrl", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("itemDescription", "itemDescription", "String"), null);
		props.add(prop);
	}

	/**
	 * @param tbkCoupons
	 */
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public void createInBatchIfBizKeyNotExists(List<TbkCoupon> tbkCoupons) {
		List<TbkCoupon> newList = new ArrayList<>();
		// 先遍历一边把业务主键不冲突的bean放进新列表
		for (TbkCoupon coupon : tbkCoupons) {
			if (!this.isExistByBizKeys(coupon.getNumIid())) {
				newList.add(coupon);
			}
		}
		// 新列表不为空的情况下 进行批量创建
		if (newList.size() > 0) {
			this.createInBatch(newList);
		}
	}
}
