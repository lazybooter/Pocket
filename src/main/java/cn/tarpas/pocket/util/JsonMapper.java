package cn.tarpas.pocket.util;

import net.sf.json.JSONObject;

public class JsonMapper {
	
	 public <T> T fromJson(String requestBody, Class<?> obj){
		 
			JSONObject Json = JSONObject.fromObject(requestBody);
			T RequestDTO = (T)Json.toBean(Json, obj);
			
		
		return RequestDTO;
	 }
}
