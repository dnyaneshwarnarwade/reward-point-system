package com.amljdhv.util;

import java.util.List;

public class AppUtil {

	public static String concatenate(List<String> to, String string) {

		StringBuilder emails = new StringBuilder();
				
		for(String tos : to){
			emails.append(tos).append(string);
		}
		return emails.toString();
	}

	public static boolean isObjectEmpty(String cTemplate) {
		return cTemplate == null || cTemplate.isEmpty();
	}

}
