package com.yxy.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yxy.bean.User;
import com.yxy.dao.UserDao;
import com.yxy.service.UserService;
@Transactional(readOnly=true)
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Cacheable(value="serviceCache",key="'UserServiceImpl_gets_'+#a")
	public String gets(String a){
		System.out.println("进入getA方法   a="+a);
		return "sdc"+a;
	}
	
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void addUser(){
		User u=new User();
		u.setUserName("ddd");
		u.setPassword("ss");
		u.setAge(1);
		
		User s=new User();
		s.setUserName("dfffffffddddddddddddddddddddddddd");
		s.setPassword("ddd");
		this.userDao.addXxx(u);
		this.userDao.addXxx(s);
		
		
		System.out.println("sss");
		
	}

}
