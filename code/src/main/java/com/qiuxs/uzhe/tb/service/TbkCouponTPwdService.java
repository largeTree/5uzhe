/*
 * 文件名称: TbkCouponTPwdService.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-27
 * 修改内容: 
 */
package com.qiuxs.uzhe.tb.service;

import com.qiuxs.uzhe.tb.dao.TbkCouponTPwdDao;
import com.qiuxs.uzhe.tb.entity.TbkCouponTPwd;
import com.qiuxs.uzhe.tb.service.TbkCouponTPwdService;
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

/**
 * 优惠券链接淘口令服务实现类
 * @author qiuxs created on 2017-12-27
 * @since 
 */
@Service("TbkCouponTPwdService")
public class TbkCouponTPwdService extends AbstractService<Long, TbkCouponTPwd, TbkCouponTPwdDao>
	 {
	
	@Resource
	private TbkCouponTPwdDao tbkCouponTPwdDao;
	
	private final static String TABLE_NAME = "tbk_coupon_tpwd";
    public final static String VIEW_TBKCOUPONTPWD = "tbkCouponTPwd";
	
	/**
     * 构造函数
     */
	public TbkCouponTPwdService() {
        super();
        this.pojoClass = TbkCouponTPwd.class;
        this.tableName = TABLE_NAME;
        this.description = "优惠券链接淘口令";
        ViewIndex.putService(VIEW_TBKCOUPONTPWD, this);//, ViewIndex.TOPIC_BASE
    }  
    
    @Override
    public TbkCouponTPwdDao getDao() {
        return tbkCouponTPwdDao;
    }
    
    @Override
    protected void initCreate(TbkCouponTPwd tbkCouponTPwd) {
    	super.initCreate(tbkCouponTPwd);
    }
    
    @Override
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
    public void create(TbkCouponTPwd tbkCouponTPwd) {
        if (!this.isExistByBizKeys(tbkCouponTPwd.getCouponId(), tbkCouponTPwd.getCreatedBy())) {
            super.create(tbkCouponTPwd);
        }        
        else
            throw new RuntimeException("指定的信息已经存在!");
    }
    
    /**
     * 根据业务主键查询数据，返回单条记录
     * @return
     */
    public TbkCouponTPwd getByBizKeys(Long couponId, Long createdBy) {
        return super.getByBizKeysInner("couponId", couponId, "createdBy", createdBy);
    }
    
    /**
     * 根据业务主键修改数据
     */
	@Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
    public void updateByBizKeys(TbkCouponTPwd object) {
        super.updateByBizKeys(object);
    }
    
    /**
     * 根据业务主键删除数据
     */
    @Transactional(rollbackFor = { java.lang.RuntimeException.class, java.lang.Exception.class })
    public void deleteByBizKeys(Long couponId, Long createdBy) {
        TbkCouponTPwd bean = getByBizKeys(couponId, createdBy);
        if (bean != null)
        	delete(bean);
    }
    
    /**
     * 是否存在指定的业务主键记录
     * @return
     */
    public boolean isExistByBizKeys(Long couponId, Long createdBy) {
        return super.isExistByBizKeysInner("couponId", couponId, "createdBy", createdBy);
    }

	
    @Override
    protected void initServiceFilters(List<IServiceFilter> filters) {    
        filters.add(new IdServiceFilter<Long, TbkCouponTPwd>(tableName));//为了主键生成
    }

	// -------------------------------- 以下为增删改查表单元数据配置 -------------------------------- //
    @Override
    protected String[] collectQueryProps() {
        return new String[] {"id"};
    }
    
    @Override
    protected String[] collectInputProps() {
    	return new String[] {"id", "couponId", "tPwd", "tPwdDesc"};
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
        
		prop = new ViewProperty<Object>(new BaseField("couponId", "couponId", "Long"), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new BaseField("tPwd", "tPwd", "String"), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new BaseField("tPwdDesc", "tPwdDesc", "String"), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new BaseField("createdBy", "createdBy", "Long"), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new BaseField("createdDate", "createdDate", "Date"), null);
    	props.add(prop);
    }
}
