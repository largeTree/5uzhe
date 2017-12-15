/*
 * 文件名称: MovieService.java
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

import com.qiuxs.movie.dao.MovieDao;
import com.qiuxs.movie.entity.Movie;
import com.qiuxs.movie.service.MovieService;
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
import com.qiuxs.fdn.utils.MapUtils;
import java.util.Set;
import com.qiuxs.fdn.bean.Pair;
import com.qiuxs.frm.code.provider.ICodeTranslatables;
import com.qiuxs.frm.code.bean.ICodeItem;
import com.qiuxs.frm.code.service.ISupportCodeContainerService;
import com.qiuxs.frm.code.provider.AbstractCodeContainer;
import com.qiuxs.frm.code.provider.ICodeContainer;
import com.qiuxs.fdn.bean.UserLite;
import com.qiuxs.frm.context.UserContext;

/**
 * 电影服务实现类
 * @author qiuxs created on 2017-12-15
 * @since 
 */
@Service("MovieService")
public class MovieService extends AbstractService<Long, Movie, MovieDao>
        implements ICodeTranslatables<Long>, ISupportCodeContainerService<Long> {

	@Resource
	private MovieClassService movieClassSvc;

	@Resource
	private MovieTagService movieTagSvc;

	@Resource
	private MovieDao movieDao;

	private final static String TABLE_NAME = "movie";
	public final static String VIEW_MOVIE = "movie";

	/**
	 * 构造函数
	 */
	public MovieService() {
		super();
		this.pojoClass = Movie.class;
		this.tableName = TABLE_NAME;
		this.description = "电影";
		ViewIndex.putService(VIEW_MOVIE, this);//, ViewIndex.TOPIC_BASE
	}

	@Override
	public MovieDao getDao() {
		return movieDao;
	}

	@Override
	protected void initCreate(Movie movie) {
		super.initCreate(movie);
	}

	/**
	 * 查询有效的电影对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
	public List<Movie> findValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
		parameters.put("flag" + ActionConstants.THAN_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.VALID);
		return super.findByWhere(parameters, pageInfo);
	}

	/**
	 * 查询无效或删除的电影对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
	public List<Movie> findInValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
		parameters.put("flag" + ActionConstants.LESS_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.INVALID);
		return super.findByWhere(parameters, pageInfo);
	}

	@Override
	public String getCaption(Long code) {
		if (code == null)
			return null;
		Movie movie = this.get(code);
		if (movie != null) {
			return movie.getName();
		}
		return code.toString();
	}

	@Override
	public Map<Long, String> getCaptions(Set<Long> codes) {
		List<Pair<Long, String>> maps = getDao().findCaptionPairsByIds(codes);
		return MapUtils.changeToMap(maps);
	}

	/**
	 * 根据名称或拼音模糊检索符合条件的编码项
	 * @param unitId 单元id
	 * @param searchToken 搜索串
	 * @return
	 */
	private List<ICodeItem<Long>> searchOptions(Long unitId, String searchToken) {
		if (searchToken == null || searchToken.length() == 0)
			return null;
		return getDao().searchOptions(
		        MapUtils.genMap("searchToken", searchToken, "unitId", unitId));
	}

	/**
	 * 获取所有的顶层编码项
	 * @param unitId 单元id
	 * @return
	 */
	private List<ICodeItem<Long>> getOptions(Long unitId) {
		return getDao().searchOptions(MapUtils.genMap("unitId", unitId));
	}

	private ICodeContainer<Long> codeSupport = null;

	@Override
	public ICodeContainer<Long> getTableCodeProvider(String hierId) {
		if (codeSupport != null)
			return codeSupport;
		codeSupport = new AbstractCodeContainer<Long>("/api.do?apikey=ec-movie-codes") {//参见AbstractPropertyAction.queryServiceCodes,需要在apiGateWay.xml中配置。

			@Override
			protected List<ICodeItem<Long>> getOptionsInner() {
				UserLite user = UserContext.getUserLite();
				return MovieService.this.getOptions(user.getUnitId());
			}

			@Override
			protected List<ICodeItem<Long>> searchOptionsInner(Long unitId, String searchToken) {
				return MovieService.this.searchOptions(unitId, searchToken);
			}

			@Override
			public String getCaption(Long code) {
				return MovieService.this.getCaption(code);
			}
		};
		return codeSupport;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter> filters) {
		filters.add(new IdServiceFilter<Long, Movie>(tableName));//为了主键生成
	}

	// -------------------------------- 以下为增删改查表单元数据配置 -------------------------------- //
	@Override
	protected String[] collectQueryProps() {
		return new String[] { "id" };
	}

	@Override
	protected String[] collectInputProps() {
		return new String[] { "id", "name", "cover", "tagIds", "classId", "marketDate", "desc" };
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

		prop = new ViewProperty<Object>(new BaseField("name", "name", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("cover", "cover", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Long>(new BaseField("tagIds", "tagIds", "String", true), this.movieTagSvc);
		props.add(prop);

		prop = new ViewProperty<Long>(new BaseField("classId", "classId", "Long"), this.movieClassSvc);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("marketDate", "marketDate", "Date"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("desc", "desc", "String"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("flag", "flag", "Integer"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("createdBy", "createdBy", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("createdDate", "createdDate", "Date"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("updatedBy", "updatedBy", "Long"), null);
		props.add(prop);

		prop = new ViewProperty<Object>(new BaseField("updatedDate", "updatedDate", "Date"), null);
		props.add(prop);
	}
}
