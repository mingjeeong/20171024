package work.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import work.dao.MemberDao;
import work.vo.MemberVO;

public interface MemberService {	
	public void setDao(MemberDao dao);
	public void registerMemberInfo(MemberVO vo, HashMap map) throws SQLException;	
	public String login(Map map) throws SQLException;	
}