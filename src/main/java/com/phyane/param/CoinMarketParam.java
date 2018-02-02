package com.phyane.param;

public class CoinMarketParam {
	private int id;//索引
	private String coinName = null;//名称
	private double marketCap;//市场总量价格
	private float price;//当前价格
	private Long existCount;//币量
	private double volume;//24时内比值
	private float change_1_h;//一小时内变化
	private float change_24_h;//24小时内变化
	private float change_7_d;//7天内变化
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public double getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Long getExistCount() {
		return existCount;
	}
	public void setExistCount(Long existCount) {
		this.existCount = existCount;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public float getChange_1_h() {
		return change_1_h;
	}
	public void setChange_1_h(float change_1_h) {
		this.change_1_h = change_1_h;
	}
	public float getChange_24_h() {
		return change_24_h;
	}
	public void setChange_24_h(float change_24_h) {
		this.change_24_h = change_24_h;
	}
	public float getChange_7_d() {
		return change_7_d;
	}
	public void setChange_7_d(float change_7_d) {
		this.change_7_d = change_7_d;
	}
}
