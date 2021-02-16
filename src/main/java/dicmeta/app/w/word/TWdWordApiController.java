package dicmeta.app.w.word;

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

@Tag( name = "TWdWordApiController", description = "단어")
@RestController
public class TWdWordApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TWdWordRepository wordRepository;

	@Operation(summary = "단어 목록 조회", description = "검색 값으로 페이징된 단어 목록 화면을 호출한다.")
	@GetMapping("/words")
	public Page<TWdWord> list( @RequestParam Map<String,Object> param,
			@RequestParam(name = "perPage", required = true, defaultValue = "20") int perPage,
			@RequestParam(name = "page", required = true, defaultValue = "1") int page) throws Exception {
		
		Page<TWdWord> list;
		param.forEach((k,v)->logger.debug("key:" + k + "\tvalue:" +v));
		PageRequest pageRequest = PageRequest.of(page - 1, perPage, Sort.by(Direction.DESC, "wordSn"));
		if(param.get("wordNm") != null && param.get("wordNm").toString() != null) {
			list = (Page<TWdWord>) wordRepository.findByWordNmContaining(param.get("wordNm").toString(),pageRequest);
		} else if(param.get("wordEnAbbr") != null && param.get("wordEnAbbr").toString() != null) {
			list = (Page<TWdWord>) wordRepository.findByWordEnAbbrContaining(param.get("wordEnAbbr").toString(),pageRequest);
		} else if(param.get("wordEnNm") != null && param.get("wordEnNm").toString() != null) {
			list = (Page<TWdWord>) wordRepository.findByWordEnNmContaining(param.get("wordEnNm").toString(),pageRequest);
		} else {
			list = (Page<TWdWord>) wordRepository.findAll(pageRequest);
		}
		return list;
		
	}
	
	@Operation(summary = "단어 조회", description = "단어 단건 조회한다.")
	@GetMapping("/words/{wordSn}")
	public Optional<TWdWord> get( @PathVariable Integer wordSn) throws Exception {

		Optional<TWdWord> word = wordRepository.findById(wordSn);
		
		return word;
		
	}
	
	@Operation(summary = "단어 저장", description = "단어 저장한다.")
	@PutMapping("/words")
	public TWdWord put(@RequestBody TWdWord tWdWord) throws Exception {
		
		logger.debug("단어 저장 호출 : {}", tWdWord);
		TWdWord word;
		word = wordRepository.save(tWdWord);
		if (word == null) {
			logger.debug("저장시 오류발생");
		}
		return word;
		
	}
	
	@Operation(summary = "단어 삭제", description = "단어 삭제한다.")
	@DeleteMapping("/words/{wordSn}")
	public String delete(@PathVariable Integer wordSn) throws Exception {
		
		logger.debug("단어 삭제 호출 :"+  Integer.toString(wordSn));
		wordRepository.deleteById(wordSn);
		return "200";
		
	}
	
	
}
