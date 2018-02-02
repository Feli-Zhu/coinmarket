package com.phyane.spider;

import java.net.URL;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider extends Thread{
	
	public String url = null;
	
	
	@Override
	public void run() {
		getAHref(url);
	}

	public void getAHref(String url){
		URL newUrl = null;
		Document doc = null;
		String host = null;
		try {
			newUrl = new URL(url);
			host = newUrl.getProtocol()+"://"+newUrl.getHost();
			Connection conn = Jsoup.connect(url);
			doc = conn.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Elements elements = doc.select("a[href]");
		Iterator<Element> iterator = elements.iterator();
		while(iterator.hasNext()) {
			Element ele = iterator.next();
			String href = ele.attr("href");
			if(href.contains("historical")) {
				href = host + href;
				Constant.urlList.offer(href);
			}else {
				continue;
			}
			
			System.out.println(href);
		}
	}

}
