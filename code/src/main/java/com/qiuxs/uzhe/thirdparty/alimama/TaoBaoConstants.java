/**
 * 
 */
package com.qiuxs.uzhe.thirdparty.alimama;

import org.springframework.stereotype.Component;

import com.qiuxs.fdn.annotation.Code;
import com.qiuxs.fdn.annotation.CodeDomain;
import com.qiuxs.frm.code.CodeUtils;

/**
 * 淘宝接口常量
 * @author qiuxs
 *
 */
@Component
// 为了编码集
public class TaoBaoConstants {

	static {
		CodeUtils.genDirectCodes(TaoBaoConstants.class);
	}

	/** 淘宝平台类型 */
	@CodeDomain
	public static final String PLATFORM_CODE_COMAIN = "tb.platform.domain";
	/** PC端 */
	@Code(domain = PLATFORM_CODE_COMAIN, caption = "PC端")
	public static final long PLATFORM_PC = 1;
	/** 移动端 */
	@Code(domain = PLATFORM_CODE_COMAIN, caption = "移动端")
	public static final long PLATFORM_M = 2;

	/** 淘宝卖家类型 */
	@CodeDomain
	public static final String USER_TYPE_CODE_DOMAIN = "tb.userType.domain";
	/** 商城 */
	@Code(domain = USER_TYPE_CODE_DOMAIN, caption = "商城")
	public static final long USER_TYPE_MALL = 1;
	/** 集市 */
	@Code(domain = USER_TYPE_CODE_DOMAIN, caption = "集市")
	public static final long USER_TYPE_MARKET = 0;

}
