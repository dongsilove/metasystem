package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_wd_aply database table.
 * 
 */
@Entity
@Table(name="t_wd_aply")
@NamedQuery(name="TWdAply.findAll", query="SELECT t FROM TWdAply t")
public class TWdAply extends com.metasystem.common.CommonTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_WD_APLY_APLYSN_GENERATOR", sequenceName="T_WD_APLY_APLY_SN_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="T_WD_APLY_APLYSN_GENERATOR")
	@Column(name="aply_sn")
	private Integer aplySn;

	@Column(name="aply_knd")
	private String aplyKnd;

	@Temporal(TemporalType.DATE)
	@Column(name="confm_dt")
	private Date confmDt;

	@Column(name="confm_id")
	private String confmId;

	@Column(name="confm_sttus")
	private String confmSttus;

	@Column(name="domain_sn")
	private Integer domainSn;

	@Column(name="term_sn")
	private Integer termSn;

	@Column(name="word_sn")
	private Integer wordSn;

	public TWdAply() {
	}

	public Integer getAplySn() {
		return this.aplySn;
	}

	public void setAplySn(Integer aplySn) {
		this.aplySn = aplySn;
	}

	public String getAplyKnd() {
		return this.aplyKnd;
	}

	public void setAplyKnd(String aplyKnd) {
		this.aplyKnd = aplyKnd;
	}

	public Date getConfmDt() {
		return this.confmDt;
	}

	public void setConfmDt(Date confmDt) {
		this.confmDt = confmDt;
	}

	public String getConfmId() {
		return this.confmId;
	}

	public void setConfmId(String confmId) {
		this.confmId = confmId;
	}

	public String getConfmSttus() {
		return this.confmSttus;
	}

	public void setConfmSttus(String confmSttus) {
		this.confmSttus = confmSttus;
	}

	public Integer getDomainSn() {
		return this.domainSn;
	}

	public void setDomainSn(Integer domainSn) {
		this.domainSn = domainSn;
	}

//	public Date getRegistDt() {
//		return this.registDt;
//	}
//
//	public void setRegistDt(Date registDt) {
//		this.registDt = registDt;
//	}
//
//	public String getRegistId() {
//		return this.registId;
//	}
//
//	public void setRegistId(String registId) {
//		this.registId = registId;
//	}

	public Integer getTermSn() {
		return this.termSn;
	}

	public void setTermSn(Integer termSn) {
		this.termSn = termSn;
	}

	public Integer getWordSn() {
		return this.wordSn;
	}

	public void setWordSn(Integer wordSn) {
		this.wordSn = wordSn;
	}

}