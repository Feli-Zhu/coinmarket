package com.phyane.httpreq.coingeckomarket;

import java.util.List;

import com.phyane.comm.JsonUtil;
import com.phyane.param.CoinMarketParam;
import com.phyane.spider.HtmlParaser;
import com.phyane.spider.UrlParaser;

public class CoinGeCkoMarketUtil {
	
	public static void main(String[] args) throws Exception {
		String url = "https://www.coingecko.com/en/crypto_index/crix";
		UrlParaser wcr = new UrlParaser();
		HtmlParaser hp = new HtmlParaser();
		String html = wcr.paraseUrl2Html(url);
		List<CoinMarketParam> list = hp.paraseCoinGeCkoMarketHtml(html);
		String json = JsonUtil.obj2Json(list);
		System.out.println(json);
	}
}
