package com.bwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bwei.beans.Kinds;
import com.bwei.dao.KindsDao;

@Service
public class KindsServiceImpl implements KindsService {

	@Resource
	KindsDao dao;
	
	public List<Kinds> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
