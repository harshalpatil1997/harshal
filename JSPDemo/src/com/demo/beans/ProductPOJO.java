package com.demo.beans;

public class ProductPOJO {
int pid,quant,cid;
long price;
String pname;

public ProductPOJO(int pid,  String pname,int quant, int cid, long price) {
	super();
	this.pid = pid;
	this.quant = quant;
	this.cid = cid;
	this.price = price;
	this.pname = pname;
}

@Override
public String toString() {
	return "ProductPOJO [pid=" + pid + ", quant=" + quant + ", cid=" + cid + ", price=" + price + ", pname=" + pname
			+ "]";
}

public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getQuant() {
	return quant;
}
public void setQuant(int quant) {
	this.quant = quant;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}

}
