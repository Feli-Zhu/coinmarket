package com.phyane.httpreq.huobimarket.param;

public class TradeDetailParam {
	private long id;// 成交id,
    private float price;// 成交价钱,
    private double amount;// 成交�?,
    private String direction;// 主动成交方向,
    private long ts;// 成交时间
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
}
