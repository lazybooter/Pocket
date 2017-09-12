package cn.tarpas.pocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRsp {
	@JsonProperty(value="code")
	private String code;
	
	@JsonProperty(value="msg")
	private String msg;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
