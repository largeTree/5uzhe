package com.qiuxs.movie.action;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qiuxs.fdn.bean.ActionResult;
import com.qiuxs.gateway.ifc.IUploadAction;

@Service("TestUploadAction")
public class TestUploadAction implements IUploadAction {

	@Override
	public ActionResult upload(Map<String, String> params, Map<String, MultipartFile> fileMap) {
		return new ActionResult();
	}

}
