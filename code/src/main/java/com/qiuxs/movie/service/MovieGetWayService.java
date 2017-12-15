/*
 * 文件名称: MovieGetWayService.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-15
 * 修改内容: 
 */
package com.qiuxs.movie.service;

import com.qiuxs.movie.dao.MovieGetWayDao;
import com.qiuxs.movie.entity.MovieGetWay;
import com.qiuxs.movie.service.MovieGetWayService;
import com.qiuxs.bizfdn.frm.bean.ViewProperty;
import com.qiuxs.bizfdn.frm.bean.BaseField;
import com.qiuxs.bizfdn.frm.bean.ViewIndex;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.qiuxs.frm.service.filter.IServiceFilter;
import com.qiuxs.frm.service.impl.IdServiceFilter;
import org.springframework.stereotype.Service;
import com.qiuxs.bizfdn.frm.service.AbstractService;
import com.qiuxs.frm.dao.paging.PageInfo;
import com.qiuxs.frm.action.ActionConstants;

/**
 * 电影获取方式服务实现类
 * @author qiuxs created on 2017-12-15
 * @since 
 */
@Service("MovieGetWayService")
public class MovieGetWayService extends AbstractService<Long, MovieGetWay, MovieGetWayDao> {

	@Resource
	private MovieService movieSvc;

	@Resource
	private MovieGetWayDao movieGetWayDao;

	private final static String TABLE_NAME = "movie_get_way";
	public final static String VIEW_MOVIEGETWAY = "movieGetWay";

	/**
	 * 构造函数
	 */
	public MovieGetWayService() {
		super();
		this.pojoClass = MovieGetWay.class;
		this.tableName = TABLE_NAME;
		this.description = "电影获取方式";
		ViewIndex.putService(VIEW_MOVIEGETWAY, this);//, ViewIndex.TOPIC_BASE
	}

	@Override
	public MovieGetWayDao getDao() {
		return movieGetWayDao;
	}

	@Override
	protected void initCreate(MovieGetWay movieGetWay) {
		super.initCreate(movieGetWay);
	}

	/**
	 * 查询有效的电影获取方式对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
	public List<MovieGetWay> findValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
		parameters.put("flag" + ActionConstants.THAN_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.VALID);
		return super.findByWhere(parameters, pageInfo);
	}

	/**
	 * 查询无效或删除的电影获取方式对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
	public List<MovieGetWay> findInValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
		parameters.put("flag" + ActionConstants.LESS_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.INVALID);
		return super.findByWhere(parameters, pageInfo);
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter> filters) {
		filters.add(new IdServiceFilter<Long, MovieGetWay>(tableName));//为了主键生成
	}

	// -------------------------------- 以下为增删改查表单元数据配置 -------------------------------- //
	@Override
	protected String[] collectQueryProps() {
		return new String[] { "id" };
	}

	@Override
	protected String[] collectInputProps() {
		return new String[] { "id", "movieId", "typeId", "target" };
	}

	@Override
	protected void initQueryProps(Map<String, ViewProperty<?>> queryPropMap, String viewId) {
		super.initQueryProps(queryPropMap, viewId);
	}

	@Override
	protected void initInputProps(Map<String, ViewProperty<?>> inputPropMap, String viewId) {
		super.initInputProps(inputPropMap, viewId);
	}

	@Override
	protected void initPropMapInner(List<ViewProperty<?>> props) {
		ViewProperty<?> prop = null;

		prop = new ViewProperty<Object>(new BaseField("id", "编号", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Long>(new BaseField("movieId", "movieId", "Long"), movieSvc);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("typeId", "typeId", "Integer"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("target", "target", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("flag", "flag", "Integer"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("createdDate", "createdDate", "Date"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("createdBy", "createdBy", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("updatedDate", "updatedDate", "Date"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("updatedBy", "updatedBy", "Long"), null);
		props.add(prop);
	}
}
