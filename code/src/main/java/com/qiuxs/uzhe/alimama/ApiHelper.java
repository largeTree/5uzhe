package com.qiuxs.uzhe.alimama;

import com.alibaba.fastjson.JSONObject;
import com.qiuxs.fdn.utils.converter.JsonUtils;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;

public class ApiHelper {
	public static JSONObject goodsSearch() throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "24738761", "b4043de735d6279e65a843570093a4f1");
		TbkItemGetRequest req = new TbkItemGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		req.setQ("女装");
		req.setSort("tk_rate_des");
		req.setStartPrice(10L);
		req.setEndPrice(10L);
		req.setStartTkRate(123L);
		req.setEndTkRate(123L);
		req.setPlatform(1L);
		req.setPageNo(1L);
		req.setPageSize(20L);
		TbkItemGetResponse rsp = client.execute(req);
		return JsonUtils.toJSONObject(rsp.getBody());
	}
	
	public static void main(String[] args) throws ApiException {
	    System.out.println(goodsSearch());
    }
}
