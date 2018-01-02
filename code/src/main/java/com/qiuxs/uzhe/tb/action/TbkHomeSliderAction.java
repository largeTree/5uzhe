/*
 * 文件名称: TbkHomeSliderAction.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2018-1-2
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.action;

import com.qiuxs.uzhe.tb.entity.TbkHomeSlider;
import com.qiuxs.uzhe.tb.service.TbkHomeSliderService;
import com.qiuxs.uzhe.tb.dao.TbkHomeSliderDao;
import com.qiuxs.bizfdn.frm.action.BaseAction;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.qiuxs.fdn.bean.ActionResult;
import com.qiuxs.frm.action.ActionConstants;

/**
 * 首页轮播图入口
 * @author qiuxs created on 2018-1-2
 * @since 
 */
@Service("TbkHomeSliderAction")
public class TbkHomeSliderAction extends BaseAction<Long, TbkHomeSlider, TbkHomeSliderDao, TbkHomeSliderService> {
    
	@Resource
    private TbkHomeSliderService tbkHomeSliderService;
    
    @Override
    protected TbkHomeSliderService getService() {
        return tbkHomeSliderService;
    }    

    @Override
    protected Class<TbkHomeSlider> getEntityClass() {
        return TbkHomeSlider.class;
    }
    
    @Override
	public ActionResult list(Map<String, String> reqParam, String jsonData, String listMethod, boolean paging) {
		reqParam.put("flag" + ActionConstants.THAN_EQUAL_SUFFIX, String.valueOf(com.qiuxs.fdn.entity.IStatus.VALID));
		return super.list(reqParam, jsonData, listMethod, paging);
	}
}
