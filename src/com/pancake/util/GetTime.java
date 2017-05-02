package com.pancake.util;

import java.text.SimpleDateFormat;

public class GetTime {
	public static String getTimeForPic() {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
		String date = sDateFormat.format(new java.util.Date());
		System.out.println(date);
		return date.toString();
	}
}
