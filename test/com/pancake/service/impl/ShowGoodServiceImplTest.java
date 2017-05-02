package com.pancake.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pancake.entity.Good;
import com.pancake.entity.GoodForm;

public class ShowGoodServiceImplTest {

	@Test
	public void testShowGoodService() {
		ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
//		//List<GoodForm> goodForms = sgsi.showGoodService();
//		for (GoodForm aGoodForm : goodForms) {
//			System.out.println(aGoodForm);
//		}
//		// fail("Not yet implemented");
	}
	
	@Test
	public void testShowGoodWithPage() {
		ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
		PageServiceImpl psi = new PageServiceImpl();
		ArrayList<GoodForm> goodForms = (ArrayList<GoodForm>) sgsi
				.showGoodWithPage((ArrayList<Good>) psi.queryForGoodPage(1, 3).getList());
		for (GoodForm goodForm : goodForms) {
			System.out.println(goodForm.getGoodId() + ", " + goodForm.getGoodName());
		}
	}
	

}
