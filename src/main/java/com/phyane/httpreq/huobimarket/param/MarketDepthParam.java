package com.phyane.httpreq.huobimarket.param;

import java.util.ArrayList;
import java.util.List;

public class MarketDepthParam {
    private int id;//消息id
    private long ts;//消息生成时间，单位：毫秒
    private List<List<Double>> bids;//买盘,[price(成交�?), amount(成交�?)], 按price降序,
    private List<TransactionDataParam> bidDatas;
    private List<List<Double>> asks;//卖盘,[price(成交�?), amount(成交�?)], 按price升序
    private List<TransactionDataParam> askData;

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public List<List<Double>> getBids() {
		return bids;
	}
	public void setBids(List<List<Double>> bids) {
		this.bids = bids;
		this.bidDatas = new ArrayList<TransactionDataParam>();
		for(List<Double> bid : bids) {
			TransactionDataParam tdp = new TransactionDataParam();
			for(int i = 0;i < bid.size();i++) {
				if(i%2 == 0) {
					tdp.setPrice(bid.get(i).floatValue());
				}else {
					tdp.setAmount(bid.get(i).floatValue());
				}
			}
			bidDatas.add(tdp);
		}
	}
	public List<List<Double>> getAsks() {
		return asks;
	}
	public void setAsks(List<List<Double>> asks) {
		this.asks = asks;
		this.askData = new ArrayList<TransactionDataParam>();
		for(List<Double> ask : asks) {
			TransactionDataParam tdp = new TransactionDataParam();
			for(int i = 0;i < ask.size();i++) {
				if(i%2 == 0) {
					tdp.setPrice(ask.get(i).floatValue());
				}else {
					tdp.setAmount(ask.get(i).floatValue());
				}
			}
			askData.add(tdp);
		}
	}
}
