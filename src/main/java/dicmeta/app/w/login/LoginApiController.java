package dicmeta.app.w.login;


import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dicmeta.app.util.CryptoUtil;

import dicmeta.app.w.user.TAuUser;
import dicmeta.app.w.user.TAuUserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag( name = "LoginApiController", description = "로그인")
@RestController
@RequestMapping(value="/api/login")
public class LoginApiController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TAuUserRepository userRepository;
	
	@Operation(summary = "로그아웃", description = "로그아웃 처리한다.")
	@PostMapping(value="/logout")
	public HttpStatus logout(HttpSession session) throws Exception {

		session.invalidate();

		return HttpStatus.OK;
		
	}

	@Operation(summary = "로그인", description = "로그인 정보를 session에 저장한다.")
	@PostMapping("/login")
	public String actionLoginNew(@RequestParam Map<String, Object> params,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception {
		
		params.forEach((k,v)->logger.debug("params key : " + k + " value : " + v)); // - 파라메터 디버깅
		if (params.get("userId") == null || params.get("pwd") == null) return "600|parameter no exist "; // parameter 오류
		
		int loginTryCnt = 1;
		String loginTryId = (String)session.getAttribute("loginTryId"); // 로그인시도횟수
			
		// session에 저장된 TAuUser 가져오기
		TAuUser loginInfo = dicmeta.app.util.SessionUtil.getLoginInfo(request);
		if(loginInfo != null && loginInfo.getUserId().equals(params.get("userId").toString())){ // 이미 로그인되어 있다면
			return "200"; // already loginned
		}

		// 로그인횟수 점검 5회이상일 경우 5분후 재시도 권장
		if (loginTryId == null) {
			session.setAttribute("loginTryId", params.get("userId").toString());
			session.setAttribute("loginTryCnt", 1);
			logger.info("loginTryId == null");
		} else {
			if (!loginTryId.equals(params.get("userId").toString())) {
				session.setAttribute("loginTryId", params.get("userId").toString());
				session.setAttribute("loginTryCnt", 1);
				logger.info("!loginTryId.equals(userId)");
			} else {
				loginTryCnt = (int)session.getAttribute("loginTryCnt");
				session.setAttribute("loginTryCnt", ++loginTryCnt);
				
				if (loginTryCnt > 5) {
					session.setMaxInactiveInterval(5*60); // 5분
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<script type=\'text/javascript'>");
					out.println("alert('로그인 시도 횟수(5회)가 초과되었습니다. 5분 후 재시도 하세요.');");
					out.println("location.href = '/login/page.do';");
					out.println("</script>");
					return null;					
				}
			}
		}
		
		// 일반 로그인 처리
		String pwd = (String)params.get("pwd");
		String userId = (String)params.get("userId");
		Optional<TAuUser> optUser = userRepository.findById(userId);
		
		if(optUser.isPresent()) {
			TAuUser rsltUser = optUser.get();
			String resultPwd = rsltUser.getPwd();
			String resultSalt = rsltUser.getPwdSalt();
			String encryptPwd = CryptoUtil.encryptSHA256salt(pwd,resultSalt); // parameter pwd암호화
			if (resultPwd.equals(encryptPwd)) { // DB의 비밀번호와 암호화비밀번호가 일치하면 
				
				session.setAttribute("loginId", userId); // session timeout 점검용
				session.setAttribute("loginDeptNm", rsltUser.gettAuDept().getDeptNm()); // 부서명
				
				session.setAttribute("loginInfo", rsltUser);
				

				//session.setMaxInactiveInterval(30); // SESSION TEST 위해 SESSION유지기간 30초로 설정
				return "200";
			} else { // 비밀번호 일치하지 않음.
				return "201|pwd is not equal";
			}
		} else { // 입력한 userId에 해당하는 사용자record 없음.
			return "201|TAuUser does not exist";
		}
			
		
		
	}
	
	@Operation(summary = "session만료", description = "session만료")
    @RequestMapping(value="/nosession")
	public String nosession(HttpSession session, HttpServletRequest request, HttpServletResponse resp) {
		String result = HttpStatus.UNAUTHORIZED + "|unauthorized access"; // 401
    	return result;
    }

}
