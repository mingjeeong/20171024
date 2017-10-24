package com.work.spring40;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring40.model.User;
import com.work.spring40.service.UserService;
import com.work.spring40.service.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//--Service setter injection
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home.do",  method = RequestMethod.GET) //GET POST 
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message","안녕하세요!!:)");
		return "home";
	}
	
	@RequestMapping("loginView.do")
	public String loginView() {
		//환경설정 jsp 베이스폴더설정
		//WEB-INF/views/user/login.jsp
		return "user/Login";
	}
	
	@RequestMapping("joinView.do")
	public String joinView() {
		//환경설정 jsp 베이스폴더설정
		//WEB-INF/views/user/join.jsp
		return "user/Join";
	}
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	   public ModelAndView login(HttpSession session, @RequestParam Map<String, String> map) {
	      System.out.println("\n>>> login() : "+map);
	      
	      //서비스 로그인 검증 요청
	      //세션객체생성 및 필요한 사용자 인증정보 설정
	      System.out.println(session.isNew()+" : "+session.getId());
	      
	      //응답데이터 설정 및 페이지 이동 위한 객체 생성 : ModelAndView
	      ModelAndView mv = new ModelAndView();
	      
	      if(map.get("userId") == null || map.get("userId").trim().length() == 0
	         || map.get("userPw") == null || map.get("userPw").trim().length() == 0) {
	         //결과 : 인증실패 => 실패 페이지 이동
	         mv.addObject("errorMessage", "아이디, 비밀번호 모두 입력해주세요");
	         mv.setViewName("user/Error");
	      } else {
	         //결과 : 인증성공 => 성공 페이지 이동
	         //데이터 설정
		    	  if(userService.login(map)!=null) {
		         session.setAttribute("userId", map.get("userId"));
		         mv.addObject("userId", map.get("userId"));
		         mv.addObject("successMessage", "환영합니다!");
		         //이동위한 응답페이지 객체 설정
		         mv.setViewName("user/MainService");
	    	  }else {
	    		  mv.addObject("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다");
	    		  mv.setViewName("user/Error");
	    	  }
	    	  
	      }
	      return mv;
	   }
	
	@RequestMapping("join.do")
	public ModelAndView join(String userId, String userPw, String userName, @RequestParam(value="grade", required=true) String grade ) {
		System.out.println("\n>>>join() : id: "+userId+" pw: "+userPw+" name: "+userName+" grade: "+grade);
		int result =userService.addUser(userId, userPw, userName, grade);
		ModelAndView mv = new ModelAndView();
		if(result!=0) {
			 mv.addObject("successMessage", "회원가입 완료");
			 mv.setViewName("user/Service");
			
		}else if(userId.trim().length()==0 || userId==null||userPw.trim().length()==0 || userPw==null||userName.trim().length()==0 || userName==null||grade.trim().length()==0 || grade==null ) {
			mv.addObject("errorMessage", "회원가입 실패 : 아이디, 비밀번호, 이름, 등급 모두 입력해주세요");
	        mv.setViewName("user/Error");
		}else {
			mv.addObject("errorMessage", "회원가입 실패 : 아이디 중복");
	        mv.setViewName("user/Error");
		}
		
		return mv;
	}
	@RequestMapping("delete.do")
	public ModelAndView delete(HttpSession session,String userId) {
		System.out.println(">>>delete()");
		ModelAndView mv = new ModelAndView();
		boolean result =userService.delete(userId);
		if(result) {
			 mv.addObject("successMessage", "계정이 삭제되었습니다");
			 mv.setViewName("user/Service");
		}
		return mv;
	}
	@RequestMapping("showInfo.do")
	public void showInfo() {
		
	}
}
