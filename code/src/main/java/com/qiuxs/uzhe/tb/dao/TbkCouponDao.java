/*
 * 文件名称: TbkCouponDao.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-22
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.dao;
import com.qiuxs.frm.dao.IParentDaoWithBizKeys;
import com.qiuxs.frm.dao.MyBatisRepository;
import com.qiuxs.uzhe.tb.entity.TbkCoupon;

/**
 * 角色表Dao接口类
 * 
 * @author qiuxs created on 2017-12-22
 * @since 
 */
 @MyBatisRepository
public interface TbkCouponDao extends IParentDaoWithBizKeys<Long, TbkCoupon> {

}
