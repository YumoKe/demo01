package com.bwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bwei.beans.Brand;
import com.bwei.dao.BrandDao;

@Service
public class BrandServiceImpl implements BrandService {

	@Resource
	BrandDao dao;
	
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
