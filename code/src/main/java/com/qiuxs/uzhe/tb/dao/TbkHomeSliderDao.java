/*
 * 文件名称: TbkHomeSliderDao.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2018-1-2
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.dao;
import com.qiuxs.frm.dao.IParentDAO;
import com.qiuxs.frm.dao.MyBatisRepository;
import com.qiuxs.uzhe.tb.entity.TbkHomeSlider;

/**
 * 首页轮播图Dao接口类
 * 
 * @author qiuxs created on 2018-1-2
 * @since 
 */
 @MyBatisRepository
public interface TbkHomeSliderDao extends IParentDAO<Long, TbkHomeSlider> {

}
