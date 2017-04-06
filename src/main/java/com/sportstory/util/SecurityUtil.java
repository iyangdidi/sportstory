package com.sportstory.util;

import java.util.Map;

import com.sportstory.cons.Constants;

public class SecurityUtil {  
	
	public static String getToken(String phone, String psd, long time){
		return MD5Util.md5(phone+psd+Constants.tokenKey+time);
	}
//	public boolean authenToken(String token, String phone, String psd, long time){
//		
//	}
}  
