package com.pancake.dao.impl;

import java.util.ArrayList;

import org.junit.Test;

import com.pancake.entity.Classification;

import antlr.collections.List;

public class ClassificationDaoImplTest {
	private ClassificationDaoImpl cdi = new ClassificationDaoImpl();
	@Test
	public void testFindById() {
		
		Classification cf = cdi.findById(1);
		System.out.println(cf.getClassificationName());
	}
	@Test
	public void testFindAll() {
		
		ArrayList<Classification> cf = (ArrayList<Classification>) cdi.findAll();
		for (Classification classification : cf) {
			System.out.println(classification.getClassificationName());
		}
		
	}
}
