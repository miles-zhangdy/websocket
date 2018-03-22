package com.ssm.web.operator.dic;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ssm.business.dictionary.vo.DictionaryQueryVO;
import com.ssm.business.dictionary.vo.DictionaryVO;
import com.ssm.common.controller.BaseController;
import com.ssm.common.model.EnvironmentUserVO;
import com.ssm.common.model.Page;
import com.ssm.common.model.Result;
import com.ssm.services.dictionary.DictionaryService;

@Controller
@RequestMapping("admin/dictionary")
public class DictionaryController extends BaseController {

	@Resource
	private DictionaryService dictionaryService;

	@RequestMapping(value = "/dictionarypage")
	public ModelAndView dictionaryPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/operator/dic/dictionary");
		EnvironmentUserVO environmentUserVO = this.getEnvironmentUserVO();
		DictionaryQueryVO queryVO = new DictionaryQueryVO();
		queryVO.setBeginIndex(0);
		queryVO.setPageSize(10);
		queryVO.setAliveFlag(1);
		queryVO.setCreateUser(environmentUserVO.getUserId() + "");

		Page page = dictionaryService.findDictionaryPageList(queryVO);
		modelAndView.addObject("data", JSON.toJSONString(page));

		this.setMenu(modelAndView);

		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/findDictionaryPageList")
	public Page findDictionaryPageList(HttpServletRequest request, DictionaryQueryVO queryVO) {
		queryVO.setBeginIndex((queryVO.getPage() - 1) * queryVO.getPageSize());
		Page page = dictionaryService.findDictionaryPageList(queryVO);
		return page;
	}

	@ResponseBody
	@RequestMapping(value = "/insertdictionary")
	public Result insertDictionary(HttpServletRequest request, DictionaryVO dictionaryVO) {
		Result result = new Result();
		EnvironmentUserVO environmentUserVO = this.getEnvironmentUserVO();
		dictionaryVO.setCreateUser(environmentUserVO.getUserId() + "");
		dictionaryVO.setCreateTime(new Date().getTime());
		dictionaryVO.setAliveFlag(1);
		int count = dictionaryService.insertDictionary(dictionaryVO);

		if (count > 0) {
			result.setSuccess(true);
			return result;
		}
		result.setSuccess(false);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/deldictionary")
	public Result delDictionary(HttpServletRequest request, DictionaryVO dictionaryVO) {
		Result result = new Result();
		int count = dictionaryService.delDictionary(dictionaryVO.getDictionaryId());

		if (count > 0) {
			result.setSuccess(true);
			return result;
		}
		result.setSuccess(false);
		return result;
	}

}
