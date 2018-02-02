package com.phyane.httpreq.huobimarket.param;

import java.util.List;

public class MergedMarketParam {
	private int id;//K线id
	private double amount;//成交�?
	private int count;//成交笔数
	private float open;//�?盘价
	private float close;//收盘�?,当K线为�?晚的�?根时，是�?新成交价
	private float high;//�?高价
	private float low;//�?低价
	private double vol;//成交�?, �? sum(每一笔成交价 * 该笔的成交量)
	private List<Float> bid;//[�?1�?,�?1量]
	private List<Float> ask;//[�?1�?,�?1量]
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public double getVol() {
		return vol;
	}
	public void setVol(double vol) {
		this.vol = vol;
	}
	public List<Float> getBid() {
		return bid;
	}
	public void setBid(List<Float> bid) {
		this.bid = bid;
	}
	public List<Float> getAsk() {
		return ask;
	}
	public void setAsk(List<Float> ask) {
		this.ask = ask;
	}
}
