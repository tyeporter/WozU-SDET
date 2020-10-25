package com.tyeporter.removestringspacesproblem.util;

public class NiceString {

	public static String removeSpaces(String str) {
		return String.join("", str.trim().split("\\s+"));
	}

}