/*
 * 文件名称: MovieClassAction.java
 * 版权信息: Copyright 2001-2017 qiuxs Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: qiuxs
 * 修改日期: 2017-12-14
 * 修改内容: 
 */
package com.qiuxs.movie.action;

import com.qiuxs.movie.entity.MovieClass;
import com.qiuxs.movie.service.MovieClassService;
import com.qiuxs.movie.dao.MovieClassDao;
import com.qiuxs.bizfdn.frm.action.BaseAction;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.qiuxs.fdn.bean.ActionResult;
import com.qiuxs.frm.action.ActionConstants;

/**
 * 电影类别入口
 * @author qiuxs created on 2017-12-14
 * @since 
 */
@Service("MovieClassAction")
public class MovieClassAction extends BaseAction<Long, MovieClass, MovieClassDao, MovieClassService> {
    
	@Resource
    private MovieClassService movieClassService;
    
    @Override
    protected MovieClassService getService() {
        return movieClassService;
    }    

    @Override
    protected Class<MovieClass> getEntityClass() {
        return MovieClass.class;
    }
    
    @Override
	public ActionResult list(Map<String, String> reqParam, String jsonData, String listMethod, boolean paging) {
		reqParam.put("flag" + ActionConstants.THAN_EQUAL_SUFFIX, String.valueOf(com.qiuxs.fdn.entity.IStatus.VALID));
		return super.list(reqParam, jsonData, listMethod, paging);
	}
}
