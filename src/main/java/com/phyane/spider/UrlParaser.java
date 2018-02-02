package com.phyane.spider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlParaser {
	
	public String paraseUrl2Html(String url) {
		HttpURLConnection conn = null;
		String result = null;
        try {
        	URL realUrl = new URL(url);
        	conn = (HttpURLConnection) realUrl.openConnection();
        	conn.setRequestMethod("GET");
        	conn.setUseCaches(false);
        	conn.setReadTimeout(8000);
        	conn.setConnectTimeout(8000);
        	conn.setInstanceFollowRedirects(false);
        	conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
            int code = conn.getResponseCode();
            if (code == 200) {
                InputStream is = conn.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = in.readLine()) != null){
                    buffer.append(line);
                }
                result = buffer.toString();
                
            }
        }catch (Exception e){
           e.printStackTrace();
        }
        return result;
	}

}
