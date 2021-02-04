package com.metasystem.domain;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metasystem.repository.TWdGovwordRepository;
import com.metasystem.repository.TWdWordRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // 통합테스트를 위한 어노테이션
public class WordRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	TWdWordRepository tWdWordRepository;
	@Autowired 
	TWdGovwordRepository govwordRepository;
	 
	
	@Test
	public void name() throws Exception {
		assertEquals("hello", "hello");
	}
	
	
	@Test @Ignore
	public void save() throws Exception { 
		TWdWord tWdWord = new TWdWord("ASST","자산", "ASSET", "자산" ); 
		tWdWordRepository.save(tWdWord); 
	}
	 
	@Test 
	public void list() throws Exception { 
		List<TWdGovword> list = (List<TWdGovword>) govwordRepository.findAll();
		logger.info("govlist={}", list.size());
	}
	
}
