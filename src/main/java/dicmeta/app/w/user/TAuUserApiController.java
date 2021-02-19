package dicmeta.app.w.user;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag( name = "TAuUserApiController", description = "코드")
@RestController
public class TAuUserApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TAuUserRepository userRepository;

	@Operation(summary = "사용자 목록 조회", description = "검색 값으로 페이징된 사용자 목록 화면을 호출한다.")
	@GetMapping("/users")
	public Page<TAuUser> list( @RequestParam Map<String,Object> param,
			@RequestParam(name = "perPage", required = true, defaultValue = "20") int perPage,
			@RequestParam(name = "page", required = true, defaultValue = "1") int page) throws Exception {
		Page<TAuUser> list;
		param.forEach((k,v)->logger.debug("key:" + k + "\tvalue:" +v));
		PageRequest pageRequest = PageRequest.of(page - 1, perPage, Sort.by(Direction.ASC, "userId"));
		if(param.get("userNm") != null && param.get("userNm").toString() != null) {
			list = (Page<TAuUser>) userRepository.findByUserNmContaining(param.get("userNm").toString(),pageRequest);
		} else {
			list = (Page<TAuUser>) userRepository.findAll(PageRequest.of(page - 1, perPage));
		}
		return list;
	}
	
	@Operation(summary = "사용자 조회", description = "단건 조회한다.")
	@GetMapping("/users/{userId}")
	public Optional<TAuUser> get( @PathVariable String userId ) throws Exception {

		Optional<TAuUser> user = userRepository.findById(userId);
		
		return user;
		
	}
	
	@Operation(summary = "사용자 저장", description = "사용자 저장한다.")
	@PutMapping("/users")
	public TAuUser put(@RequestBody TAuUser tAuUser) throws Exception {
		
		logger.debug("사용자 저장 호출 : {}", tAuUser);
		TAuUser user;
		user = userRepository.save(tAuUser);
		if (user == null) {
			logger.debug("저장시 오류발생");
		}
		return user;
		
	}
	
	@Operation(summary = "사용자 삭제", description = "사용자 삭제한다.")
	@DeleteMapping("/users/{userId}")
	public String delete(@PathVariable String userId) throws Exception {
		
		logger.debug("사용자 삭제 호출 : userId-"+  userId);
		userRepository.deleteById(userId);
		return "200";
		
	}
	

}
