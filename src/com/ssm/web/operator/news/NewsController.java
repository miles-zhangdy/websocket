package com.ssm.web.operator.news;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.common.controller.BaseController;

@Controller
@RequestMapping("admin/news")
public class NewsController extends BaseController{

	
	@RequestMapping(value = "/toUpload")
	public ModelAndView toUpload(){
		ModelAndView modelAndView = new ModelAndView("/operator/news/insert_news");
		return modelAndView;
	}
	
}
