package com.demo.beans;

public class CategoryPOJO {
int cid;
String cname;

@Override
public String toString() {
	return "CategoryPOJO [cid=" + cid + ", cname=" + cname + "]";
}
public CategoryPOJO(int cid, String cname) {
	super();
	this.cid = cid;
	this.cname = cname;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
}
