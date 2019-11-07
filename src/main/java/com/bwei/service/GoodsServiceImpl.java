package com.bwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwei.beans.Goods;
import com.bwei.beans.MySort;
import com.bwei.dao.GoodsDao;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Resource
	GoodsDao dao;
	
	public List<Goods> findAll(MySort sort) {
		// TODO Auto-generated method stub
		return dao.findAll(sort);
	}

	public int add(Goods goos) {
		// TODO Auto-generated method stub
		return dao.add(goos);
	}

	public int del(Integer gid) {
		// TODO Auto-generated method stub
		return dao.del(gid);
	}

	public Goods toUpd(Integer gid) {
		// TODO Auto-generated method stub
		return dao.toUpd(gid);
	}

	public int upd(Goods goos) {
		// TODO Auto-generated method stub
		return dao.upd(goos);
	}

}
