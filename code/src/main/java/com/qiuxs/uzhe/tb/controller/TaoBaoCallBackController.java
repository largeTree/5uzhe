/**
 * 
 */
package com.qiuxs.uzhe.tb.controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.fdn.utils.FileUtils;
import com.qiuxs.fdn.utils.FilepathUtil;

/**
 * @author qiuxs
 *
 */
@RestController
@RequestMapping("/tb")
public class TaoBaoCallBackController {
	private static final Logger log = Logger.getLogger(TaoBaoCallBackController.class);

	@RequestMapping(value = "/callBack.do", produces = "application/json; charset=utf-8")
	public String callBack(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> headerNames = request.getHeaderNames();
		StringBuilder content = new StringBuilder();
		content.append("currentTimeMillis ==== ").append(System.currentTimeMillis()).append("\n\n");
		content.append("headers		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			content.append(name).append("=").append(request.getHeader(name)).append("\n");
		}
		content.append("\n");
		Map<String, String[]> params = request.getParameterMap();
		if (params != null && params.size() > 0) {
			content.append("params		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
			for (Iterator<Map.Entry<String, String[]>> iter = params.entrySet().iterator(); iter.hasNext();) {
				Map.Entry<String, String[]> entry = iter.next();
				content.append(entry.getKey()).append("=").append(Arrays.toString(entry.getValue())).append("\n");
			}
		}
		content.append("\n=====================================================================\n\n\n");
		try {
			FileUtils.appendString2File(FilepathUtil.getMyddocRealPath() + "callBack.txt", content.toString());
		} catch (Exception e) {
			log.error("ext=" + e.getLocalizedMessage(), e);
		}
		return "ok";
	}
}
