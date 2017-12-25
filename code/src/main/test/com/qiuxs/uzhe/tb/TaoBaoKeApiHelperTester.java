/**
 * 
 */
package com.qiuxs.uzhe.tb;

import java.util.List;

import org.junit.Test;

import com.qiuxs.fdn.utils.converter.JsonUtils;
import com.qiuxs.frm.test.BaseSpringTestCase;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.tb.entity.TbkItemInfo;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoConstants;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoKeApiHelper;

/**
 * @author qiuxs
 *
 */
public class TaoBaoKeApiHelperTester extends BaseSpringTestCase {

	@Test
	public void testFindCoupon() {
		TaoBaoKeApiHelper helper = TaoBaoKeApiHelper.getInstance();
		List<TbkCoupon> tbkCoupons = helper.findCoupon(171662812L, TaoBaoConstants.PLATFORM_PC, null, null, 1L, 100L);
		System.out.println(JsonUtils.toJSONString(tbkCoupons));
	}

	@Test
	public void testFindGoods() {
		TaoBaoKeApiHelper helper = TaoBaoKeApiHelper.getInstance();
		List<TbkItemInfo> tbkItemInfos = helper.findTbkGoodInfo(TaoBaoConstants.PLATFORM_M, "559886090246,553570571480,558686686941");
		System.out.println(JsonUtils.toJSONString(tbkItemInfos));
	}

}
