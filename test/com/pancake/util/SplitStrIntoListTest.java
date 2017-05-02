package com.pancake.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SplitStrIntoListTest {

	@Test
	public void testRun() {
		String str = "1.jpg, 2.jpg, 3.jpg";
		List<String> list = SplitStrIntoList.run(str);
		for (String string : list) {
			System.out.println(string);
		}
	}

}
