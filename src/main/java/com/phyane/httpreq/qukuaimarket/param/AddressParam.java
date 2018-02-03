package com.phyane.httpreq.qukuaimarket.param;

import java.util.Date;

public class AddressParam {
	
	private long balance;
	private Date time;
	private String address;
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
