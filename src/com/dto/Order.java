package com.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Order {
private int id;
private Date dor;
private int qty;
private int prodid;



public Order() {
	super();
}
public Order(int id, Date dor, int qty, int prodid) {
	super();
	this.id = id;
	this.dor = dor;
	this.qty = qty;
	this.prodid = prodid;
}
@Override
public String toString() {
	return "Order [id=" + id + ", dor=" + dor + ", qty=" + qty + ", prodid=" + prodid + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDor() {
	return dor;
}
public void setDor(Date dor) {
	this.dor = dor;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public int getProdid() {
	return prodid;
}
public void setProdid(int prodid) {
	this.prodid = prodid;
}



}
