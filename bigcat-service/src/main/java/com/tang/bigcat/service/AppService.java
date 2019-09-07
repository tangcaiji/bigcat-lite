package com.tang.bigcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang.bigcat.dao.AppDao;

/**
 * Hello world!
 *
 */
@Service
public class AppService {
	
	@Autowired
	private AppDao appDao;
	
	public String app(){
		
		return appDao.app();
	}
	
}
