package com.phyane.httpreq.qukuaimarket;

import java.util.List;

import com.phyane.comm.HttpsClientRequest;
import com.phyane.comm.JsonUtil;
import com.phyane.httpreq.qukuaimarket.param.AddressListParam;
import com.phyane.httpreq.qukuaimarket.param.AddressParam;
import com.phyane.spider.Constant;

public class QukuaiUtilHttpClient {
	
	public static List<AddressParam> getTop100AddressList() throws Exception{
		String url = "http://open.qukuai.com/total?key=" + Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		System.out.println(result);
		AddressListParam ret = JsonUtil.json2Obj(result, AddressListParam.class);
		return ret.getList();
	}

}
