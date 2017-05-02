package com.pancake.util;

import java.util.List;

public class PicFormatProcess {
	public static String ListToStr(List<String> list) {
		String picNameInDB="";
		for (String picName : list) {
			picNameInDB += picName + ", ";
		}
		
		return picNameInDB.substring(0, picNameInDB.length()-2);
	}
}
