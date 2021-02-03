package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the t_wd_domain database table.
 * 
 */
@Entity
@Table(name="t_wd_domain")
@NamedQuery(name="TWdDomain.findAll", query="SELECT t FROM TWdDomain t")
public class TWdDomain extends com.metasystem.common.CommonTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_WD_DOMAIN_DOMAINSN_GENERATOR", sequenceName="T_WD_WORD_WORD_SN_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="T_WD_DOMAIN_DOMAINSN_GENERATOR")
	@Column(name="domain_sn")
	private Integer domainSn;

	@Column(name="data_lt")
	private BigDecimal dataLt;

	@Column(name="data_type")
	private String dataType;

	@Column(name="dcmlpoint_lt")
	private BigDecimal dcmlpointLt;

	@Column(name="domain_cl")
	private String domainCl;

	@Column(name="domain_dc")
	private String domainDc;

	@Column(name="domain_en_abbr")
	private String domainEnAbbr;

	@Column(name="domain_en_nm")
	private String domainEnNm;

	@Column(name="domain_nm")
	private String domainNm;

	@Column(name="exprsn_fom")
	private String exprsnFom;

	@Column(name="perm_val_dc")
	private String permValDc;

	private String unit;

	public TWdDomain() {
	}

	public Integer getDomainSn() {
		return this.domainSn;
	}

	public void setDomainSn(Integer domainSn) {
		this.domainSn = domainSn;
	}

	public BigDecimal getDataLt() {
		return this.dataLt;
	}

	public void setDataLt(BigDecimal dataLt) {
		this.dataLt = dataLt;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public BigDecimal getDcmlpointLt() {
		return this.dcmlpointLt;
	}

	public void setDcmlpointLt(BigDecimal dcmlpointLt) {
		this.dcmlpointLt = dcmlpointLt;
	}

	public String getDomainCl() {
		return this.domainCl;
	}

	public void setDomainCl(String domainCl) {
		this.domainCl = domainCl;
	}

	public String getDomainDc() {
		return this.domainDc;
	}

	public void setDomainDc(String domainDc) {
		this.domainDc = domainDc;
	}

	public String getDomainEnAbbr() {
		return this.domainEnAbbr;
	}

	public void setDomainEnAbbr(String domainEnAbbr) {
		this.domainEnAbbr = domainEnAbbr;
	}

	public String getDomainEnNm() {
		return this.domainEnNm;
	}

	public void setDomainEnNm(String domainEnNm) {
		this.domainEnNm = domainEnNm;
	}

	public String getDomainNm() {
		return this.domainNm;
	}

	public void setDomainNm(String domainNm) {
		this.domainNm = domainNm;
	}

	public String getExprsnFom() {
		return this.exprsnFom;
	}

	public void setExprsnFom(String exprsnFom) {
		this.exprsnFom = exprsnFom;
	}

	public Date getModifyDt() {
		return this.modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getModifyId() {
		return this.modifyId;
	}

	public void setModifyId(String modifyId) {
		this.modifyId = modifyId;
	}

	public String getPermValDc() {
		return this.permValDc;
	}

	public void setPermValDc(String permValDc) {
		this.permValDc = permValDc;
	}

	public Date getRegistDt() {
		return this.registDt;
	}

	public void setRegistDt(Date registDt) {
		this.registDt = registDt;
	}

	public String getRegistId() {
		return this.registId;
	}

	public void setRegistId(String registId) {
		this.registId = registId;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}