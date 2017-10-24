package work.controller;

import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import work.service.MemberService;
import work.vo.MemberVO;

@Controller
public class MemberController {    
	private Log log = LogFactory.getLog(getClass());	
	private MemberService service;
	  
	public MemberController(){}
	public void setService(MemberService service){
		this.service = service;
		log.debug("service di:"+service);
	}
	
	@RequestMapping(value="/member.do", method=RequestMethod.POST)  
	public ModelAndView member(MemberVO member, HttpServletRequest request) throws Exception{
		System.out.println("\n### member.do");
		
		HashMap map = new HashMap();
		map.put("point", 1000); 
		map.put("info", member.getId()); 
		
		service.registerMemberInfo(member, map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("info", "회원가입이 완료되었습니다. 로그인후 회원서비스를 이용하시기 바랍니다.");
		mv.setViewName("register_ok");
		return mv;
	}	

	@RequestMapping("/login.do")  
	public ModelAndView login(@RequestParam Map<String, String> map) throws Exception{
		String name = service.login(map);
		
		ModelAndView mv = new ModelAndView();
		if(name != null) {
			mv.addObject("info", "사용자 인증이 완료되었습니다. 회원 서비스를 이용하실수 있습니다.");
			mv.addObject("user", name);
			mv.setViewName("success");
		} else {
			//mv.addObject("message", "로그인 정보를 다시 확인하시기 바랍니다.");
			//mv.setViewName("error");
			throw new AuthenticationException("회원정보를 다시 확인하시기 바랍니다.");
		}
		return mv;
	}	
	
	@RequestMapping("/joinView.do")  
	public String joinView(){	
		return "/join";
	}	

	@RequestMapping("/loginView.do")  
	public String loginView(){	
		return "/login";
	}	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception){
		exception.printStackTrace();		
		return "/error";
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public String authenticationException(AuthenticationException exception) {
		exception.printStackTrace();		
		return "/errorLogin";
	}

}