package com.work.spring40.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

	//--factory dao injection
	private FactoryDao factoryDao;
	
	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}
	
	/*로그인 parameter : String,String*/
	public String login(String id, String pw) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		String sql = "select * from users where userid=? and userpw=?";

		try {
			conn = factoryDao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();

			if (rs.next()) {
				return rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 회원 로그인 오류");
		} finally {
			factoryDao.close(conn, pstm);
		}
		return null;
	}
	/**로그인 파라미터:맵*/
	public Map<String,String> login(Map<String,String> map) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		String sql = "select * from users where userid=? and userpw=?";

		try {
			conn = factoryDao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, map.get("userId"));
			pstm.setString(2, map.get("userPw"));
			rs = pstm.executeQuery();

			if (rs.next()) {
				return map;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 회원 로그인 오류");
		} finally {
			factoryDao.close(conn, pstm);
		}
		return null;
	}
	
	/* 회원가입을 위한 insert */
	public int addUser(String id, String pw, String name, String grade) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql="insert into users values(?, ?, ?, ?)";
		try {
			con=factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, grade);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factoryDao.close(con, pstmt);
		}
		return 0;
	}
	
	//아이디 중복체크
	public boolean checkId(String id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String sql = "select * from users where userid = ?";

		try {
			conn = factoryDao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			return rs.next();
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 사번중복 조회 오류");
			
		}finally {
			factoryDao.close(conn, pstm,rs);
		}
		return false;
	}
	
	/**
	 * 계정 삭제
	 * @param eId
	 * @return
	 */
	public boolean delete(String userId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String sql = "delete from users where userid=?";

		try {
			conn = factoryDao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);

			rs = pstm.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 계정삭제 sql오류");
		}finally {
			factoryDao.close(conn, pstm);
		}
		return false;
	}

	

}
