package com.phyane.httpreq.huobimarket.param;

import java.util.List;

public class TradeDetail {
	private int id;// 消息id,
    private long ts;// �?新成交时�?,
    private List<TradeDetailParam> data;//详情数据
    
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
	public List<TradeDetailParam> getData() {
		return data;
	}
	public void setData(List<TradeDetailParam> data) {
		this.data = data;
	}
}
