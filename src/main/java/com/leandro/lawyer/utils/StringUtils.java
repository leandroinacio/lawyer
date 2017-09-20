package com.leandro.lawyer.utils;

public class StringUtils {
	
	public static Boolean isEmpty(String value) {
		if (value == null || value.trim() == "") {
			return true;
		}
		return false;
	}
}
