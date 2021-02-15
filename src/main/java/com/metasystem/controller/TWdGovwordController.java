package com.metasystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @description : 데이터사전 화면 호출
 * @author 박이정
 * @since 2021.02.10
 * <pre>
 *  수정일             수정자              수정내용
 *  ----------  --------    ---------------------------
 *  2019.09.02  박이정             최초 생성
 * </pre>
 */
//@Api(description = "행정단어")
@Controller
public class TWdGovwordController {

	//@ApiOperation(value = "행정단어", notes = "검색 값으로 페이징된 행정단어 목록 화면을 호출한다.")
	@GetMapping("/govwords/page")
	public String govwords() throws Exception {
		return "govwords";
	}
}
