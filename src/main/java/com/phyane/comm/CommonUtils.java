package com.phyane.comm;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CommonUtils {
	
	public static String moneyDataDeal(String money) {
		if(money.contains(",")) {
			money = money.replace(",", "");
		}
		if(money.startsWith("$")) {
			money = money.substring(1);
		}
		if(!isNumber(money)) {
			return "0";
		}
		return money;
	}
	
	public static Long str2Long(String str) {
		str = moneyDataDeal(str);
		Double db = Math.ceil(new Double(str));
		return db.longValue();
	}
	
	public static boolean isNumber(String str) {
		Pattern p = Pattern.compile("[0-9]+[.]{0,1}[0-9]+");
		Matcher mt = p.matcher(str);
		return mt.matches();
	}
	
}
