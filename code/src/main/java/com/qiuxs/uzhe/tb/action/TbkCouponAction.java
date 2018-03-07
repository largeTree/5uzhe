/*
 * 文件名称: TbkCouponAction.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-25
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.action;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.bizfdn.frm.action.BaseAction;
import com.qiuxs.fdn.bean.ActionResult;
import com.qiuxs.fdn.utils.MapUtils;
import com.qiuxs.uzhe.tb.dao.TbkCouponDao;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.tb.service.TbkCouponService;
import com.qiuxs.uzhe.tb.service.TbkItemInfoService;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoConfig;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoConstants;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoKeApiHelper;

/**
 * 角色表入口
 * @author qiuxs created on 2017-12-25
 * @since 
 */
@Service("TbkCouponAction")
public class TbkCouponAction extends BaseAction<Long, TbkCoupon, TbkCouponDao, TbkCouponService> {

	private static ExecutorService executor = Executors.newFixedThreadPool(6);

	@Resource
	private TbkCouponService tbkCouponService;

	@Resource
	private TbkItemInfoService tbkItemInfoService;

	public ActionResult searchFromAlimama(Map<String, String> params) {
		String searchToken = MapUtils.getStringValueMust(params, "searchToken");
		long pageNo = MapUtils.getLongValue(params, "pageNo", 1);
		long pageSize = MapUtils.getLongValue(params, "pageSize", 100);
		long platform = MapUtils.getLongValue(params, "platform", TaoBaoConstants.PLATFORM_M);
		List<TbkCoupon> findCoupon = TaoBaoKeApiHelper.getInstance().findCoupon(TaoBaoConfig.getInstance().getAdzoneId(), platform, null, searchToken, pageNo, pageSize);
		executor.execute(() -> {
			TbkCouponAction.this.getService().createInBatchIfBizKeyNotExists(findCoupon);
		});
		executor.execute(() -> {
			TbkCouponAction.this.tbkItemInfoService.fetchTbkItemInfoWith(findCoupon);
		});
		return new ActionResult(findCoupon);
	}

	@Override
	protected TbkCouponService getService() {
		return tbkCouponService;
	}

	@Override
	protected Class<TbkCoupon> getEntityClass() {
		return TbkCoupon.class;
	}

}
