package com.peiqi.commons.pojo.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = -8562527733620013974L;

	private String oid;
	private String addr;
	private String name;
	private String phone;
	private Integer state;
	private Double total;
	private Date ordertime;
	private Integer uid;

	private List<OrderItem> orderItems = new ArrayList<>();

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", addr=" + addr + ", name=" + name + ", phone=" + phone + ", state=" + state
				+ ", total=" + total + ", ordertime=" + ordertime + ", uid=" + uid + ", orderItems=" + orderItems + "]";
	}

}
