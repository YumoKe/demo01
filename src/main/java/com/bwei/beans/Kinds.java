package com.bwei.beans;

public class Kinds {

	private Integer gsid;
	
	private String gsname;

	public Kinds(Integer gsid, String gsname) {
		super();
		this.gsid = gsid;
		this.gsname = gsname;
	}

	public Integer getGsid() {
		return gsid;
	}

	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}

	public String getGsname() {
		return gsname;
	}

	public void setGsname(String gsname) {
		this.gsname = gsname;
	}

	public Kinds() {
		super();
	}

	@Override
	public String toString() {
		return "Kinds [gsid=" + gsid + ", gsname=" + gsname + "]";
	}
	
	
}

