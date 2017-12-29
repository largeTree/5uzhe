/*
 * 文件名称: TbkGoodInfoAction.java
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

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.bizfdn.frm.action.BaseAction;
import com.qiuxs.fdn.bean.ActionResult;
import com.qiuxs.fdn.utils.MapUtils;
import com.qiuxs.uzhe.tb.dao.TbkItemInfoDao;
import com.qiuxs.uzhe.tb.entity.TbkItemInfo;
import com.qiuxs.uzhe.tb.service.TbkItemInfoService;
import com.qiuxs.uzhe.thirdparty.alimama.TaoBaoConstants;

/**
 * 角色表入口
 * @author qiuxs created on 2017-12-25
 * @since 
 */
@Service("TbkItemInfoAction")
public class TbkItemInfoAction extends BaseAction<Long, TbkItemInfo, TbkItemInfoDao, TbkItemInfoService> {

	@Resource
	private TbkItemInfoService tbkItemInfoService;

	/**
	 * 根据业务主键获取商品详情
	 * @param params
	 * @return
	 */
	public ActionResult getByBizKeys(Map<String, String> params) {
		TbkItemInfo tbkItemInfo = this.getService().getByBizKeys(MapUtils.getLongValueMust(params, "numIid"), MapUtils.getIntValue(params, "platform", (int) TaoBaoConstants.PLATFORM_M));
		return new ActionResult(tbkItemInfo);
	}

	// ================================= 以下为自动生成代码 =======================================

	@Override
	protected TbkItemInfoService getService() {
		return tbkItemInfoService;
	}

	@Override
	protected Class<TbkItemInfo> getEntityClass() {
		return TbkItemInfo.class;
	}

}
