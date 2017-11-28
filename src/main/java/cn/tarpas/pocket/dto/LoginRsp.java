package cn.tarpas.pocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRsp {
	
	@JsonProperty(value="token")
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
