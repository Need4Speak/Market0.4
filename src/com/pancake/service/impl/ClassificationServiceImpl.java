package com.pancake.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.ClassificationDaoImpl;
import com.pancake.entity.Classification;
import com.pancake.service.ClassificationService;
@Service
public class ClassificationServiceImpl implements ClassificationService {
	
	private ClassificationDaoImpl cdi = new ClassificationDaoImpl();
	@Override
	public List<Classification> getAllClassifications() {
		// TODO Auto-generated method stub
		return cdi.findAll();
	}

	@Override
	public Classification getClassificationById(int id) {
		// TODO Auto-generated method stub
		return cdi.findById(id);
	}

}
