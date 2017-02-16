package com.sportstory.util;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

	public static boolean isEmpty(String str) {
		if (StringUtils.isEmpty(str))
			return true;
		if ("".equals(str.trim()))
			return true;
		return false;
	}

	public static boolean isEmpty(Character c) {
		if (null == c)
			return true;
		if ("".equals(c))
			return true;
		return false;
	}

	public static boolean isInt(String str) {
		return str.matches("^[0-9]*$");
	}

	// 嗖付支付传过来的金额是"分"
	public static boolean isFen(String str) {
		return str.matches("^[0-9]+$");
	}
	
	public static String join(String split, String... values) {
		StringBuilder builder = new StringBuilder();
		for(String s : values) {
			builder.append(s).append(split);
		}
		if(!isEmpty(split)) {
			builder.deleteCharAt(builder.length() - 1);
		}
		return builder.toString();
	}
	
	public static String fillZero(int num, int width) {
		if (num < 0)
			return "";
		StringBuffer sb = new StringBuffer();
		String s = "" + num;
		if (s.length() < width) {
			int addNum = width - s.length();
			for (int i = 0; i < addNum; i++) {
				sb.append("0");
			}
			sb.append(s);
		} else {
			return s.substring(s.length() - width, s.length());
		}
		return sb.toString();
	}
	
	public static String fillZero(String preix, int num, int width) {
		if (num < 0)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(preix);
		String s = "" + num;
		if (s.length() < width) {
			int addNum = width - s.length();
			for (int i = 0; i < addNum; i++) {
				sb.append("0");
			}
			sb.append(s);
		} else {
			return s.substring(s.length() - width, s.length());
		}
		return sb.toString();
	}
	
	/**
	 * 截取字符串，中文占2个字符，英文1个字符。
	 * @param content	被截取的内容
	 * @param maxSize	需要的长度
	 * @param ed			结尾的字符串
	 * @return
	 */
	public static String judgeChina(String content, Integer maxSize, String ed) {
		if (StringUtils.isBlank(content) || maxSize == null) {
			return "";
		}
		Integer length = 0;
		Boolean edStr = true;
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < content.length(); i++) {
			String retContent = content.substring(i, i + 1);
			boolean isChina = retContent.matches("[\u4E00-\u9FA5]");
			boolean isCapital = retContent.matches("[A-Z]");
			if (isChina) {
				length += 2;
			} else if (isCapital) {
				length += 1;
			} else {
				length += 1;
			}
			if (length > maxSize) {
				break;
			}
			sBuffer.append(retContent);
			if (i == content.length() - 1) {
				edStr = false;
			}
		}
		if (edStr) {
			sBuffer.append(StringUtils.isBlank(ed) ? "" : ed);
		}
		return sBuffer.toString();
	}
	
	public static String trim(String str) {
        return str == null ? null : str.trim();
    }
}