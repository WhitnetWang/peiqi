package com.peiqi.commons.pojo.category;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6884846131679255591L;
	private Integer cid;
	private String cname;

	private List<CategorySecond> categorySeconds;

	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

}
