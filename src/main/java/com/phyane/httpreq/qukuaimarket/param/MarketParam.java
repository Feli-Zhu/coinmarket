package com.phyane.httpreq.qukuaimarket.param;

public class MarketParam {
	private long time;
	private double difficulty;
	private long hashps;
	private int block_height;
	private long total;
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}
	public long getHashps() {
		return hashps;
	}
	public void setHashps(long hashps) {
		this.hashps = hashps;
	}
	public int getBlock_height() {
		return block_height;
	}
	public void setBlock_height(int block_height) {
		this.block_height = block_height;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
