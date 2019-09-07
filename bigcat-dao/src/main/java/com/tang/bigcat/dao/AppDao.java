package com.tang.bigcat.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AppDao {
	
	public String app(){
		
		System.out.println("调用了DAO层");
		String str="return data OK";
		
		return str;
	}

}
