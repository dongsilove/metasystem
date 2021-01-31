package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mt_word database table.
 * 
 */
@Entity
@Table(name="mt_word")
@NamedQuery(name="MtWord.findAll", query="SELECT m FROM MtWord m")
public class MtWord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MT_WORD_WORDSN_GENERATOR", sequenceName="MT_WORD_WORD_SN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MT_WORD_WORDSN_GENERATOR")
	@Column(name="word_sn")
	private Integer wordSn;

	@Column(name="reg_dt")
	private Timestamp regDt;

	@Column(name="reg_id")
	private String regId;

	@Column(name="upd_dt")
	private Timestamp updDt;

	@Column(name="upd_id")
	private String updId;

	private String word;

	@Column(name="word_desc")
	private String wordDesc;

	@Column(name="word_en")
	private String wordEn;

	@Column(name="word_kr")
	private String wordKr;

	public MtWord() {
	}

	public Integer getWordSn() {
		return this.wordSn;
	}

	public void setWordSn(Integer wordSn) {
		this.wordSn = wordSn;
	}

	public Timestamp getRegDt() {
		return this.regDt;
	}

	public void setRegDt(Timestamp regDt) {
		this.regDt = regDt;
	}

	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Timestamp getUpdDt() {
		return this.updDt;
	}

	public void setUpdDt(Timestamp updDt) {
		this.updDt = updDt;
	}

	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordDesc() {
		return this.wordDesc;
	}

	public void setWordDesc(String wordDesc) {
		this.wordDesc = wordDesc;
	}

	public String getWordEn() {
		return this.wordEn;
	}

	public void setWordEn(String wordEn) {
		this.wordEn = wordEn;
	}

	public String getWordKr() {
		return this.wordKr;
	}

	public void setWordKr(String wordKr) {
		this.wordKr = wordKr;
	}

}