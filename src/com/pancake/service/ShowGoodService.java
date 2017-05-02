package com.pancake.service;

import java.util.ArrayList;
import java.util.List;

import com.pancake.entity.Good;
import com.pancake.entity.GoodForm;


public interface ShowGoodService {
	public List<GoodForm> showGoodWithSeller(int classificationId);
	public GoodForm showGoodInfo(java.lang.Integer goodId);
	public List<GoodForm> showGoodWithPage(ArrayList<Good> goodsList);
}
