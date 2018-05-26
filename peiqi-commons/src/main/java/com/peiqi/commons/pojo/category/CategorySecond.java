package com.peiqi.commons.pojo.category;

import java.io.Serializable;

public class CategorySecond implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8991265430004743820L;
	private Integer csid;
	private String csname;
	private Integer cid;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", cid=" + cid + "]";
	}

}
