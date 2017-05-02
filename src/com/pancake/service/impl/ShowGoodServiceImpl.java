package com.pancake.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import javassist.compiler.Javac;

import com.pancake.dao.impl.ClassificationDaoImpl;
import com.pancake.dao.impl.GoodDaoImpl;
import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.Classification;
import com.pancake.entity.Good;
import com.pancake.entity.GoodForm;
import com.pancake.service.ShowGoodService;
import com.pancake.util.SplitStrIntoList;

@Service
public class ShowGoodServiceImpl implements ShowGoodService {

	private GoodDaoImpl goodDaoImpl = new GoodDaoImpl();
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private PageServiceImpl psi = new PageServiceImpl();
	private ClassificationDaoImpl cdi = new ClassificationDaoImpl();

	@Override
	public List<GoodForm> showGoodWithSeller(int classificationId) {

		// Use to store good info with seller's info.
		List<GoodForm> goodForms = new ArrayList<GoodForm>();
		GoodForm aGoodForm = null;

		// GoodDaoImpl goodDaoImpl = new GoodDaoImpl();
		// UserDaoImpl userDaoImpl = new UserDaoImpl();

		@SuppressWarnings("unchecked")
		// ArrayList<Good> goodsList = (ArrayList<Good>) goodDaoImpl.findAll();
		ArrayList<Good> goodsList = null;
		if (classificationId == -1) {
			goodsList = (ArrayList<Good>) goodDaoImpl.findAllByAddTime();
		} else {
			Classification classification = cdi.findById(classificationId);
			goodsList = (ArrayList<Good>) goodDaoImpl.findByClassification(classification);
		}

		// Remove good in goodsList whose status is 0. 0 means this good can not
		// buy.
		Iterator<Good> iter = goodsList.iterator();
		while (iter.hasNext()) {
			Good good = iter.next();
			if (0 == good.getStatus()) {
				iter.remove();
			}
		}

		Iterator<Good> goodsListIterator = goodsList.iterator();
		Good eachGood = null;

		// Process pictures which store by using string with form
		// "pic1, pic2, ..."
		String[] eachGoodPictures;
		List<String> goodPicturesList = new ArrayList<String>();

		while (goodsListIterator.hasNext()) {
			eachGood = (Good) goodsListIterator.next();

			// Ensure each good own 2 pictures.
			eachGoodPictures = eachGood.getPictures().split(", ");
			Collections.addAll(goodPicturesList, eachGoodPictures);
			// If the good only have one pictures.
			if (eachGoodPictures.length < 2) {
				goodPicturesList.add("noGoodPictures.jpg");
			}

			aGoodForm = new GoodForm(eachGood.getGoodId(), eachGood.getUser().getUserName(),
					eachGood.getUser().getUserPhoto(), eachGood.getName(), eachGood.getPrice(), goodPicturesList,
					eachGood.getFreight(), eachGood.getStatus(), eachGood.getClassification().getClassificationName(),
					eachGood.getDescription());
			goodForms.add(aGoodForm);

			// goodPicturesList ponit to another list.
			goodPicturesList = new ArrayList<String>();
		}

		return goodForms;
	}

	@Override
	public GoodForm showGoodInfo(java.lang.Integer goodId) {
		Good good = goodDaoImpl.findById(goodId);
		GoodForm goodForm = null;
		if (null != good) {
			List<String> picList = SplitStrIntoList.run(good.getPictures());
			goodForm = new GoodForm(good.getGoodId(), good.getUser().getUserName(), good.getUser().getUserPhoto(),
					good.getName(), good.getPrice(), picList, good.getFreight(), good.getStatus(),
					good.getClassification().getClassificationName(), good.getDescription());
		}

		return goodForm;
	}

	@Override
	public List<GoodForm> showGoodWithPage(ArrayList<Good> goodsList) {

		// Use to store good info with seller's info.
		List<GoodForm> goodForms = new ArrayList<GoodForm>();
		GoodForm aGoodForm = null;

		Iterator<Good> goodsListIterator = goodsList.iterator();
		Good eachGood = null;

		// Process pictures which store by using string with form
		// "pic1, pic2, ..."
		String[] eachGoodPictures;
		List<String> goodPicturesList = new ArrayList<String>();

		while (goodsListIterator.hasNext()) {
			eachGood = (Good) goodsListIterator.next();

			// Ensure each good own 2 pictures.
			eachGoodPictures = eachGood.getPictures().split(", ");
			Collections.addAll(goodPicturesList, eachGoodPictures);
			// If the good only have one pictures.
			if (eachGoodPictures.length < 2) {
				goodPicturesList.add("noGoodPictures.jpg");
			}

			aGoodForm = new GoodForm(eachGood.getGoodId(), eachGood.getUser().getUserName(), eachGood.getName(),
					eachGood.getPrice(), goodPicturesList, eachGood.getFreight(), eachGood.getStatus(),
					eachGood.getClassification().getClassificationName());
			goodForms.add(aGoodForm);

			// goodPicturesList ponit to another list.
			goodPicturesList = new ArrayList<String>();
		}

		return goodForms;
	}

}
