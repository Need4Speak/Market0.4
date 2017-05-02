package com.pancake.service;

import java.util.List;

import com.pancake.entity.Classification;


public interface ClassificationService {
	List<Classification> getAllClassifications();
	Classification getClassificationById(int id);
}
