package com.pancake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.GoodForm;
import com.pancake.service.impl.LoginCheckServiceImpl;
import com.pancake.service.impl.ShowGoodServiceImpl;

@Controller
public class LogController {
	private static final Log logger = LogFactory
			.getLog(ShowGoodsController.class);

	@Autowired
	private LoginCheckServiceImpl lcsi;

	@RequestMapping(value = "/loginBarController")
	public String loginBar() {
		logger.info("loginController called");

		return "login";
	}

	@RequestMapping(value = "/loginController")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		logger.info("loginController called");

		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();

		boolean loginCondition = lcsi.compareLoginInfo(userName, password);

		// ModelAndView mav = new ModelAndView("showGoods");
		if (loginCondition) {
			request.getSession().setAttribute("userName", userName);
			// request.getRequestDispatcher("/index.jsp").forward(request,
			// response);
			return "redirect:/showGoodsController";
		} else {
			return "loginFail";
		}

	}

	@RequestMapping(value = "/logoutController")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("logoutController called");

		HttpSession session = request.getSession(false);
		String userName = request.getParameter("userName").trim();
		// preBasePath store the page path who call this servlet.
		// String preBasePath = request.getParameter("basePath");

		if (userName == null) {
			System.out.println("usrName is null in /logout.");
		} else {
			session.invalidate();
		}

		return "redirect:/showGoodsController";
	}
}
