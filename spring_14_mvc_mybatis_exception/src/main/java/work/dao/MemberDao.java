package work.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import work.vo.MemberVO;


public interface MemberDao {	
	public void registerMember(MemberVO vo) throws SQLException;	
	public void registerMemberPoint(HashMap map) throws SQLException;
	public String login(Map map) throws SQLException;
}