package com.phyane.httpreq.huobimarket.param;

public class MarketSupportParam {
	private String base_currency;//基础币种	
	private String quote_currency;//计价币种	
	private String price_precision;//价格精度位数�?0为个位）	
	private String amount_precision;//数量精度位数�?0为个位）	
	private String symbol_partition;//区块
	
	public String getBase_currency() {
		return base_currency;
	}
	public void setBase_currency(String base_currency) {
		this.base_currency = base_currency;
	}
	public String getQuote_currency() {
		return quote_currency;
	}
	public void setQuote_currency(String quote_currency) {
		this.quote_currency = quote_currency;
	}
	public String getPrice_precision() {
		return price_precision;
	}
	public void setPrice_precision(String price_precision) {
		this.price_precision = price_precision;
	}
	public String getAmount_precision() {
		return amount_precision;
	}
	public void setAmount_precision(String amount_precision) {
		this.amount_precision = amount_precision;
	}
	public String getSymbol_partition() {
		return symbol_partition;
	}
	public void setSymbol_partition(String symbol_partition) {
		this.symbol_partition = symbol_partition;
	}
}
