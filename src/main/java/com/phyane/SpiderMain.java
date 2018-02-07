package com.phyane;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.phyane.comm.CommonUtils;
import com.phyane.comm.JsonUtil;
import com.phyane.param.CoinMarketParam;
import com.phyane.spider.HtmlParaser;
import com.phyane.spider.UrlParaser;

public class SpiderMain {

	public static void main(String[] args) throws Exception {
//		String url = "https://coinmarketcap.com/historical/20180128/";
//		String url = "https://www.coingecko.com/en/crypto_index/crix";
		String url = "https://www.bitstamp.net/";
//		Spider spider = new Spider();
//		spider.url = "https://coinmarketcap.com/historical/";
//		spider.start();
//		HtmlParaser parase = new HtmlParaser();
//		List<CoinMarketParam> list = parase.paraseHtml(url);
//		JSONArray array = new JSONArray();
//		array.addAll(list);
//		String str = array.toJSONString();
//		System.out.println(str);
		UrlParaser wcr = new UrlParaser();
		HtmlParaser hp = new HtmlParaser();
		String html = wcr.paraseUrl2Html(url);
		System.out.println(html);
//		List<CoinMarketParam> list = hp.paraseCoinGeCkoMarketHtml(html);
//		CoinMarketParam coin = list.get(0);
		String[] exp = {"change_1_h"};
		JSONSerializer jss = new JSONSerializer();
//		String ret = JSON.toJSONString(coin, JsonUtil.getJsonConfig(CoinMarketParam.class,exp));
//		System.out.println(ret);
//		List<CoinMarketParam> list = hp.paraseCoinMarketCapHtml(html);
//		String json = JsonUtil.obj2Json(list);
//		System.out.println(json);
		hp.paraseBitstampMarketHtml(html);
	}

}
