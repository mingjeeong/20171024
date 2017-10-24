package work.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import work.dao.MemberDao;
import work.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private Log log = LogFactory.getLog(getClass());
	private MemberDao dao;
	
	public MemberServiceImpl(){
		System.out.println("MemberServiceImpl() constructor");
	}
	public void setDao(MemberDao dao) {		
		this.dao = dao;
		log.info("dao injection-->"+dao);
	}
	
	public void registerMemberInfo(MemberVO vo, HashMap map) throws SQLException{
		// 회원 등록
		dao.registerMember(vo);
		// 포인트 누적
		dao.registerMemberPoint(map);		
	}	
	
	public String login(Map map) throws SQLException {
		return dao.login(map);
	}	
}