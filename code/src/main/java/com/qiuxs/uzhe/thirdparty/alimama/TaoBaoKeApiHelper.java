package com.qiuxs.uzhe.thirdparty.alimama;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.qiuxs.uzhe.tb.entity.TbkCoupon;
import com.qiuxs.uzhe.tb.entity.TbkItemInfo;
import com.taobao.api.ApiException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoObject;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;

/**
 * 淘宝Api调用帮助类
 * @author qiuxs
 *
 */
public class TaoBaoKeApiHelper {

	/**
	 * 根据ID获取淘宝客商品详情
	 * @param platform
	 * 		平台
	 * @param id
	 * 		
	 * @return
	 */
	public List<TbkItemInfo> findTbkGoodInfo(long platform, String ids) {
		TbkItemInfoGetRequest request = new TbkItemInfoGetRequest();
		request.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,nick,seller_id,volume,cat_leaf_name,cat_name");
		request.setPlatform(platform);
		request.setNumIids(ids);
		TbkItemInfoGetResponse resp = (TbkItemInfoGetResponse) this.execute(request);
		List<NTbkItem> results = resp.getResults();
		List<TbkItemInfo> beans = transfBeans(results, TbkItemInfo.class);
		for (TbkItemInfo info : beans) {
			info.setPlatform((int) platform);
		}
		return beans;
	}

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
	public List<TbkCoupon> findCoupon(long adzoneId, long platform, String cat, String q, long pageNo, long pageSize) {
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
		TbkDgItemCouponGetResponse resp = (TbkDgItemCouponGetResponse) execute(req);
		return transfBeans(resp.getResults(), TbkCoupon.class);
	}

	private <T> List<T> transfBeans(List<? extends TaobaoObject> src, Class<T> clz) {
		List<T> newBeans = new ArrayList<T>();
		for (TaobaoObject bean : src) {
			T t = null;
			try {
				Constructor<T> constructor = clz.getConstructor(bean.getClass());
				t = constructor.newInstance(bean);
			} catch (ReflectiveOperationException e) {
				throw new RuntimeException(e.getLocalizedMessage(), e);
			}
			newBeans.add(t);
		}
		return newBeans;
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
