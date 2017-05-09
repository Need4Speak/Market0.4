package com.pancake.controller;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.GoodForm;
import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;
import com.pancake.service.CollectionService;
import com.pancake.service.PageService;
import com.pancake.service.ShowGoodService;
import com.pancake.service.ShowOrderService;
import com.pancake.service.impl.ShowOrderServiceImpl;
import com.pancake.util.SplitStrIntoList;

@Controller
public class CollectionController {
	private static final Log logger = LogFactory.getLog(ShowGoodsController.class);
	@Autowired
	private ShowGoodService sgsi;
	@Autowired
	private ShowOrderService soService;
	@Autowired
	private CollectionService cs;
	@Autowired
	private PageService psi;

	@RequestMapping(value = "/collectController")
	public String collect(HttpServletRequest request, HttpServletResponse response) {
		logger.info("collectController called");

		int goodId = Integer.parseInt(request.getParameter("goodId"));
		String buyerName = (String) request.getSession().getAttribute("userName");

		try {
			cs.createCollection(buyerName, goodId);
			logger.info("Create collection successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/goodInfoController?goodId=" + goodId;
	}

	@RequestMapping(value = "/placeOrderController")
	public ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) {
		logger.info("placeOrderController called");
		ModelAndView mav = new ModelAndView("showOrder");

		int goodId = Integer.parseInt(request.getParameter("goodId"));
		GoodForm goodForm = sgsi.showGoodInfo(goodId);

		String address = request.getParameter("address").trim();
		String description = request.getParameter("description").trim();
		String buyerName = (String) request.getSession().getAttribute("userName");

		ShowOrderServiceImpl sosi = new ShowOrderServiceImpl();
		OrderTable orderForm = sosi.createOrder(buyerName, goodId, address, description);

		mav.addObject("goodForm", goodForm);
		mav.addObject("orderForm", orderForm);
		return mav;
	}

	// @RequestMapping(value = "/orderListController")
	@RequestMapping(value = "/collectionListControllerOri")
	public ModelAndView collectionList(HttpSession session, HttpServletRequest request) {
		logger.info("collectionListController called");
		String userName = ((String) session.getAttribute("userName"));
		ModelAndView mav = null;
		if (null != userName) {

			mav = new ModelAndView("collection_list");

			int collectionStatus = Integer.parseInt(request.getParameter("collectionStatus"));

			List<OrderTable> collectionList = soService.getOrderByBuyerName(userName);
			OrderTable collection = null;
			for (Iterator<OrderTable> iterator = collectionList.iterator(); iterator.hasNext();) {
				collection = (OrderTable) iterator.next();
				// 将某件商品的第一张图片存入 pictures 属性里，用于显示。
				List<String> picList = SplitStrIntoList.run(collection.getGood().getPictures());
				collection.getGood().setPictures(picList.get(0));
				if (-1 != collectionStatus && collection.getStatus() != collectionStatus) {
					iterator.remove();
				}
			}
			mav.addObject("collectionList", collectionList);
		} else {
			mav = new ModelAndView("redirect:/loginBarController");
		}
		return mav;
	}
	
	@RequestMapping(value = "/collectionListController")
	public ModelAndView findAllCollection(HttpSession session, HttpServletRequest request) {
		logger.info("FindAllCollection called");
		String userName = ((String) session.getAttribute("userName"));
		ModelAndView mav = null;
		if (null != userName) {
			mav = new ModelAndView("collection_list");
			try {
				int pageNo = 1;
				if (request.getParameter("pageNo") != null) {
					pageNo = Integer.valueOf(request.getParameter("pageNo"));
					logger.info("pageNo: " + pageNo);
				}
				int pageSize = 8;
				Page page = psi.queryForCollectionPage(pageNo, pageSize, userName);
				mav.addObject("page", page);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			mav = new ModelAndView("redirect:/loginBarController");
		}
		return mav;
	}

	@RequestMapping(value = "/SellerOrderListController")
	public ModelAndView sellerOrderList(HttpSession session, HttpServletRequest request) {
		logger.info("orderListController called");
		ModelAndView mav = new ModelAndView("orderListSell");

		int orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
		String userName = ((String) session.getAttribute("userName")).trim();
		List<OrderTable> orderList = soService.getOrderBySellerName(userName);
		OrderTable order = null;
		for (Iterator<OrderTable> iterator = orderList.iterator(); iterator.hasNext();) {
			order = (OrderTable) iterator.next();
			// 将某件商品的第一张图片存入 pictures 属性里，用于显示。
			List<String> picList = SplitStrIntoList.run(order.getGood().getPictures());
			order.getGood().setPictures(picList.get(0));
			if (-1 != orderStatus && order.getStatus() != orderStatus) {
				iterator.remove();
			}
		}
		mav.addObject("orderList", orderList);
		return mav;
	}

	// @RequestMapping(value = "/orderCancelController/{orderId}")
	@RequestMapping(value = "/collectionCancelController/{orderId}")
	public ModelAndView collectionCancel(Model model, @PathVariable int orderId, HttpServletRequest  request) {
		OrderTable collection = soService.getOrderById(orderId);
		// Set the status of collection to 0, 0 means cancel.
		collection.setStatus(0);
		Timestamp cancelTime = new Timestamp(System.currentTimeMillis());
		collection.setCancelTime(cancelTime);
		soService.update(collection);
		String page = request.getParameter("page");
		ModelAndView mav = null;
		if(null != page && page.equals("good_info")){
			mav = new ModelAndView("redirect:/goodInfoController?goodId=" + collection.getGood().getGoodId());
		}
		else if (null != page && page.equals("collection_list")) {
			mav = new ModelAndView("redirect:/collectionListController?collectionStatus=1");
		}
		else {
			mav = new ModelAndView("");
		}
		return mav;
//		page = (String) request.getAttribute("page");
//		return "redirect:/goodInfoController?goodId=" + collection.getGood().getGoodId();
//		if (null != page && page.equals("good_info")) {
//			return "redirect:/goodInfoController?goodId=" + collection.getGood().getGoodId();
//		}
//		else {
//			return "redirect:/collectionListController?collectionStatus=1";
//		}
	}
}
