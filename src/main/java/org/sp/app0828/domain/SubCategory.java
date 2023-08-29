package org.sp.app0828.domain;

import lombok.Data;

@Data
public class SubCategory {
	private int subcategory_idx;
	
	//db 분야에서는 부모의 foreign key만 있으면 부몰ㄹ 참조할 수 있지만
	//java에서는 특정 객체를 찾아가려면 반드시 주소값
	private TopCategory topCategory;
	private String sub_name;
}
