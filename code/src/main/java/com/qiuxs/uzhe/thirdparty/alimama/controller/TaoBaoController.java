package com.qiuxs.uzhe.thirdparty.alimama.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taobao")
public class TaoBaoController {

	@RequestMapping(value = "callBack.do", produces = "application/json; charset=utf-8")
	public String callBack(HttpServletRequest request, HttpServletResponse response) {
		return "{\"val\":\"ok\"}";
	}

}
