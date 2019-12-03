
package com.training.beans;

public class Product {
      private int pid,qty,cid;
      private String pname;
	public Product(int pid, String pname,int qty, int cid) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.cid = cid;
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", cid=" + cid + ", pname=" + pname + "]";
	}
	
	
      
}
