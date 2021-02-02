package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_wd_word database table.
 * 
 */
@Entity
@Table(name="t_wd_word")
//@NamedQuery(name="TWdWord.findAll", query="SELECT t FROM TWdWord t")
public class TWdWord extends com.metasystem.common.CommonTbl { //implements Serializable {
	//private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_WD_WORD_WORDSN_GENERATOR", sequenceName="T_WD_WORD_WORD_SN_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="T_WD_WORD_WORDSN_GENERATOR")
	@Column(name="word_sn")
	private Integer wordSn;

	@Column(name="word_dc")
	private String wordDc;

	@Column(name="word_en_abbr")
	private String wordEnAbbr;

	@Column(name="word_en_nm")
	private String wordEnNm;

	@Column(name="word_nm")
	private String wordNm;

	public TWdWord(String wordNm, String wordEnAbbr, String wordEnNm, String wordDc) {
		this.wordNm = wordNm;
		this.wordEnAbbr = wordEnAbbr;
		this.wordEnNm = wordEnNm;
		this.wordDc = wordDc;
	}

	public Integer getWordSn() {
		return this.wordSn;
	}

	public void setWordSn(Integer wordSn) {
		this.wordSn = wordSn;
	}

	public String getWordDc() {
		return this.wordDc;
	}

	public void setWordDc(String wordDc) {
		this.wordDc = wordDc;
	}

	public String getWordEnAbbr() {
		return this.wordEnAbbr;
	}

	public void setWordEnAbbr(String wordEnAbbr) {
		this.wordEnAbbr = wordEnAbbr;
	}

	public String getWordEnNm() {
		return this.wordEnNm;
	}

	public void setWordEnNm(String wordEnNm) {
		this.wordEnNm = wordEnNm;
	}

	public String getWordNm() {
		return this.wordNm;
	}

	public void setWordNm(String wordNm) {
		this.wordNm = wordNm;
	}

}