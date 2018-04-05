/*
 * 文件名称: TbkGoodInfoService.java
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
import com.qiuxs.fdn.utils.ListUtils;
import com.qiuxs.frm.service.filter.IServiceFilter;
import com.qiuxs.frm.service.impl.IdServiceFilter;
import com.qiuxs.uzhe.tb.dao.TbkItemInfoDao;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.tb.entity.TbkItemInfo;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoConstants;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoKeApiHelper;

/**
 * 角色表服务实现类
 * @author qiuxs created on 2017-12-25
 * @since 
 */
@Service("TbkItemInfoService")
public class TbkItemInfoService extends AbstractService<Long, TbkItemInfo, TbkItemInfoDao> {

	@Resource
	private TbkItemInfoDao tbkItemInfoDao;

	private final static String TABLE_NAME = "tbk_item_info";
	public final static String VIEW_TBKGOODINFO = "tbkGoodInfo";

	/**
	 * 构造函数
	 */
	public TbkItemInfoService() {
		super();
		this.pojoClass = TbkItemInfo.class;
		this.tableName = TABLE_NAME;
		this.description = "角色表";
		ViewIndex.putService(VIEW_TBKGOODINFO, this);// , ViewIndex.TOPIC_BASE
	}

	@Override
	public TbkItemInfoDao getDao() {
		return tbkItemInfoDao;
	}

	@Override
	protected void initCreate(TbkItemInfo tbkItemInfo) {
		super.initCreate(tbkItemInfo);
	}

	@Override
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void create(TbkItemInfo tbkItemInfo) {
		if (!this.isExistByBizKeys(tbkItemInfo.getNumIid(), tbkItemInfo.getPlatform())) {
			super.create(tbkItemInfo);
		}
		else
			throw new RuntimeException("指定的信息已经存在!");
	}

	/**
	 * 根据业务主键查询数据，返回单条记录
	 * @return
	 */
	public TbkItemInfo getByBizKeys(Long numIid, Integer platform) {
		return super.getByBizKeysInner("numIid", numIid, "platform", platform);
	}

	/**
	 * 根据业务主键修改数据
	 */
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void updateByBizKeys(TbkItemInfo object) {
		super.updateByBizKeys(object);
	}

	/**
	 * 根据业务主键删除数据
	 */
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void deleteByBizKeys(Long numIid, Integer platform) {
		TbkItemInfo bean = getByBizKeys(numIid, platform);
		if (bean != null)
			delete(bean);
	}

	/**
	 * 是否存在指定的业务主键记录
	 * @return
	 */
	public boolean isExistByBizKeys(Long numIid, Integer platform) {
		return super.isExistByBizKeysInner("numIid", numIid, "platform", platform);
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter> filters) {
		filters.add(new IdServiceFilter<Long, TbkItemInfo>(tableName));// 为了主键生成
	}

	// -------------------------------- 以下为增删改查表单元数据配置
	// -------------------------------- //
	@Override
	protected String[] collectQueryProps() {
		return new String[] { "id" };
	}

	@Override
	protected String[] collectInputProps() {
		return new String[] { "id", "numIid", "title", "pictUrl", "smallImages", "reservePrice", "zkFinalPrice", "userType", "provcity", "itemUrl", "nick", "sellerId", "volume", "catLeafName", "catName", "platform" };
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

		prop = new ViewProperty<Object>(new BaseField("numIid", "numIid", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("title", "title", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("pictUrl", "pictUrl", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("smallImages", "smallImages", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("reservePrice", "reservePrice", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("zkFinalPrice", "zkFinalPrice", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("userType", "userType", "Integer"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("provcity", "provcity", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("itemUrl", "itemUrl", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("nick", "nick", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("sellerId", "sellerId", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("volume", "volume", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("catLeafName", "catLeafName", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("catName", "catName", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("platform", "platform", "Integer"), null);
		props.add(prop);
	}

	/**
	 * 根据优惠券信息填充商品信息
	 * @param findCoupon
	 */
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public void fetchTbkItemInfoWith(List<TbkCoupon> findCoupon) {
		this.fetchTbkGoodInfos(findCoupon, TaoBaoConstants.PLATFORM_M);
		this.fetchTbkGoodInfos(findCoupon, TaoBaoConstants.PLATFORM_PC);
	}

	private void fetchTbkGoodInfos(List<TbkCoupon> coupons, long platform) {
		List<Long> ids = new ArrayList<Long>();
		for (TbkCoupon coupon : coupons) {
			ids.add(coupon.getNumIid());
			if (ids.size() == 40) {
				List<TbkItemInfo> tbkItemInfos = TaoBaoKeApiHelper.getInstance().findTbkGoodInfo(platform, ListUtils.listToString(ids));
				this.createInBatchIfBizKeyNotExists(tbkItemInfos);
				ids.clear();
			}
		}
		if (ids.size() > 0) {
			List<TbkItemInfo> tbkItemInfos = TaoBaoKeApiHelper.getInstance().findTbkGoodInfo(platform, ListUtils.listToString(ids));
			this.createInBatchIfBizKeyNotExists(tbkItemInfos);
		}
	}

	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public void createInBatchIfBizKeyNotExists(List<TbkItemInfo> beans) {
		if (!ListUtils.isNullOrEmptyList(beans)) {
			List<TbkItemInfo> tempList = new ArrayList<>();
			for (TbkItemInfo bean : beans) {
				if (!this.isExistByBizKeys(bean.getNumIid(), bean.getPlatform())) {
					tempList.add(bean);
				}
			}
			this.createInBatch(tempList);
		}
	}
}
