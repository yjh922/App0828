package org.sp.app0828.admin.controller;

import java.util.List;

import org.sp.app0828.model.product.TopCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//관리자 모드에서의 상품과 관련된 요청을 처리하는 하위 컨트롤러

//component-scan 태그의 검색대상 중 @Controller 이므로 자동으로 메모리에 생성
@Controller
public class ProductController {
	
	//느슨하게 보유하자
	@Autowired
	private TopCategoryDAO topCategoryDAO;
	
	@RequestMapping(value="/admin/product/registform", method=RequestMethod.GET)
	public ModelAndView getForm() {
		//3단계: 일시키기
		List topList=topCategoryDAO.selectAll();
		
		ModelAndView mav=new ModelAndView("admin/product/regist");
		//4단계: 가져갈 것이 있다면 무조건 저장
		mav.addObject("topList", topList);
	
		
		return mav;
	}
}
