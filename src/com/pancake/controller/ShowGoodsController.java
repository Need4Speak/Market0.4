package com.pancake.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Good;
import com.pancake.entity.GoodForm;
import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;
import com.pancake.entity.User;
import com.pancake.service.CollectionService;
import com.pancake.service.impl.PageServiceImpl;
import com.pancake.service.impl.ShowGoodServiceImpl;
import com.pancake.service.impl.UserServiceImpl;

@Controller
public class ShowGoodsController {
	private static final Log logger = LogFactory.getLog(ShowGoodsController.class);
	@Autowired
	private ShowGoodServiceImpl sgsi;
	@Autowired
	private PageServiceImpl psi;
	@Autowired
	private UserServiceImpl usi;
	@Autowired
	private CollectionService cs;

	@RequestMapping(value = "/showGoodsControllerOri")
	public ModelAndView inputProduct(HttpServletRequest request) {
		logger.info("InputProductController called 0429");
		int classification_id;
		if (request.getParameter("classification_id") != null
				&& !request.getParameter("classification_id").equals("")) {
			classification_id = Integer.parseInt(request.getParameter("classification_id"));
			logger.info("request.getParameter(classification_id) != null");
		} else {
			logger.info("request.getParameter(classification_id) = null");
			classification_id = -1;
		}
		// -1 means find all goods.
		// classification_id = 2;
		List<GoodForm> goodForms = sgsi.showGoodWithSeller(classification_id);
		ModelAndView mav = new ModelAndView("show_goods");
		mav.addObject("goodForms", goodForms);
		return mav;
	}

	@RequestMapping(value = "/goodInfoController")
	public ModelAndView goodInfo(HttpServletRequest request, HttpServletResponse response) {
		logger.info("goodInfoController called");
		ModelAndView mav = null;
		System.out.println("goodInfoController called");
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		GoodForm goodForm = sgsi.showGoodInfo(goodId);
		OrderTable collection = null;
		if (request.getSession().getAttribute("userName") != null) {
			int buyerId = usi.getByName((String) request.getSession().getAttribute("userName")).getUserId();
			collection = cs.getOrderByGoodAndBuyer(goodId, usi.getById(buyerId));
			logger.info("Object collection has been created");
			System.out.println("Object collection has been created");
		} else {
			logger.info("Object collection has not been created");
			System.out.println("Object collection has not been created");
		}

		if (null != goodForm) {
			mav = new ModelAndView("good_info");
			mav.addObject("goodForm", goodForm);
			mav.addObject("collection", collection);
			String userPhoto = usi.getByName(goodForm.getUserName()).getUserPhoto();
			mav.addObject("userPhoto", userPhoto);
		} else {
			mav = new ModelAndView("good_not_ready");
		}
		return mav;
	}

	@RequestMapping(value = "/showGoodsController")
	public ModelAndView findAllGood(HttpServletRequest request, HttpServletResponse response) {
		logger.info("FindAllGood called");
		ModelAndView mav = new ModelAndView("show_goods");
		try {
			int pageNo = 1;
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.valueOf(request.getParameter("pageNo"));
				logger.info("pageNo: " + pageNo);
			}
			int pageSize = 8;
			Page page = psi.queryForGoodPage(pageNo, pageSize);
			mav.addObject(page);
			// List<GoodForm> goodForms = sgsi.showGoodWithPage(pageSize,
			// pageNo);
			// request.setAttribute("goodForms", goodForms);
			// mav.addObject(goodForms);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
