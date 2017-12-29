/**
 * 
 */
package com.qiuxs.uzhe.tb.schedule;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import com.qiuxs.fdn.utils.ListUtils;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.tb.entity.TbkItemInfo;
import com.qiuxs.uzhe.tb.service.TbkCouponService;
import com.qiuxs.uzhe.tb.service.TbkItemInfoService;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoKeApiHelper;

/**
 * 拉取优惠券调度器
 * 
 * @author qiuxs
 *
 */
public class FetchCouponSchedule {

	private static final Logger log = Logger.getLogger(FetchCouponSchedule.class);

	private long adzoneId;

	private static long pageNo = 1;
	private static long pageSize = 100;

	public FetchCouponSchedule(long adzoneId) {
		this.adzoneId = adzoneId;
	}

	@Resource
	private TbkCouponService tbkCouponSvc;

	@Resource
	private TbkItemInfoService tbkGoodInfoSvc;

	@Scheduled(fixedDelay = 1000 * 60 * 30)
	public void schedule() {
//		log.info("FetchCoupons in time");
//		TaoBaoKeApiHelper helper = TaoBaoKeApiHelper.getInstance();
//		List<TbkCoupon> tbkCoupons = helper.findCoupon(this.adzoneId, TaoBaoConstants.PLATFORM_PC, null, null, pageNo, pageSize);
//		this.tbkCouponSvc.createInBatchIfBizKeyNotExists(tbkCoupons);
//
//		// 同时拉取一下商品详情
//		this.fetchTbkGoodInfos(tbkCoupons, TaoBaoConstants.PLATFORM_M);
//		this.fetchTbkGoodInfos(tbkCoupons, TaoBaoConstants.PLATFORM_PC);
	}

	/**
	 * 拉取优惠券对应的商品详情
	 * @param coupons
	 * @param platform
	 */
	private void fetchTbkGoodInfos(List<TbkCoupon> coupons, long platform) {
		List<Long> ids = new ArrayList<Long>();
		for (TbkCoupon coupon : coupons) {
			ids.add(coupon.getNumIid());
			if (ids.size() == 40) {
				this.saveTbkGoodInfos(ids, platform);
				ids.clear();
			}
		}
		if (ids.size() > 0) {
			saveTbkGoodInfos(ids, platform);
		}
	}

	/**
	 * 拉取一次商品详情
	 * @param ids
	 * @param platform
	 */
	private void saveTbkGoodInfos(List<Long> ids, long platform) {
		String strids = ListUtils.listToString(ids);
		List<TbkItemInfo> tbkItemInfos = TaoBaoKeApiHelper.getInstance().findTbkGoodInfo(platform, strids);
		tbkGoodInfoSvc.createInBatch(tbkItemInfos);
	}

}
