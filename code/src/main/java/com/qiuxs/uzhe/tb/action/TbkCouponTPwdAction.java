/*
 * 文件名称: TbkCouponTPwdAction.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-27
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.bizfdn.frm.action.BaseAction;
import com.qiuxs.fdn.bean.ActionResult;
import com.qiuxs.fdn.utils.MapUtils;
import com.qiuxs.uzhe.tb.dao.TbkCouponTPwdDao;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.tb.entity.TbkCouponTPwd;
import com.qiuxs.uzhe.tb.service.TbkCouponService;
import com.qiuxs.uzhe.tb.service.TbkCouponTPwdService;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoKeApiHelper;

/**
 * 优惠券链接淘口令入口
 * @author qiuxs created on 2017-12-27
 * @since 
 */
@Service("TbkCouponTPwdAction")
public class TbkCouponTPwdAction extends BaseAction<Long, TbkCouponTPwd, TbkCouponTPwdDao, TbkCouponTPwdService> {

	@Resource
	private TbkCouponTPwdService tbkCouponTPwdService;
	@Resource
	private TbkCouponService couponSvc;

	/**
	 * 根据优惠券ID获取淘口令
	 * @param params
	 * @return
	 */
	public ActionResult createTpwdByCoupon(Map<String, String> params) {
		Long id = MapUtils.getLongValueMust(params, "id");
		// 先根据优惠券ID和创建人ID查找已存在的淘口令 
		TbkCouponTPwd tpwd = this.getService().getByBizKeys(id, 0L);
		// 没有已存在的淘口令时 调用淘宝接口生成淘口令
		if (tpwd == null) {
			TbkCoupon tbkCoupon = this.couponSvc.getByIdMust(id);
			String stpwd = TaoBaoKeApiHelper.getInstance().createTpwd(null, tbkCoupon.getTitle(), tbkCoupon.getCouponClickUrl(), tbkCoupon.getJsmallImages().getString(0), null);
			StringBuilder desc = new StringBuilder();
			desc.append(tbkCoupon.getShopTitle()).append("\n") // 店铺名称
			.append(tbkCoupon.getTitle()).append("\n") // 商品标题
			.append(tbkCoupon.getItemDescription())// 商品描述信息
			.append("￥").append(stpwd).append("￥") // 淘口令
			.append("复制此信息打开淘宝领取优惠券!");

			// 保存淘口令
			tpwd = new TbkCouponTPwd();
			tpwd.setCouponId(id);
			tpwd.setCreatedBy(0L);
			tpwd.setTPwd(stpwd);
			tpwd.setTPwdDesc(desc.toString());
			this.getService().create(tpwd);
		}
		return new ActionResult(tpwd);
	}

	@Override
	protected TbkCouponTPwdService getService() {
		return tbkCouponTPwdService;
	}

	@Override
	protected Class<TbkCouponTPwd> getEntityClass() {
		return TbkCouponTPwd.class;
	}

}
