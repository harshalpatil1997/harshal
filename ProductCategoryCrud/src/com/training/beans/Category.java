package com.training.beans;

public class Category {
	private String cName,cDesc;
	private int cid;
	public Category(int cid,String cName, String cDesc ) {
		super();
		this.cName = cName;
		this.cDesc = cDesc;
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDesc() {
		return cDesc;
	}
	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Category [cName=" + cName + ", cDesc=" + cDesc + ", cid=" + cid + "]";
	}
	

}
