/*
 * 文件名称: TbkCouponAction.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-22
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.action;

import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.tb.service.TbkCouponService;
import com.qiuxs.uzhe.tb.dao.TbkCouponDao;
import com.qiuxs.bizfdn.frm.action.BaseAction;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 角色表入口
 * @author qiuxs created on 2017-12-22
 * @since 
 */
@Service("TbkCouponAction")
public class TbkCouponAction extends BaseAction<Long, TbkCoupon, TbkCouponDao, TbkCouponService> {
    
	@Resource
    private TbkCouponService tbkCouponService;
    
    @Override
    protected TbkCouponService getService() {
        return tbkCouponService;
    }    

    @Override
    protected Class<TbkCoupon> getEntityClass() {
        return TbkCoupon.class;
    }

}
