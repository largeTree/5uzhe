/*
 * 文件名称: TbkGoodInfoDao.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-25
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.dao;
import com.qiuxs.frm.dao.IParentDaoWithBizKeys;
import com.qiuxs.frm.dao.MyBatisRepository;
import com.qiuxs.uzhe.tb.entity.TbkItemInfo;

/**
 * 角色表Dao接口类
 * 
 * @author qiuxs created on 2017-12-25
 * @since 
 */
 @MyBatisRepository
public interface TbkItemInfoDao extends IParentDaoWithBizKeys<Long, TbkItemInfo> {

}
