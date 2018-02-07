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
	
	/*top100��ַ*/
	public static List<AddressParam> getTop100AddressList() throws Exception{
		String url = "http://open.qukuai.com/topaddress?key=" + Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		System.out.println(result);
		AddressListParam ret = JsonUtil.json2Obj(result, AddressListParam.class);
		return ret.getList();
	}
	/*ͨ������hash��ȡ�������� */
	public static BlockInfoParam getBlockInfoByHash(String hash)throws Exception{
		BlockInfoParam block = null;
		String url = "http://open.qukuai.com/block/"+hash+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			block = JsonUtil.json2Obj(result, BlockInfoParam.class);
		}
		return block;
	}
	
	/*ͨ������߶Ȼ�ȡ�������� */
	public static BlockInfoParam getBlockInfoByBlockHeight(String height)throws Exception {
		BlockInfoParam block = null;
		String url = "http://open.qukuai.com/block/height/"+height+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			block = JsonUtil.json2Obj(result, BlockInfoParam.class);
		}
		return block;
	}
	
	/*��ȡ������������� */
	public static BlockInfoParam getLatestBlockInfo()throws Exception {
		BlockInfoParam block = null;
		String url = "http://open.qukuai.com/blocklast?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			block = JsonUtil.json2Obj(result, BlockInfoParam.class);
		}
		return block;
	}
	/*��ȡ�Ѷ� */
	public static MarketParam getDifficulty()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/difficulty?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*��ȡ���� */
	public static MarketParam getCalculateAbility()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/hashps?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*��ȡ��ǰ�߶� */
	public static MarketParam getCurrentHeigh()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/height?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*��ȡ���ر����� */
	public static MarketParam getTotalBitCoin()throws Exception {
		MarketParam ret = null;
		String url = "http://open.qukuai.com/total?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
		if(result != null) {
			ret = JsonUtil.json2Obj(result, MarketParam.class);
		}
		return ret;
	}
	/*��ȡ��ַ���˻���Ϣ */
	public static void getAccountInfoByAddr(String address)throws Exception {
		String url = "http://open.qukuai.com/address/"+address+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
	/*��ȡ��ַ�Ľ�����Ϣ�����50�� */
	public static void getTradeInfoByAddr(String address)throws Exception {
		String url = "http://open.qukuai.com/address/transactions/"+address+"?key="+Constant.QUKUAI_API_KEY+"&limit=50";
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
	/*��ȡ��ַ��δ���������Ϣ */
	public static void getUntradedInfoByAddr(String address)throws Exception {
		String url = "http://open.qukuai.com/address/unspents/"+address+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
	/*ͨ������ID��ȡһ����������*/
	public static void getTradedInfoById(String tradeId)throws Exception {
		String url = "http://open.qukuai.com/transaction/"+tradeId+"?key="+Constant.QUKUAI_API_KEY;
		String result = HttpsClientRequest.SendHttpsGET(url, null, null);
	}
}
