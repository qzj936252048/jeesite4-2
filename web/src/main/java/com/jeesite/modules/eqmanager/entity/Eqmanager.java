/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.eqmanager.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * eqmanagerEntity
 * @author qzj
 * @version 2018-07-28
 */
@Table(name="eqmanager", alias="a", columns={
		@Column(includeEntity=DataEntity.class),
		@Column(name="eqnum", attrName="eqnum", label="设备编号", queryType=QueryType.LIKE),
		@Column(name="eqname", attrName="eqname", label="设备名称", queryType=QueryType.LIKE),
		@Column(name="addtime", attrName="addtime", label="添加时间"),
		@Column(name="eqstate", attrName="eqstate", label="设备状态"),
		@Column(name="id", attrName="id", label="编号", isPK=true),
	}, orderBy="a.update_date DESC"
)
public class Eqmanager extends DataEntity<Eqmanager> {
	
	private static final long serialVersionUID = 1L;
	private String eqnum;		// 设备编号
	private String eqname;		// 设备名称
	private String addtime;		// 添加时间
	private String eqstate;		// 设备状态
	
	public Eqmanager() {
		this(null);
	}

	public Eqmanager(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="设备编号长度不能超过 255 个字符")
	public String getEqnum() {
		return eqnum;
	}

	public void setEqnum(String eqnum) {
		this.eqnum = eqnum;
	}
	
	@Length(min=0, max=255, message="设备名称长度不能超过 255 个字符")
	public String getEqname() {
		return eqname;
	}

	public void setEqname(String eqname) {
		this.eqname = eqname;
	}
	
	@Length(min=0, max=255, message="添加时间长度不能超过 255 个字符")
	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	@Length(min=0, max=255, message="设备状态长度不能超过 255 个字符")
	public String getEqstate() {
		return eqstate;
	}

	public void setEqstate(String eqstate) {
		this.eqstate = eqstate;
	}
	
}