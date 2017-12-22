/**
 * 
 */
package com.qiuxs.uzhe.tb.schedule;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.qiuxs.uzhe.tb.service.TbkCouponService;

/**
 * 拉取优惠券调度器
 * 
 * @author qiuxs
 *
 */
@Service
public class FetchCouponSchedule {

	private static final Logger log = Logger.getLogger(FetchCouponSchedule.class);

	private static final long adzoneId = 171662812;

	private static long pageNo = 1;
	private static long pageSize = 100;

	@Resource
	private TbkCouponService tbkCouponSvc;

	@Scheduled(fixedDelay = 1000 * 60 * 30)
	public void schedule() {
//		log.info("FetchCoupons in time");
//		TaoBaoKeApiHelper helper = TaoBaoKeApiHelper.getInstance();
//		JSONObject res = helper.findCoupon(adzoneId, TaoBaoConstants.PLATFORM_PC, null, null, pageNo, pageSize);
//		List<TbkCoupon> tbkCoupons = JsonUtils.jsonArray2List(res.getString("results"), TbkCoupon.class);
//		this.tbkCouponSvc.createInBatch(tbkCoupons);
	}

}
