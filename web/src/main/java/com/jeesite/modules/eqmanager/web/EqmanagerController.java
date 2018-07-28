/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.eqmanager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.eqmanager.entity.Eqmanager;
import com.jeesite.modules.eqmanager.service.EqmanagerService;

/**
 * eqmanagerController
 * @author qzj
 * @version 2018-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/eqmanager/eqmanager")
public class EqmanagerController extends BaseController {

	@Autowired
	private EqmanagerService eqmanagerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Eqmanager get(String id, boolean isNewRecord) {
		return eqmanagerService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("eqmanager:eqmanager:view")
	@RequestMapping(value = {"list", ""})
	public String list(Eqmanager eqmanager, Model model) {
		model.addAttribute("eqmanager", eqmanager);
		return "modules/eqmanager/eqmanagerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("eqmanager:eqmanager:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Eqmanager> listData(Eqmanager eqmanager, HttpServletRequest request, HttpServletResponse response) {
		Page<Eqmanager> page = eqmanagerService.findPage(new Page<Eqmanager>(request, response), eqmanager); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("eqmanager:eqmanager:view")
	@RequestMapping(value = "form")
	public String form(Eqmanager eqmanager, Model model) {
		model.addAttribute("eqmanager", eqmanager);
		return "modules/eqmanager/eqmanagerForm";
	}

	/**
	 * 保存保存设备管理成功
	 */
	@RequiresPermissions("eqmanager:eqmanager:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Eqmanager eqmanager) {
		eqmanagerService.save(eqmanager);
		return renderResult(Global.TRUE, text("保存保存设备管理成功成功！"));
	}
	
	/**
	 * 删除保存设备管理成功
	 */
	@RequiresPermissions("eqmanager:eqmanager:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Eqmanager eqmanager) {
		eqmanagerService.delete(eqmanager);
		return renderResult(Global.TRUE, text("删除保存设备管理成功成功！"));
	}
	
}