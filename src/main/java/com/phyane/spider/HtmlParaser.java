package com.phyane.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.phyane.comm.CommonUtils;
import com.phyane.param.CoinMarketParam;
import com.phyane.spider.Constant;


public class HtmlParaser extends Thread {

	@Override
	public void run() {
		while(Constant.paraseStatus) {
			if(Constant.urlList != null && !Constant.urlList.isEmpty()) {
				String url = Constant.urlList.poll();
			}
		}
	}
	
	public void setUrl(String url) throws Exception{
		Connection conn = Jsoup.connect(url).timeout(5000);
		Document doc = conn.get();
		File file = new File("D://spider.html");
		String content = doc.html();
		OutputStream os = new FileOutputStream(file);
		os.write(content.getBytes());
		os.close();
	}
	public List<CoinMarketParam> paraseCoinMarketCapHtml(String html) throws Exception{
		List<CoinMarketParam> marketList = new ArrayList<CoinMarketParam>();
		try {
			Document doc = Jsoup.parse(html);
			Elements elemts = doc.getElementsByTag("table");
			if(elemts.size() == 1) {
				Element table = elemts.get(0);
				Elements trs = table.getElementsByTag("tr");
				System.out.println("-----------------size:"+trs.size());
				Iterator<Element> iterator = trs.iterator();
				while(iterator.hasNext()) {
					Element tr = iterator.next();
					Elements tds = tr.getElementsByTag("td");
					if(tds.size() == 10) {
						CoinMarketParam market = new CoinMarketParam();
						String ids = tds.get(0).html();
						market.setId(new Integer(CommonUtils.moneyDataDeal(ids)));
						market.setCoinName(tds.get(2).html());
						String cap = tds.get(3).html();
						market.setMarketCap(new Double(CommonUtils.moneyDataDeal(cap)));
						Elements priceEle = tds.get(4).select(".price");
						Element priceElement = priceEle.first();
						String priceStr = priceElement.html();
						market.setPrice(new Float(CommonUtils.moneyDataDeal(priceStr)));
//						System.out.println(ids);						
						if(ids.equals("615")) {
							System.out.println("get");
						}
						Elements containers = tds.get(5).select("a[data-supply-container]");
						if(containers == null || containers.isEmpty()) {
							containers = tds.get(5).select("span");
						}
						Element container = containers.first();
						String existStr = container.html();
						
						market.setExistCount(CommonUtils.str2Long(existStr));
						Elements volumes = tds.get(6).select("a");
						String volumeStr = volumes.first().html();
						market.setVolume(new Double(CommonUtils.moneyDataDeal(volumeStr)));
						String change_1_h = tds.get(7).html();
						if(!change_1_h.equals("?")) {
							if(change_1_h.endsWith("%")) {
								change_1_h = change_1_h.substring(0,change_1_h.length() -1);
							}
							float change1_h= new Float(change_1_h);
							change1_h /= 100.0;
							market.setChange_1_h(change1_h);
						}
						String change_24_h = tds.get(8).html();
						if(!change_24_h.equals("?")) {
							if(change_24_h.endsWith("%")) {
								change_24_h = change_24_h.substring(0,change_24_h.length() -1);
							}
							float change24_h= new Float(change_24_h);
							change24_h /= 100.0;
							market.setChange_24_h(change24_h);
						}
						String change_7_d = tds.get(9).html();
						if(!change_7_d.equals("?")) {
							if(change_7_d.endsWith("%")) {
								change_7_d = change_7_d.substring(0,change_7_d.length() -1);
							}
							float change7d= new Float(change_7_d);
							change7d /= 100.0;
							market.setChange_7_d(change7d);
						}
						marketList.add(market);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marketList;
	}
	
	public static List<CoinMarketParam> paraseCoinGeCkoMarketHtml(String html) {
		List<CoinMarketParam> list = new ArrayList<CoinMarketParam>();
		Document doc = Jsoup.parse(html);
		Elements elemts = doc.getElementsByTag("table");
		Element table = elemts.first();
		Elements tr = table.select("tr");
		Iterator<Element> iterators = tr.iterator();
		while(iterators.hasNext()) {
			Element ele = iterators.next();
			Elements tds = ele.select("td");
			if(tds.size() == 4) {
				CoinMarketParam param = new CoinMarketParam();
				String name = tds.get(0).html();
				String priceStr = tds.get(1).html();
				String marketCapStr = tds.get(2).html();
				String volumeStr = tds.get(3).html();
				param.setCoinName(name);
				float price = new Float(CommonUtils.moneyDataDeal(priceStr));
				param.setPrice(price);
				double marketCap = new Double(CommonUtils.moneyDataDeal(marketCapStr));
				param.setMarketCap(marketCap);
				double volume = new Double(CommonUtils.moneyDataDeal(volumeStr));
				param.setVolume(volume);
				list.add(param);
			}
		}
		return list;
	}

	public void paraseBitstampMarketHtml(String html) throws Exception{
		Document doc = Jsoup.parse(html);
		Elements divs = doc.select("div[data-slick-index]");
		System.out.println(divs.size());
	}
	
}
