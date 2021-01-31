package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mt_domain database table.
 * 
 */
@Entity
@Table(name="mt_domain")
@NamedQuery(name="MtDomain.findAll", query="SELECT m FROM MtDomain m")
public class MtDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MT_DOMAIN_DOMAINSN_GENERATOR", sequenceName="MT_DOMAIN_DOMAIN_SN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MT_DOMAIN_DOMAINSN_GENERATOR")
	@Column(name="domain_sn")
	private Integer domainSn;

	@Column(name="data_type")
	private String dataType;

	@Column(name="domain_desc")
	private String domainDesc;

	@Column(name="domain_en")
	private String domainEn;

	@Column(name="domain_kr")
	private String domainKr;

	@Column(name="domain_len")
	private Integer domainLen;

	@Column(name="point_place")
	private Integer pointPlace;

	@Column(name="reg_dt")
	private Timestamp regDt;

	@Column(name="reg_id")
	private String regId;

	@Column(name="upd_dt")
	private Timestamp updDt;

	@Column(name="upd_id")
	private String updId;

	//bi-directional many-to-one association to MtTerm
	@OneToMany(mappedBy="mtDomain")
	private List<MtTerm> mtTerms;

	public MtDomain() {
	}

	public Integer getDomainSn() {
		return this.domainSn;
	}

	public void setDomainSn(Integer domainSn) {
		this.domainSn = domainSn;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDomainDesc() {
		return this.domainDesc;
	}

	public void setDomainDesc(String domainDesc) {
		this.domainDesc = domainDesc;
	}

	public String getDomainEn() {
		return this.domainEn;
	}

	public void setDomainEn(String domainEn) {
		this.domainEn = domainEn;
	}

	public String getDomainKr() {
		return this.domainKr;
	}

	public void setDomainKr(String domainKr) {
		this.domainKr = domainKr;
	}

	public Integer getDomainLen() {
		return this.domainLen;
	}

	public void setDomainLen(Integer domainLen) {
		this.domainLen = domainLen;
	}

	public Integer getPointPlace() {
		return this.pointPlace;
	}

	public void setPointPlace(Integer pointPlace) {
		this.pointPlace = pointPlace;
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

	public List<MtTerm> getMtTerms() {
		return this.mtTerms;
	}

	public void setMtTerms(List<MtTerm> mtTerms) {
		this.mtTerms = mtTerms;
	}

	public MtTerm addMtTerm(MtTerm mtTerm) {
		getMtTerms().add(mtTerm);
		mtTerm.setMtDomain(this);

		return mtTerm;
	}

	public MtTerm removeMtTerm(MtTerm mtTerm) {
		getMtTerms().remove(mtTerm);
		mtTerm.setMtDomain(null);

		return mtTerm;
	}

}