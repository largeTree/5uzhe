package com.qiuxs.uzhe.thirdparty.alimama;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.qiuxs.fdn.utils.converter.JsonUtils;
import com.taobao.api.ApiException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.request.TbkDgItemCouponGetRequest;

/**
 * 淘宝Api调用帮助类
 * @author qiuxs
 *
 */
public class TaoBaoKeApiHelper {

	/**
	 * 好券清单Api【导购】
	 * @param adzoneId
	 * 		推广位ID  mm_xxxx_xxxx_xxxx  的第三位
	 * @param platform
	 * 		平台类型 
	 * 				PC端 {@link TaoBaoConstants#PLATFORM_M}
	 * 				移动端 {@link TaoBaoConstants#PLATFORM_M}
	 * @param cat
	 * 		后台类目ID，用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
	 * @param q	
	 * 		查询关键词
	 * @param pageNo
	 * 		当前页号
	 * @param pageSize
	 * 		每页行数
	 * @return
	 */
	public JSONObject findCoupon(long adzoneId, long platform, String cat, String q, long pageNo, long pageSize) {
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		req.setAdzoneId(adzoneId);
		req.setPlatform(platform);
		if (StringUtils.isNotBlank(cat)) {
			req.setCat(cat);
		}
		if (StringUtils.isNotBlank(q)) {
			req.setQ(q);
		}
		req.setPageNo(pageNo);
		req.setPageSize(pageSize);
		TaobaoResponse resp = execute(req);
		return JsonUtils.toJSONObject(resp.getBody());
	}

	private static class Holder {
		private static final DefaultTaobaoClient client;
		static {
			TaoBaoConfig instance = TaoBaoConfig.getInstance();
			client = new DefaultTaobaoClient(instance.getUrl(), instance.getAppKey(), instance.getAppSecret(), instance.getFormat());
			client.setUseSimplifyJson(instance.isSimplify());
		}
		private static final TaoBaoKeApiHelper helper;
		static {
			helper = new TaoBaoKeApiHelper();
		}
	}

	private TaoBaoKeApiHelper() {
	}

	public static TaoBaoKeApiHelper getInstance() {
		return Holder.helper;
	}

	private TaobaoResponse execute(BaseTaobaoRequest<? extends TaobaoResponse> req) {
		try {
			TaobaoResponse resp = Holder.client.execute(req);
			return resp;
		} catch (ApiException e) {
			throw new RuntimeException(e);
		}
	}

}
