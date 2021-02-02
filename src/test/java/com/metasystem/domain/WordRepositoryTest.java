package com.metasystem.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metasystem.repository.TWdWordRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // 통합테스트를 위한 어노테이션
public class WordRepositoryTest {

	
	@Autowired 
	TWdWordRepository tWdWordRepository;
	 
	
	@Test
	public void name() throws Exception {
		assertEquals("hello", "hello");
	}
	
	
	@Test 
	public void save() throws Exception { 
		TWdWord tWdWord = new TWdWord("ASST","자산", "ASSET", "자산" ); 
		tWdWordRepository.save(tWdWord); 
	}
	 
}
