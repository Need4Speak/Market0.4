package com.pancake.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Good;
import com.pancake.entity.User;
import com.pancake.service.UserService;
import com.pancake.util.FilePath;
import com.pancake.util.GetTime;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	private static final Log logger = LogFactory.getLog(GoodController.class);

	@RequestMapping(value = "/userInfoController")
	public ModelAndView userInfo(Model model, HttpSession session) {
		logger.info("userInfoController called");
		String userName = (String) session.getAttribute("userName");
		ModelAndView mav = null;
		if (null != userName) {
			User aUser = userService.getByName(userName);
			mav = new ModelAndView("user_info");
			mav.addObject("user", aUser);
		}
		else {
			mav = new ModelAndView("redirect:/loginBarController");
		}
		return mav;
	}

	@RequestMapping(value = "/userUpdateController")
	public String updateGood(@RequestParam("userPhoto") MultipartFile file, HttpServletRequest request) {

		logger.info("userId in userUpdateController: " + request.getParameter("userId"));
		User user = userService.getById(Integer.parseInt(request.getParameter("userId")));
		user.setUserName(request.getParameter("userName"));
		user.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber").trim()));
		user.setGender(request.getParameter("gender"));

		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 文件保存路径
				String filePath = request.getServletContext()
						.getRealPath("/images/" + request.getParameter("userName") + "/head");
				String fileName = file.getOriginalFilename();
				fileName = "head." + fileName.split("[.]")[fileName.split("[.]").length - 1];				
				FilePath.isExistDir(filePath);
				// 转存文件
				file.transferTo(new File(filePath, fileName));
				user.setUserPhoto(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		userService.update(user);
		return "redirect:/userInfoController";
	}
}
