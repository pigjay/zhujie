package com.pigganme.framework.result;

public class Result {

	private int code;
	
	private String message;
	
	private Object datas;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(int code, String message, Object datas) {
		this.code = code;
		this.message = message;
		this.datas = datas;
	}

	public Result() {
	}
}
