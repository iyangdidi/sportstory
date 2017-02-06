package com.sportstory.exception;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {

	OK("0", "成功"),
	SystemError("9999", "服务器错误"),
	PARAMTER_ERROR("9001", "参数错误"),
	NOTMETHOD("9002", "无对应method"),
	HTTPERROR("9003", "http请求错误");
	
	public String value;

	public String memo;

	private ErrorCode(String value, String memo) {
		this.value = value;
		this.memo = memo;
	}

	private static final Map<String, String> lookup = new HashMap<String, String>();
	private static final Map<String, ErrorCode> lookupErrorCode = new HashMap<String, ErrorCode>();

	static {
		for (ErrorCode code : values()) {
			lookup.put(code.value, code.memo);
			lookupErrorCode.put(code.value, code);
		}
	}

	public static String get(String value) {
		return lookup.get(value);
	}
	
	public static ErrorCode getErrorCode(String value) {
		return lookupErrorCode.get(value);
	}
	
	public static Map<String, String> getAllMap() {
		return lookup;
	}
}
