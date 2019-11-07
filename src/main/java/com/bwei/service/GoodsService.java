package com.bwei.service;

import java.util.List;

import com.bwei.beans.Goods;
import com.bwei.beans.MySort;

public interface GoodsService {

	public List<Goods> findAll(MySort sort);
	
	public int add(Goods goos);
	
	public int del(Integer gid);
	
	public Goods toUpd(Integer gid);
	
	public int upd(Goods goos);
}
