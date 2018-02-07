package com.phyane.httpreq.qukuaimarket;

import java.util.List;

import com.phyane.comm.HttpsClientRequest;
import com.phyane.comm.JsonUtil;
import com.phyane.httpreq.qukuaimarket.param.AddressListParam;
import com.phyane.httpreq.qukuaimarket.param.AddressParam;
import com.phyane.httpreq.qukuaimarket.param.BlockInfoParam;
import com.phyane.httpreq.qukuaimarket.param.MarketParam;
import com.phyane.spider.Constant;

public class QukuaiUtilHttpClient {
	
	/*top100地址*/
	public static List<AddressParam> getTop100AddressList() throws Exception{
		String url = "http://open.qukuai.com/topaddress?key=" + Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		System.out.println(result);
		AddressListParam ret = JsonUtil.json2Obj(result, AddressListParam.class);
		return ret.getList();
	}
	/*通过区块hash获取区块内容 */
	public static BlockInfoParam getBlockInfoByHash(String hash)throws Exception{
		BlockInfoParam block = null;
		String url = "http://open.qukuai.com/block/"+hash+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			block = JsonUtil.json2Obj(result, BlockInfoParam.class);
		}
		return block;
	}
	
	/*通过区块高度获取区块内容 */
	public static BlockInfoParam getBlockInfoByBlockHeight(String height)throws Exception {
		BlockInfoParam block = null;
		String url = "http://open.qukuai.com/block/height/"+height+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			block = JsonUtil.json2Obj(result, BlockInfoParam.class);
		}
		return block;
	}
	
	/*获取最新区块的内容 */
	public static BlockInfoParam getLatestBlockInfo()throws Exception {
		BlockInfoParam block = null;
		String url = "http://open.qukuai.com/blocklast?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			block = JsonUtil.json2Obj(result, BlockInfoParam.class);
		}
		return block;
	}
	/*获取难度 */
	public static MarketParam getDifficulty()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/difficulty?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*获取算力 */
	public static MarketParam getCalculateAbility()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/hashps?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*获取当前高度 */
	public static MarketParam getCurrentHeigh()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/height?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*获取比特币总量 */
	public static MarketParam getTotalBitCoin()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/total?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*获取地址的账户信息 */
	public static void getAccountInfoByAddr(String address)throws Exception {
		String url = "http://open.qukuai.com/address/"+address+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
	/*获取地址的交易信息，最多50条 */
	public static void getTradeInfoByAddr(String address)throws Exception {
		String url = "http://open.qukuai.com/address/transactions/"+address+"?key="+Constant.QUKUAI_API_KEY+"&limit=50";
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
	/*获取地址的未花费输出信息 */
	public static void getUntradedInfoByAddr(String address)throws Exception {
		String url = "http://open.qukuai.com/address/unspents/"+address+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
	/*通过交易ID获取一个交易内容*/
	public static void getTradedInfoById(String tradeId)throws Exception {
		String url = "http://open.qukuai.com/transaction/"+tradeId+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
}
