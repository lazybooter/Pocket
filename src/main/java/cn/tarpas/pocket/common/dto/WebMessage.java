package cn.tarpas.pocket.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 返回统一的数据信息
 * */

public class WebMessage <T> extends BaseMessage{
	private T result;
	
	@JsonProperty(value = "response_time")
	private long responseTime = System.currentTimeMillis();

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}	
	
	public void setErrorCode(ErrorStatus status){
		this.setCode(status.getCode());
		this.setMsg(status.getMessage());
	}
}
