package com.pancake.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Good;
import com.pancake.entity.GoodWithImage;
import com.pancake.entity.Image;
import com.pancake.entity.Page;
import com.pancake.entity.User;
import com.pancake.service.ClassificationService;
import com.pancake.service.GoodService;
import com.pancake.service.PageService;
import com.pancake.service.UserService;
import com.pancake.service.impl.ClassificationServiceImpl;
import com.pancake.util.FilePath;
import com.pancake.util.GetTime;
import com.pancake.util.PicFormatProcess;

@Controller
public class GoodController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private UserService userService;
	@Autowired
	private ClassificationService classificationService;
	@Autowired
	private PageService psi;

	private static final Log logger = LogFactory.getLog(GoodController.class);
	
//	@RequestMapping(value = "/good_input")
	@RequestMapping(value = "/goodInputController")
	public String goodInput(Model model, HttpSession session) {
		logger.info("goodInputController called");
		String userName = ((String) session.getAttribute("userName"));
		if (null != userName) {
			model.addAttribute("good", new Good());
			return "good_add_form";
		}
		else {
			return "redirect:/loginBarController";
		}
		
	}

//	@RequestMapping(value = "/good_edit/{id}")
	@RequestMapping(value = "/goodEditController")
	public String editGood(Model model, HttpServletRequest request) {
		logger.info("goodEditController called");
		int goodId = Integer.valueOf(request.getParameter("goodId"));
		Good good = goodService.get(goodId);
		model.addAttribute("good", good);
		return "good_edit_form";
	}

//	@RequestMapping(value = "/good_delete/{id}")
	@RequestMapping(value = "/goodDeleteController/{id}")
	public String deleteGood(Model model, @PathVariable int id) {
		logger.info("goodDeleteController called");
		Good good = goodService.get(id);
		// 0: can't buy. Don't delete the good info.
		good.setStatus(0);
		goodService.update(good);
		model.addAttribute("good", good);
		return "redirect:/goodListController";
	}

	@RequestMapping(value = "/good_save")
	public String saveGood(@ModelAttribute GoodWithImage good, HttpSession session, HttpServletRequest request) {
		logger.info("save Good called");
		// Get user object by "userName" attr which is stored in session.
		// Then add in to object good.
		good.setUser(userService.getByName((String) session.getAttribute("userName")));
		good.setClassification(classificationService
				.getClassificationById(Integer.parseInt(request.getParameter("classification_id"))));
		// 1 means the good can be selled, by default status=1.
		good.setStatus(1);

		// 存储图片到image下
		List<String> piclList = storeImage(good, session, request);
		String picString = PicFormatProcess.ListToStr(piclList);
		logger.info("good name: " + good.getName());
		Timestamp addTime = new Timestamp(System.currentTimeMillis());
		Timestamp delTime = null;
		Good goodInDB = new Good(good.getClassification(), good.getUser(), good.getName(), good.getPrice(), picString,
				good.getFreight(), good.getDescription(), good.getStatus(), addTime, delTime, good.getOrderTables());
		goodService.save(goodInDB);
		return "redirect:/goodListController";
	}

	public List<String> storeImage(GoodWithImage good, HttpSession session, HttpServletRequest servletRequest) {
		List<MultipartFile> files = good.getPictures();

		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileName = GetTime.getTimeForPic() + "." + fileName.split("[.]")[fileName.split("[.]").length - 1];
				fileNames.add(fileName);
				String imagesDir = servletRequest.getServletContext().getRealPath("/images");
				String userName = ((String) session.getAttribute("userName")).trim();
				String picStoreDir = servletRequest.getServletContext()
						.getRealPath("/images/" + userName + "/goodPics");
				FilePath.isExistDir(picStoreDir);

				logger.info("images path: " + servletRequest.getServletContext().getRealPath("/images"));
				File imageFile = new File(picStoreDir, fileName);
				try {
					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileNames;
	}

	@RequestMapping(value = "/goodUpdateController")
	public String updateGood(@ModelAttribute Good good, HttpSession session, HttpServletRequest request) {
		// Don't no how to bound field "User user", use session temporary。
		good.setUser(userService.getByName((String) session.getAttribute("userName")));
		good.setClassification(goodService.get(good.getGoodId()).getClassification());
		good.setAddTime(goodService.get(good.getGoodId()).getAddTime());
		good.setDelTime(goodService.get(good.getGoodId()).getDelTime());
		goodService.update(good);
		return "redirect:/goodListController";
	}

//	@RequestMapping(value = "/good_list")
	@RequestMapping(value = "/goodListControllerOri")
	public String listGoods(Model model, HttpSession session) {
		String userName = ((String) session.getAttribute("userName"));
		if (null != userName) {
			logger.info("goodListController");
			List<Good> goods = goodService
					.getAllGoodsByUser(userService.getByName((String) session.getAttribute("userName")));
			model.addAttribute("goods", goods);
			return "good_list";
		}
		else {
			return "redirect:/loginBarController";
		}
		
	}
	
	@RequestMapping(value = "/goodListController")
	public String goodList(Model model, HttpSession session, HttpServletRequest request) {
		String userName = ((String) session.getAttribute("userName"));
		if (null != userName) {
			try {
				int pageNo = 1;
				if (request.getParameter("pageNo") != null) {
					pageNo = Integer.valueOf(request.getParameter("pageNo"));
					logger.info("pageNo: " + pageNo);
				}
				int pageSize = 8;
				// 用户暂时只能查看所有发布的商品，不能分类查看。
				int classificationId = -1;
				Page page = psi.queryForGoodListPage(pageNo, pageSize, classificationId, userName);
				model.addAttribute("page", page);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			List<Good> goods = goodService
//					.getAllGoodsByUser(userService.getByName((String) session.getAttribute("userName")));
//			model.addAttribute("goods", goods);
			return "good_list";
		}
		else {
			return "redirect:/loginBarController";
		}
		
	}
}