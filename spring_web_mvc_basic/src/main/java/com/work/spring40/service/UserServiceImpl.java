package com.work.spring40.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.work.spring40.model.UserDao;
import com.work.spring40.model.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService {

	//--dao setter injection
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public String login(String userId,String userPw) {
		return userDao.login(userId, userPw);
	}
	public Map<String,String> login(Map<String,String> map){
		return userDao.login(map);
	}
	public int addUser(String userId,String userPw,String userName,String grade) {
		if(userDao.checkId(userId)) {
			return userDao.addUser(userId, userPw, userName, grade);
		}else {
			return 0;
		}
	}
	public boolean delete(String userId) {
		return userDao.delete(userId);
	}
	
}
