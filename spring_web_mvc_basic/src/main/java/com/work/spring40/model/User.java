package com.work.spring40.model;

//Join.jsp 참조해서 도메인 클래스 구현
public class User {

	private String userId;
	private String userPw;
	private String userName;
	private String grade;
	
	public User() {
		super();
	}

	public User(String userId, String userPw, String userName, String grade) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.grade = grade;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(userId);
		builder.append(", ");
		builder.append(userPw);
		builder.append(", ");
		builder.append(userName);
		builder.append(", ");
		builder.append(grade);
		return builder.toString();
	}
	
	
}
