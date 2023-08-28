package org.sp.app0828.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sp.app0828.domain.Admin;
import org.sp.app0828.model.admin.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//관리자와 관련된 로그인 요청을 처리하는 하위 컨트롤러
@Controller
public class LoginController {
	//이 객체의 인스턴스는 개발자가 집접 생성하지 않는다.
	//왜? 스프링을 지배하는 원리 중 DI 적용을 위해
	//DI(Dependency injection)
	@Autowired
	private AdminDAO adminDAO;
	
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	//로그인 폼 요청 처리
	@RequestMapping(value="/admin/loginform", method=RequestMethod.GET)
	public ModelAndView getForm() {
		//3단계: 생략 (업무없다)
		//4단계: 페이지명 등록
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/loginform");
		
		return mav;
	}
	
	//로그인 요청 처리
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public ModelAndView login(Admin admin, HttpServletRequest request) {
		//3단계: 로직 객체에 일 시킨다.
		System.out.println("로그인 요청함");
		Admin obj=adminDAO.login(admin);//로그인 검증처리
		
		ModelAndView mav = new ModelAndView();
		
		//obj가  null이면 로그인 정보가 실패
		if(obj==null) {
			mav.addObject("msg", "로그인 정보가 올바르지 않습니다");
			mav.setViewName("error/result");
		}else {
			//obj가 채워져 있다면 로그인 성공 세션에 DTO 담기
			HttpSession session=request.getSession();//이 요청과 관련된 세션 얻기
			session.setAttribute("admin", obj);
			mav.setViewName("admin/index");//성공하면 관리자 메인페이지
		}
		
		return mav;
	}
}












