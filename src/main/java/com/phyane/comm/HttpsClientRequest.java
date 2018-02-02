package com.phyane.comm;

import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class HttpsClientRequest {
	static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

	static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String arg0, SSLSession arg1) {
			return true;
		}

	}

	private static HttpClient client;
	private static MultipartEntity reqEntity = null;

	static public String SendHttpsPOST(String url, Map<String, Object> contents, Map<String, Object> headers,
			String token, String[] filePaths) throws Exception {
		String result = null;
		client = new DefaultHttpClient();
		HttpPost request;
		try {
			System.out.println("URL:" + url);
			String json = JsonUtil.obj2Json(contents).toString();
			MultipartEntity reqEntity = new MultipartEntity();
			request = new HttpPost(new URI(url));
			if (token != null) {
				request.setHeader("token", token);
			}
			if (headers != null) {
				Set<String> keys = headers.keySet();
				for (String key : keys) {
					request.addHeader(key, headers.get(key).toString());
				}
			}
			if (json != null && filePaths == null) {
				StringEntity s = new StringEntity(json.toString(), "utf-8");
				s.setContentType("application/json");
				request.setEntity(s);
			} else if (filePaths != null && json == null) {
				FileBody bin = null;
				for (String path : filePaths) {
					File file = new File(path);
					if (file.exists()) {
						bin = new FileBody(file);
						reqEntity.addPart("file", bin);
					}
				}
				request.setEntity(reqEntity);
			} else if (json != null && filePaths != null) {
				FileBody bin = null;
				for (String path : filePaths) {
					File file = new File(path);
					if (file.exists()) {
						bin = new FileBody(file);
						reqEntity.addPart("file", bin);
					}
				}
				StringBody sbody = new StringBody(json.toString(), "application/json", Charset.forName("utf-8"));
				reqEntity.addPart("parameter", sbody);
				request.setEntity(reqEntity);
			}

			// 设置SSLContext
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);

			// 打开连接
			// 要发送的POST请求url?Key=Value&amp;Key2=Value2&amp;Key3=Value3的形式
			SSLSocketFactory socketFactory = new SSLSocketFactory(sslcontext);

			client.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, 443));
			HttpResponse response = client.execute(request);
			int returncode = response.getStatusLine().getStatusCode();
			System.out.println("Response Code:" + returncode);

			if (returncode == 200) {
				Header[] header = response.getHeaders("token");
				if (header.length > 0) {
					for (Header h : header) {
						System.out.println(h.getName() + " " + h.getValue());
					}
				}
				HttpEntity entity = response.getEntity();
				long contentLen = entity.getContentLength();
				if (contentLen == 0) {
					return "User Has No Authority";
				}
				String charset = EntityUtils.getContentCharSet(entity);
				InputStreamReader isr = null;
				if (charset != null) {
					isr = new InputStreamReader(entity.getContent(), charset);
				} else {
					isr = new InputStreamReader(entity.getContent());
				}
				StringBuffer sb = new StringBuffer();
				char[] ct = new char[64];
				int len = 0;
				while ((len = isr.read(ct)) != -1) {
					String sst = new String(ct);
					sst = sst.substring(0, len).trim();
					sb.append(sst);
				}
				result = sb.toString().replace("\\\\", "\\");
				result = result.replace("\\\"", "\"");
				if (result.length() > 2) {
					result = result.substring(1, result.length() - 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	static public String SendHttpsGET(String url, String token, Map<String, Object> headers) throws Exception {
		String result = null;
		client = new DefaultHttpClient();
		HttpGet request;
		try {
			System.out.println("URL:" + url);
			reqEntity = new MultipartEntity();
			request = new HttpGet(new URI(url));
			if (token != null) {
				request.setHeader("token", token);
				request.setHeader("os", "IOS");
			}
			if (headers != null) {
				Set<String> keys = headers.keySet();
				for (String key : keys) {
					request.addHeader(key, headers.get(key).toString());
				}
			}

			// 设置SSLContext
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);

			// 打开连接
			// 要发送的POST请求url?Key=Value&amp;Key2=Value2&amp;Key3=Value3的形式
			SSLSocketFactory socketFactory = new SSLSocketFactory(sslcontext);

			client.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, 443));
			HttpResponse response = client.execute(request);
			int returncode = response.getStatusLine().getStatusCode();
			System.out.println("Response Code:" + returncode);

			if (returncode == 200) {
				Header[] header = response.getHeaders("token");
				if (header.length > 0) {
					for (Header h : header) {
						System.out.println(h.getName() + " " + h.getValue());
					}
				}
				HttpEntity entity = response.getEntity();
				long contentLen = entity.getContentLength();
				if (contentLen == 0) {
					return "User Has No Authority";
				}
				String charset = EntityUtils.getContentCharSet(entity);
				InputStreamReader isr = null;
				if (charset != null) {
					isr = new InputStreamReader(entity.getContent(), charset);
				} else {
					isr = new InputStreamReader(entity.getContent());
				}
				StringBuffer sb = new StringBuffer();
				char[] ct = new char[64];
				int len = 0;
				while ((len = isr.read(ct)) != -1) {
					String sst = new String(ct);
					sst = sst.substring(0, len).trim();
					sb.append(sst);
				}
				result = sb.toString().replace("\\\\", "\\");
				result = result.replace("\\\"", "\"");
				if (!result.startsWith("{")) {
					result = result.substring(result.indexOf("{"));
				}
				if (!result.endsWith("}")) {
					result = result.substring(0, result.lastIndexOf("}"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}