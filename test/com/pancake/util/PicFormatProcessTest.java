package com.pancake.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class PicFormatProcessTest {

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		String str1= "1.jpg";
		String str2 = "2.jpg";
		list.add(str1);
		list.add(str2);
		String string = PicFormatProcess.ListToStr(list);
		System.out.println(string+".");

	}
}
