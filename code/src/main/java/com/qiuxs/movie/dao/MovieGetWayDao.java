/*
 * 文件名称: MovieGetWayDao.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-15
 * 修改内容: 
 */
package com.qiuxs.movie.dao;
import com.qiuxs.frm.dao.IParentDAO;
import com.qiuxs.frm.dao.MyBatisRepository;
import com.qiuxs.movie.entity.MovieGetWay;

/**
 * 电影获取方式Dao接口类
 * 
 * @author qiuxs created on 2017-12-15
 * @since 
 */
 @MyBatisRepository
public interface MovieGetWayDao extends IParentDAO<Long, MovieGetWay> {

}
