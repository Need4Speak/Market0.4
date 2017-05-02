package com.pancake.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginPic {
	public static String getLoginPic() {
		return getTimeString();
	}
	
	/**
	   * 获取时间戳
	   */
	public static String getTimeString() {
	    SimpleDateFormat df = new SimpleDateFormat("HH");
	    Calendar calendar = Calendar.getInstance();
	    return df.format(calendar.getTime());
	}

}
