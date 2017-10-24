package com.work.spring40.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class FactoryDao {

	private Map dbserver;
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	private FactoryDao() {}
	
	//싱글톤 패턴
	private static FactoryDao factoryDao ;
		
	public static FactoryDao getInstance() {
		if(factoryDao == null) {
			factoryDao = new FactoryDao();
		}
		return factoryDao;
	}
	
	private FactoryDao(Map dbserver) {
		this.dbserver = dbserver;      
	      driver = dbserver.get("driver").toString();
	      url = dbserver.get("url").toString();
	      username = dbserver.get("username").toString();
	      password = dbserver.get("password").toString();
	      try {         
	         Class.forName(dbserver.get("driver").toString() );   
	      } catch (ClassNotFoundException e) {      
	         e.printStackTrace();
	      }
	}
	
	public static FactoryDao getInstance(Map dbserver) {
		if(factoryDao == null){
			factoryDao = new FactoryDao(dbserver);
		}
		return factoryDao;
	}
	
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("DB서버 연결오류");
		}
		return null;
	}
	
	//cud
	/**
	 * cud 자원해제 메서드
	 * @param conn
	 * @param stmt
	 */
	public void close(Connection conn , Statement stmt) {
		close(conn,stmt,null);
	}
	
	
	/**
	 * select 자원해제
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void close(Connection conn , Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {	
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("error : 자원해제 오류");
		}
	}
	
}
