package com.metasystem.word;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.metasystem.common.CommonTbl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor  //lombok : 파라미터가 없는 기본 생성자를 생성
@Getter @Setter //lombok 

@Entity(name="MT_WORD")
public class Word extends CommonTbl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MT_WORD_WORD_SN_SEQ")
	Integer wordSn;
	String word;
	String wordKr;
	String wordEn;
	String wordDesc;
	
	public Word(String word, String wordKr, String wordEn, String wordDesc) {
		this.word = word;
		this.wordKr = wordKr;
		this.wordEn = wordEn;
		this.wordDesc = wordDesc;
	}


}
