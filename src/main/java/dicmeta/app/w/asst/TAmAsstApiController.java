package dicmeta.app.w.asst;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag( name = "TAmAsstApiController", description = "자산")
@RestController 
@RequestMapping(value="/api")
public class TAmAsstApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TAmAsstRepository asstRepository;

	@Operation(summary = "자산 목록 조회", description = "검색 값으로 페이징된 자산 목록 화면을 호출한다.")
	@GetMapping("/assts")
	public Page<TAmAsst> list( @RequestParam Map<String,Object> param,
			@RequestParam(name = "perPage", required = true, defaultValue = "20") int perPage,
			@RequestParam(name = "page", required = true, defaultValue = "1") int page) throws Exception {
		Page<TAmAsst> list;
		param.forEach((k,v)->logger.debug("key:" + k + "\tvalue:" +v));
		PageRequest pageRequest = PageRequest.of(page - 1, perPage, Sort.by(Direction.DESC, "asstSn"));
		if(param.get("asstNm") != null && !param.get("asstNm").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByAsstNmContaining(param.get("asstNm").toString(), pageRequest);
		} else if(param.get("asstAccntNov") != null && !param.get("asstAccntNov").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByAsstAccntNovContaining(param.get("asstAccntNov").toString(), pageRequest);
		} else if(param.get("asstAccntSclasNm") != null && !param.get("asstAccntSclasNm").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByAsstAccntSclasNmContaining(param.get("asstAccntSclasNm").toString(), pageRequest);
		} else if(param.get("locplcNm") != null && !param.get("locplcNm").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByLocplcNmContaining(param.get("locplcNm").toString(), pageRequest);
		} else if(param.get("psitnNm") != null && !param.get("psitnNm").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByPsitnNmContaining(param.get("psitnNm").toString(), pageRequest);
		} else if(param.get("frstAcqsYmd") != null && !param.get("frstAcqsYmd").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByFrstAcqsYmdContaining(param.get("frstAcqsYmd").toString(), pageRequest);
		} else {
			list = (Page<TAmAsst>) asstRepository.findAll(PageRequest.of(page - 1, perPage));
		}
		return list;
		
	}
	
	@Operation(summary = "공통 자산 목록 조회", description = "검색 값으로 페이징된 자산 목록 화면을 호출한다.")
	@GetMapping("/common/assts")
	public Page<TAmAsst> common_list( @RequestParam Map<String,Object> param,
			@RequestParam(name = "perPage", required = true, defaultValue = "50") int perPage,
			@RequestParam(name = "page", required = true, defaultValue = "1") int page) throws Exception {
		Page<TAmAsst> list;
		param.forEach((k,v)->logger.debug("key:" + k + "\tvalue:" +v));
		PageRequest pageRequest = PageRequest.of(page - 1, perPage, Sort.by(Direction.DESC, "asstSn"));
		if(param.get("asstNm") != null && !param.get("asstNm").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByAsstNmContaining(param.get("asstNm").toString(), pageRequest);
		} else if(param.get("asstAccntNov") != null && !param.get("asstAccntNov").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByAsstAccntNovContaining(param.get("asstAccntNov").toString(), pageRequest);
		} else if(param.get("asstAccntSclasNm") != null && !param.get("asstAccntSclasNm").toString().equals("")) {
			list = (Page<TAmAsst>) asstRepository.findByAsstAccntSclasNmContaining(param.get("asstAccntSclasNm").toString(), pageRequest);
		} else {
			list = (Page<TAmAsst>) asstRepository.findAll(PageRequest.of(page - 1, perPage));
		}
		return list;
		
	}
	
	
}
