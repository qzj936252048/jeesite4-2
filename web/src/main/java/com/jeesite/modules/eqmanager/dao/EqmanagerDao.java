/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.eqmanager.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.eqmanager.entity.Eqmanager;

/**
 * eqmanagerDAO接口
 * @author qzj
 * @version 2018-07-28
 */
@MyBatisDao
public interface EqmanagerDao extends CrudDao<Eqmanager> {
	
}