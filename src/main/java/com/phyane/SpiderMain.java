package com.phyane;

import java.util.List;

import com.phyane.param.CoinMarketParam;
import com.phyane.spider.CommonUtils;
import com.phyane.spider.HtmlParaser;
import com.phyane.spider.UrlParaser;

public class SpiderMain {

	public static void main(String[] args) throws Exception {
		String url = "https://coinmarketcap.com/historical/20180128/";
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
		List<CoinMarketParam> list = hp.paraseHtml(html);
		String json = CommonUtils.obj2Json(list);
		System.out.println(json);
	}

}
