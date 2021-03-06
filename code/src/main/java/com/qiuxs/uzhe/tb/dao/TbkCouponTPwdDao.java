/*
 * 文件名称: TbkCouponTPwdDao.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-27
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.dao;
import com.qiuxs.frm.dao.IParentDaoWithBizKeys;
import com.qiuxs.frm.dao.MyBatisRepository;
import com.qiuxs.uzhe.tb.entity.TbkCouponTPwd;

/**
 * 优惠券链接淘口令Dao接口类
 * 
 * @author qiuxs created on 2017-12-27
 * @since 
 */
 @MyBatisRepository
public interface TbkCouponTPwdDao extends IParentDaoWithBizKeys<Long, TbkCouponTPwd> {

}
