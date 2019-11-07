package com.bwei.beans;

public class Goods {

	private Integer gid;
	
	private String gname;
	
	private String gename;
	
	private Integer bid;
	
	private Integer gsid;
	
	private String weight;
	
	private String price;
	
	private String cot;
	
	private String gsname;
	
	private String bname;
	
	private String imgurl;
	
	private String message;
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Goods(Integer gid, String gname, String gename, Integer bid, Integer gsid, String weight, String price,
			String cot, String gsname, String bname, String imgurl) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gename = gename;
		this.bid = bid;
		this.gsid = gsid;
		this.weight = weight;
		this.price = price;
		this.cot = cot;
		this.gsname = gsname;
		this.bname = bname;
		this.imgurl = imgurl;
	}

	public Goods() {
		super();
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGename() {
		return gename;
	}

	public void setGename(String gename) {
		this.gename = gename;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getGsid() {
		return gsid;
	}

	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCot() {
		return cot;
	}

	public void setCot(String cot) {
		this.cot = cot;
	}

	public String getGsname() {
		return gsname;
	}

	public void setGsname(String gsname) {
		this.gsname = gsname;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gename=" + gename + ", bid=" + bid + ", gsid=" + gsid
				+ ", weight=" + weight + ", price=" + price + ", cot=" + cot + ", gsname=" + gsname + ", bname=" + bname
				+ ", imgurl=" + imgurl + "]";
	}
	
	
}
