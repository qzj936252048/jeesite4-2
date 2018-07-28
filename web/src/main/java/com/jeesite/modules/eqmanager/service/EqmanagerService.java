/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.eqmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.eqmanager.entity.Eqmanager;
import com.jeesite.modules.eqmanager.dao.EqmanagerDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * eqmanagerService
 * @author qzj
 * @version 2018-07-28
 */
@Service
@Transactional(readOnly=true)
public class EqmanagerService extends CrudService<EqmanagerDao, Eqmanager> {
	
	/**
	 * 获取单条数据
	 * @param eqmanager
	 * @return
	 */
	@Override
	public Eqmanager get(Eqmanager eqmanager) {
		return super.get(eqmanager);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param eqmanager
	 * @return
	 */
	@Override
	public Page<Eqmanager> findPage(Page<Eqmanager> page, Eqmanager eqmanager) {
		return super.findPage(page, eqmanager);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param eqmanager
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Eqmanager eqmanager) {
		super.save(eqmanager);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(eqmanager.getId(), "eqmanager_image");
	}
	
	/**
	 * 更新状态
	 * @param eqmanager
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Eqmanager eqmanager) {
		super.updateStatus(eqmanager);
	}
	
	/**
	 * 删除数据
	 * @param eqmanager
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Eqmanager eqmanager) {
		super.delete(eqmanager);
	}
	
}