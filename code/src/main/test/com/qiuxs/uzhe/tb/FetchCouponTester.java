/**
 * 
 */
package com.qiuxs.uzhe.tb;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.qiuxs.fdn.utils.converter.JsonUtils;
import com.qiuxs.frm.test.BaseSpringTestCase;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoConstants;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoKeApiHelper;

/**
 * @author qiuxs
 *
 */
public class FetchCouponTester extends BaseSpringTestCase {

	@Test
	public void testGetCpupon() {
		TaoBaoKeApiHelper helper = TaoBaoKeApiHelper.getInstance();
		JSONObject res = helper.findCoupon(171662812L, TaoBaoConstants.PLATFORM_PC, null, null, 1L, 100L);
		List<TbkCoupon> tbkCoupons = JsonUtils.jsonArray2List(res.getString("results"), TbkCoupon.class);
		System.out.println("ok");
	}

}
