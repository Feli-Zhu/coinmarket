package com.phyane.httpreq.huobimarket.param;

import java.util.List;

public class HuobiMarket<T> {
	private String status;//请求处理结果
	private String ch;//数据�?属的 channel，格式： market.$symbol.detail.merged
	private long ts;//响应生成时间点，单位：毫�?
	private List<T> data;//K线数�?
	private String tick;//K线数�?
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCh() {
		return ch;
	}
	public void setCh(String ch) {
		this.ch = ch;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public String getTick() {
		return tick;
	}
	public void setTick(String tick) {
		this.tick = tick;
	}
}
