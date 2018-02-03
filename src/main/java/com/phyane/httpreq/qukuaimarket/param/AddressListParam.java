package com.phyane.httpreq.qukuaimarket.param;

import java.util.List;

public class AddressListParam {
	private long address_total;
	private List<AddressParam> list;
	
	public long getAddress_total() {
		return address_total;
	}
	public void setAddress_total(long address_total) {
		this.address_total = address_total;
	}
	public List<AddressParam> getList() {
		return list;
	}
	public void setList(List<AddressParam> list) {
		this.list = list;
	}
}
