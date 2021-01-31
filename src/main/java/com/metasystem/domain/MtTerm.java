package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mt_term database table.
 * 
 */
@Entity
@Table(name="mt_term")
@NamedQuery(name="MtTerm.findAll", query="SELECT m FROM MtTerm m")
public class MtTerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MT_TERM_TERMSN_GENERATOR", sequenceName="MT_TERM_TERM_SN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MT_TERM_TERMSN_GENERATOR")
	@Column(name="term_sn")
	private Integer termSn;

	@Column(name="ap_var_nm")
	private String apVarNm;

	@Column(name="data_type_len")
	private String dataTypeLen;

	@Column(name="reg_dt")
	private Timestamp regDt;

	@Column(name="reg_id")
	private String regId;

	private String term;

	@Column(name="term_en_compo")
	private String termEnCompo;

	@Column(name="term_kr")
	private String termKr;

	@Column(name="term_kr_compo")
	private String termKrCompo;

	@Column(name="upd_dt")
	private Timestamp updDt;

	@Column(name="upd_id")
	private String updId;

	//bi-directional many-to-one association to MtDomain
	@ManyToOne
	@JoinColumn(name="domain_sn")
	private MtDomain mtDomain;

	public MtTerm() {
	}

	public Integer getTermSn() {
		return this.termSn;
	}

	public void setTermSn(Integer termSn) {
		this.termSn = termSn;
	}

	public String getApVarNm() {
		return this.apVarNm;
	}

	public void setApVarNm(String apVarNm) {
		this.apVarNm = apVarNm;
	}

	public String getDataTypeLen() {
		return this.dataTypeLen;
	}

	public void setDataTypeLen(String dataTypeLen) {
		this.dataTypeLen = dataTypeLen;
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

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTermEnCompo() {
		return this.termEnCompo;
	}

	public void setTermEnCompo(String termEnCompo) {
		this.termEnCompo = termEnCompo;
	}

	public String getTermKr() {
		return this.termKr;
	}

	public void setTermKr(String termKr) {
		this.termKr = termKr;
	}

	public String getTermKrCompo() {
		return this.termKrCompo;
	}

	public void setTermKrCompo(String termKrCompo) {
		this.termKrCompo = termKrCompo;
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

	public MtDomain getMtDomain() {
		return this.mtDomain;
	}

	public void setMtDomain(MtDomain mtDomain) {
		this.mtDomain = mtDomain;
	}

}