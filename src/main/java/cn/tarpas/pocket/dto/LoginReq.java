package cn.tarpas.pocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.tarpas.pocket.annotation.ParameterNotNull;
import cn.tarpas.pocket.annotation.ParameterPhone;
import cn.tarpas.pocket.annotation.ParameterStringLength;

public class LoginReq{
	@JsonProperty(value = "telphone")
	@ParameterPhone
	@ParameterNotNull
	private String telphone;
	
	@JsonProperty(value = "password")
	@ParameterNotNull
	@ParameterStringLength(minLength=6,maxLength=18)
	private String password;

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "[telphone=" + telphone + ", password=" + password + "]";
	}
}
