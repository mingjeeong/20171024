package work.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import work.vo.MemberVO;

public class MemberDaoImpl extends SqlMapClientDaoSupport implements MemberDao{
	private Log log = LogFactory.getLog(getClass());
	
	public MemberDaoImpl(){}

	public void registerMember(MemberVO vo) throws SQLException {
		getSqlMapClientTemplate().insert("member.insertMember", vo);		
	}
	public void registerMemberPoint(HashMap map) throws SQLException {
		getSqlMapClientTemplate().insert("memberpoint.insertMemPoint", map);		
	}
	public String login(Map map) throws SQLException {
		return (String)getSqlMapClientTemplate().queryForObject("member.login", map);
	}
}            