package com.phyane.comm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	public static <T> T json2Obj(String json,Class<T> cls) {
		if(json == null || json.isEmpty()) {
			return null;
		}
		T obj = JSON.parseObject(json, cls);
		return obj;
	}
	
	public static <T> List<T> json2List(String json,Class<T> cls){
		if(json == null || json.isEmpty()) {
			return null;
		}
		List<T> list = JSON.parseArray(json, cls);
		return list;
	}
	
	public static String obj2Json(Object obj) {
		String ret = null;
		if(obj instanceof Collection) {
			JSONArray array = new JSONArray();
			array.addAll((Collection)obj);
			ret = array.toJSONString();
		}else {
			Object json = JSONObject.toJSON(obj);
			ret = json.toString();
		}
		return ret;
	}
	
}
