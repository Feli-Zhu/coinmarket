package com.phyane.httpreq.qukuaimarket;

import java.util.List;

import com.phyane.comm.JsonUtil;
import com.phyane.httpreq.qukuaimarket.param.AddressParam;

public class QuKuaiMain {

	public static void main(String[] args) throws Exception{
		List<AddressParam> list = QukuaiUtilHttpClient.getTop100AddressList();
		System.out.println(JsonUtil.obj2Json(list));
	}

}
