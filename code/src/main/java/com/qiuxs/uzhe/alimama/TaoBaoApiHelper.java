package com.qiuxs.uzhe.alimama;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.response.TbkDgItemCouponGetResponse;

public class TaoBaoApiHelper {

	public static void main(String[] args) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "24738761", "b4043de735d6279e65a843570093a4f1");
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		req.setAdzoneId(41178251L);
		req.setPlatform(1L);
		req.setPageSize(20L);
		req.setQ("汉服");
		req.setPageNo(1L);
		TbkDgItemCouponGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}

}
