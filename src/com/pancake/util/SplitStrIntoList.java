package com.pancake.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitStrIntoList {
	public static List<String> run(String str) {
		List<String> list = new ArrayList<String>();
		String[] strArr = str.split(", ");
		Collections.addAll(list, strArr);
		return list;
	}
}
