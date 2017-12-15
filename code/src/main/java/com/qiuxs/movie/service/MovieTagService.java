/*
 * 文件名称: MovieTagService.java
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

import com.qiuxs.movie.dao.MovieTagDao;
import com.qiuxs.movie.entity.MovieTag;
import com.qiuxs.movie.service.MovieTagService;
import com.qiuxs.bizfdn.frm.bean.ViewProperty;
import com.qiuxs.bizfdn.frm.bean.BaseField;
import com.qiuxs.bizfdn.frm.bean.ViewIndex;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.qiuxs.frm.service.filter.IServiceFilter;
import com.qiuxs.frm.service.impl.IdServiceFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
 * 电影标签服务实现类
 * @author qiuxs created on 2017-12-15
 * @since 
 */
@Service("MovieTagService")
public class MovieTagService extends AbstractService<Long, MovieTag, MovieTagDao>
        implements ICodeTranslatables<Long>, ISupportCodeContainerService<Long> {

	@Resource
	private MovieTagDao movieTagDao;

	private final static String TABLE_NAME = "movie_tag";
	public final static String VIEW_MOVIETAG = "movieTag";

	/**
	 * 构造函数
	 */
	public MovieTagService() {
		super();
		this.pojoClass = MovieTag.class;
		this.tableName = TABLE_NAME;
		this.description = "电影标签";
		ViewIndex.putService(VIEW_MOVIETAG, this);//, ViewIndex.TOPIC_BASE
	}

	@Override
	public MovieTagDao getDao() {
		return movieTagDao;
	}

	@Override
	protected void initCreate(MovieTag movieTag) {
		super.initCreate(movieTag);
	}

	/**
	 * 查询有效的电影标签对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
	public List<MovieTag> findValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
		parameters.put("flag" + ActionConstants.THAN_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.VALID);
		return super.findByWhere(parameters, pageInfo);
	}

	/**
	 * 查询无效或删除的电影标签对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
	public List<MovieTag> findInValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
		parameters.put("flag" + ActionConstants.LESS_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.INVALID);
		return super.findByWhere(parameters, pageInfo);
	}

	@Override
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void create(MovieTag movieTag) {
		if (!this.isExistByBizKeys(movieTag.getCode())) {
			super.create(movieTag);
		}
		else
			throw new RuntimeException("指定的信息已经存在!");
	}

	/**
	 * 根据业务主键查询数据，返回单条记录
	 * @return
	 */
	public MovieTag getByBizKeys(String code) {
		return super.getByBizKeysInner("code", code);
	}

	/**
	 * 根据业务主键修改数据
	 */
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void updateByBizKeys(MovieTag object) {
		super.updateByBizKeys(object);
	}

	/**
	 * 根据业务主键删除数据
	 */
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
	public void deleteByBizKeys(String code) {
		MovieTag bean = getByBizKeys(code);
		if (bean != null)
			delete(bean);
	}

	/**
	 * 是否存在指定的业务主键记录
	 * @return
	 */
	public boolean isExistByBizKeys(String code) {
		return super.isExistByBizKeysInner("code", code);
	}

	@Override
	public String getCaption(Long code) {
		if (code == null)
			return null;
		MovieTag movieTag = this.get(code);
		if (movieTag != null) {
			return movieTag.getName();
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
		codeSupport = new AbstractCodeContainer<Long>("/api.do?apikey=ec-movieTag-codes") {//参见AbstractPropertyAction.queryServiceCodes,需要在apiGateWay.xml中配置。

			@Override
			protected List<ICodeItem<Long>> getOptionsInner() {
				UserLite user = UserContext.getUserLite();
				return MovieTagService.this.getOptions(user.getUnitId());
			}

			@Override
			protected List<ICodeItem<Long>> searchOptionsInner(Long unitId, String searchToken) {
				return MovieTagService.this.searchOptions(unitId, searchToken);
			}

			@Override
			public String getCaption(Long code) {
				return MovieTagService.this.getCaption(code);
			}
		};
		return codeSupport;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter> filters) {
		filters.add(new IdServiceFilter<Long, MovieTag>(tableName));//为了主键生成
	}

	// -------------------------------- 以下为增删改查表单元数据配置 -------------------------------- //
	@Override
	protected String[] collectQueryProps() {
		return new String[] { "id" };
	}

	@Override
	protected String[] collectInputProps() {
		return new String[] { "id", "name", "code" };
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

		prop = new ViewProperty<Object>(new BaseField("code", "code", "String"), null);
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
