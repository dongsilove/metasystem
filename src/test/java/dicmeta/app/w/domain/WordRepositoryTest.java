package dicmeta.app.w.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dicmeta.app.w.code.TCmCode;
import dicmeta.app.w.code.TCmCodeRepository;
import dicmeta.app.w.govword.TWdGovword;
import dicmeta.app.w.govword.TWdGovwordRepository;
import dicmeta.app.w.word.TWdWord;
import dicmeta.app.w.word.TWdWordRepository;


@RunWith(SpringRunner.class)
@SpringBootTest // 통합테스트를 위한 어노테이션
public class WordRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	TCmCodeRepository codeRepository;
	
	@Autowired 
	TWdDomainRepository domainRepository;
	
	@Test  @Ignore
	public void list() throws Exception { 
		List<TCmCode> list =  codeRepository.findByGrpCd("WD004");
		logger.info("govlist={}", list.size());
	}
	
	@Test  
	public void save() throws Exception { 
		TWdDomain domain = new TWdDomain(new BigDecimal(200),"VARCHAR", "이름", "SYNONM","SYNONYM", "동의어"); 
		domainRepository.save(domain); 
	}

	@Test  @Ignore
	public void delete() throws Exception { 
		Integer domainSn = new Integer("92");;
		domainRepository.deleteById(domainSn); 
	}
	
}
