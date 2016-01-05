package com.univ.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author univ 
 * @date 2015年12月30日 上午9:11:07 
 * @version v1.0
 * @Description: 入口控制器
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	private Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/toHome")
	public String toHome(){
		logger.debug("=======HomeController.tohHome() invoked=======");
		return "home";
	}
}

