package com.work.spring40.model;

import java.util.Map;

/**회원관리 테이블 DAO 기능선언*/
public interface UserDao {

	public String login(String userId,String userPw);
	public Map<String,String> login(Map<String,String> map);
	public int addUser(String userId,String userPw,String userName,String grade);
	public boolean checkId(String userId);
	public boolean delete(String userId);
}
