package com.phyane.httpreq.huobimarket;

import com.phyane.comm.JsonUtil;
import com.phyane.httpreq.huobimarket.param.HuobiMarket;
import com.phyane.httpreq.huobimarket.param.KLineDataParam;

public class HuobiMarketMain {

	public static void main(String[] args) throws Exception {
		HuobiMarket<KLineDataParam> mk = HuobiDataUtil.getKlineDate(null, null);
		String ret = JsonUtil.obj2Json(mk);
		System.out.println(ret);
	}

}
