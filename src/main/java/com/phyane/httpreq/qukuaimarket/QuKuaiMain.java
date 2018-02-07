package com.phyane.httpreq.qukuaimarket;

import com.phyane.comm.JsonUtil;
import com.phyane.httpreq.qukuaimarket.param.MarketParam;

public class QuKuaiMain {

	public static void main(String[] args) throws Exception{
		MarketParam mark = QukuaiUtilHttpClient.getDifficulty();
		System.out.println(JsonUtil.obj2Json(mark));
	}

}
