/*
 * 文件名称: TbkHomeSliderService.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2018-1-2
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.bizfdn.frm.bean.BaseField;
import com.qiuxs.bizfdn.frm.bean.ViewIndex;
import com.qiuxs.bizfdn.frm.bean.ViewProperty;
import com.qiuxs.bizfdn.frm.service.AbstractService;
import com.qiuxs.frm.action.ActionConstants;
import com.qiuxs.frm.code.cache.CodeTranslatorCenter;
import com.qiuxs.frm.dao.paging.PageInfo;
import com.qiuxs.frm.service.filter.IServiceFilter;
import com.qiuxs.frm.service.impl.IdServiceFilter;
import com.qiuxs.uzhe.tb.dao.TbkHomeSliderDao;
import com.qiuxs.uzhe.tb.entity.TbkHomeSlider;

/**
 * 首页轮播图服务实现类
 * @author qiuxs created on 2018-1-2
 * @since 
 */
@Service("TbkHomeSliderService")
public class TbkHomeSliderService extends AbstractService<Long, TbkHomeSlider, TbkHomeSliderDao>
	 {
	
	@Resource
	private TbkHomeSliderDao tbkHomeSliderDao;
	
	private final static String TABLE_NAME = "tbk_home_slider";
    public final static String VIEW_TBKHOMESLIDER = "tbkHomeSlider";
	
	/**
     * 构造函数
     */
	public TbkHomeSliderService() {
        super();
        this.pojoClass = TbkHomeSlider.class;
        this.tableName = TABLE_NAME;
        this.description = "首页轮播图";
        ViewIndex.putService(VIEW_TBKHOMESLIDER, this);//, ViewIndex.TOPIC_BASE
    }  
    
    @Override
    public TbkHomeSliderDao getDao() {
        return tbkHomeSliderDao;
    }
    
    @Override
    protected void initCreate(TbkHomeSlider tbkHomeSlider) {
    	super.initCreate(tbkHomeSlider);
    }
   
	/**
	 * 查询有效的首页轮播图对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
    public List<TbkHomeSlider> findValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
    	parameters.put("flag" + ActionConstants.THAN_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.VALID);
    	return super.findByWhere(parameters, pageInfo);
    }
    
    /**
	 * 查询无效或删除的首页轮播图对象列表
	 * @param parameters 参数，条件同默认的findByWhere()
	 * @param pageInfo 分页信息
	 * @return
	 */
    public List<TbkHomeSlider> findInValidsByWhere(Map<String, Object> parameters, PageInfo pageInfo) {
    	parameters.put("flag" + ActionConstants.LESS_EQUAL_SUFFIX, com.qiuxs.fdn.entity.IStatus.INVALID);
    	return super.findByWhere(parameters, pageInfo);
    }

	
    @Override
    protected void initServiceFilters(List<IServiceFilter> filters) {    
        filters.add(new IdServiceFilter<Long, TbkHomeSlider>(tableName));//为了主键生成
    }

	// -------------------------------- 以下为增删改查表单元数据配置 -------------------------------- //
    @Override
    protected String[] collectQueryProps() {
        return new String[] {"id"};
    }
    
    @Override
    protected String[] collectInputProps() {
    	return new String[] {"id", "imgUrl", "clickUrl"};
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
        
		prop = new ViewProperty<Object>(new BaseField("imgUrl", "imgUrl", "String"), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new BaseField("clickUrl", "clickUrl", "String"), null);
    	props.add(prop);
        
		prop = new ViewProperty<Integer>(new BaseField("flag", "flag", "Integer"), CodeTranslatorCenter.CODE_FLAG);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new BaseField("createdBy", "createdBy", "Long"), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new BaseField("createdDate", "createdDate", "Date"), null);
    	props.add(prop);
    }
}
