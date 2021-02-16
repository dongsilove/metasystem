package dicmeta.app.w.domain;

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

@Tag( name = "TWdDomainRestController", description = "도메인")
@RestController
public class TWdDomainApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TWdDomainRepository domainRepository;

	@Operation(summary = "도메인 목록 조회", description = "검색 값으로 페이징된 도메인 목록 화면을 호출한다.")
	@GetMapping("/domains")
	public Page<TWdDomain> list( @RequestParam Map<String,Object> param,
			@RequestParam(name = "perPage", required = true, defaultValue = "20") int perPage,
			@RequestParam(name = "page", required = true, defaultValue = "1") int page) throws Exception {
		
		Page<TWdDomain> list;
		param.forEach((k,v)->logger.debug("key:" + k + "\tvalue:" +v));
		PageRequest pageRequest = PageRequest.of(page - 1, perPage, Sort.by(Direction.DESC, "domainSn"));
		if(param.get("domainNm") != null && param.get("domainNm").toString() != null) {
			list = (Page<TWdDomain>) domainRepository.findByDomainNmContaining(param.get("domainNm").toString(),pageRequest);
		} else if(param.get("domainEnAbbr") != null && param.get("domainEnAbbr").toString() != null) {
			list = (Page<TWdDomain>) domainRepository.findByDomainEnAbbrContaining(param.get("domainEnAbbr").toString(),pageRequest);
		} else if(param.get("domainEnNm") != null && param.get("domainEnNm").toString() != null) {
			list = (Page<TWdDomain>) domainRepository.findByDomainEnNmContaining(param.get("domainEnNm").toString(),pageRequest);
		} else {
			list = (Page<TWdDomain>) domainRepository.findAll(pageRequest);
		}
		return list;
		
	}
	
	@Operation(summary = "도메인 조회", description = "도메인 단건 조회한다.")
	@GetMapping("/domains/{domainSn}")
	public Optional<TWdDomain> get( @PathVariable Integer domainSn) throws Exception {

		Optional<TWdDomain> domain = domainRepository.findById(domainSn);
		
		return domain;
		
	}
	
	@Operation(summary = "도메인 저장", description = "도메인 저장한다.")
	@PutMapping("/domains")
	public TWdDomain put(@RequestBody TWdDomain tWdDomain) throws Exception {
		
		logger.debug("도메인 저장 호출 : {}", tWdDomain);
		TWdDomain domain;
		domain = domainRepository.save(tWdDomain);
		if (domain == null) {
			logger.debug("저장시 오류발생");
		}
		return domain;
		
	}
	
	@Operation(summary = "도메인 삭제", description = "도메인 삭제한다.")
	@DeleteMapping("/domains/{domainSn}")
	public String delete(@PathVariable Integer domainSn) throws Exception {
		
		logger.debug("도메인 삭제 호출 :"+  Integer.toString(domainSn));
		domainRepository.deleteById(domainSn);
		return "200";
		
	}
	
	
}
