/*
 * 文件名称: MovieTagDao.java
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
import com.qiuxs.frm.dao.IParentDaoWithBizKeys;
import com.qiuxs.frm.dao.MyBatisRepository;
import com.qiuxs.movie.entity.MovieTag;
import java.util.Set;
import java.util.List;
import com.qiuxs.fdn.bean.Pair;
import com.qiuxs.frm.code.bean.ICodeItem;
import java.util.Map;

/**
 * 电影标签Dao接口类
 * 
 * @author qiuxs created on 2017-12-15
 * @since 
 */
 @MyBatisRepository
public interface MovieTagDao extends IParentDaoWithBizKeys<Long, MovieTag> {
	/**
	 * 根据编码值批量查询编码项列表
	 * @param dictKeys
	 * @return
	 */
	public List<Pair<Long, String>> findCaptionPairsByIds (Set<Long> codes);
	
	/**
	  * 按照名称或拼音模糊检索编码项列表
	  * @param params 其中包含： searchToken为模糊检索串、unitId为单元id
	  * @return 
	 */
	public List<ICodeItem<Long>> searchOptions(Map<String, Object> params);
}
