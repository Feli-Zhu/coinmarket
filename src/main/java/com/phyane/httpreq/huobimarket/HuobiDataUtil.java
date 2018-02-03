package com.phyane.httpreq.huobimarket;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.phyane.comm.HttpsClientRequest;
import com.phyane.comm.JsonUtil;
import com.phyane.httpreq.huobimarket.param.HuobiMarket;
import com.phyane.httpreq.huobimarket.param.KLineDataParam;
import com.phyane.httpreq.huobimarket.param.MarketDepthParam;
import com.phyane.httpreq.huobimarket.param.MarketSupportParam;
import com.phyane.httpreq.huobimarket.param.MergedMarketParam;
import com.phyane.httpreq.huobimarket.param.TradeDetail;


/**
 * 火币相关数据
 * @author Administrator
 *
 */
public class HuobiDataUtil {
	
	
	/** k线数�? */
	public static HuobiMarket<KLineDataParam> getKlineDate(String symbol,String period) throws Exception{
		//symbol 规则�? 基础币种+计价币种。如BTC/USDT，symbol为btcusdt；ETH/BTC�? symbol为ethbtc。以此类�?
		if(symbol == null) {
			symbol = "btcusdt";
		}
		if(period == null) {
			period = "30min";
		}
		String url = "https://api.huobi.pro/market/history/kline?symbol="+symbol+"&period="+period;
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<KLineDataParam> ret = JsonUtil.json2Obj(result, HuobiMarket.class);
		return ret;
	}
	
	/**获取聚合行情*/
	public static MergedMarketParam getMergedMarketData(String symbol) throws Exception{
		MergedMarketParam mmp = null;
		if(symbol == null) {
			symbol = "btcusdt";
		}
		String url = "https://api.huobi.pro/market/detail/merged?symbol="+symbol;
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<MergedMarketParam> ret = JsonUtil.json2Obj(result, HuobiMarket.class);
		if(ret != null) {
			String tick = ret.getTick();
			mmp = JsonUtil.json2Obj(tick, MergedMarketParam.class);
		}
		return mmp;
	}
	
	/**获取 Market Depth 数据*/
	public static MarketDepthParam getMarketDepth(String symbol,String type) throws Exception{
		if(symbol == null) {
			symbol = "btcusdt";
		}
		if(type == null) {
			type = "step0";
		}
		MarketDepthParam mdp = null;
		String url = "https://api.huobi.pro/market/depth?symbol="+symbol+"&type="+type;
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<MergedMarketParam> ret = JsonUtil.json2Obj(result, HuobiMarket.class);
		if(ret != null) {
			String tick = ret.getTick();
			mdp = JsonUtil.json2Obj(tick, MarketDepthParam.class);
		}
		return mdp;
	}
	
	/**获取 Trade Detail 数据*/
	public static TradeDetail getTradeDetail(String symbol) throws Exception{
		TradeDetail detail = null;
		if(symbol == null) {
			symbol = "btcusdt";
		}
		String url = "https://api.huobi.pro/market/trade?symbol="+symbol;
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<TradeDetail> ret = JsonUtil.json2Obj(result, HuobiMarket.class);
		detail = JsonUtil.json2Obj(ret.getTick(), TradeDetail.class);
		return detail;
	}
	
	/**批量获取�?近的交易记录 size:获取交易记录的数�?*/
	public static TradeDetail getTradeHistory(String symbol,int size) throws Exception{
		TradeDetail detail = null;
		if(symbol == null) {
			symbol = "btcusdt";
		}
		String url = "https://api.huobi.pro/market/history/trade?symbol="+symbol+"&size="+size;
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<TradeDetail> ret = JsonUtil.json2Obj(result, HuobiMarket.class);
		detail = JsonUtil.json2Obj(ret.getTick(), TradeDetail.class);
		return detail;
	}
	
	/**获取 Market Detail 24小时成交量数�?*/
	public static KLineDataParam getMarketDetail(String symbol) throws Exception{
		KLineDataParam detail = null;
		if(symbol == null) {
			symbol = "btcusdt";
		}
		String url = "https://api.huobi.pro/market/detail?symbol="+symbol;
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<KLineDataParam> ret = JsonUtil.json2Obj(result, HuobiMarket.class);
		detail = JsonUtil.json2Obj(ret.getTick(), KLineDataParam.class);
		return detail;
	}
	
	/**查询系统支持的所有交易对及精�?*/
	public static List<MarketSupportParam> getMarketSupport() throws Exception{
		String url = "https://api.huobi.pro/v1/common/symbols";
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<MarketSupportParam> ret = JsonUtil.json2Obj(result.replaceAll("-", "_"), HuobiMarket.class);
		return ret.getData();
	}
	/**查询系统支持的所有交易对及精�?*/
	public static List<String> getSupportCurrency() throws Exception{
		String url = "https://api.huobi.pro/v1/common/currencys";
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		HuobiMarket<String> ret = JsonUtil.json2Obj(result.replaceAll("-", "_"), HuobiMarket.class);
		return ret.getData();
	}
	/**查询系统当前时间*/
	public static Date getCurrentTimestamp() throws Exception{
		String url = "https://api.huobi.pro/v1/common/timestamp";
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		String result = HttpsClientRequest.SendHttpsGET(url, null,headers);
		Map<String, Object> ret = JsonUtil.json2Obj(result,Map.class);
		Date dt = new Date();
		dt.setTime(new Long(ret.get("data").toString()));
		return dt;
	}

}
