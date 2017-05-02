package com.pancake.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {
	private static final Log logger = LogFactory
			.getLog(ShowGoodsController.class);
	
	@RequestMapping(value = "/managementController")
	public String managementController() {
		logger.info("managementController called");

		return "management";
	}
}
