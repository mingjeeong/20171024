package com.work.spring40.service;

import java.util.Map;

public interface UserService {
	// 등급반환
	public String login(String id,String pw);
	
	//등급 이름 반환 Service 분리작업 map =>controller
	//servie->controller->view
	public Map<String,String> login(Map<String,String> map);
	public int addUser(String id,String pw,String name,String grade);
	public boolean delete(String userId);
}
