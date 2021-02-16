package dicmeta.app.w.term;

import java.io.Serializable;
import javax.persistence.*;

import dicmeta.app.common.CommonTbl;

import java.util.Date;


/**
 * The persistent class for the t_wd_term database table.
 * 
 */
@Entity
@Table(name="t_wd_term")
@NamedQuery(name="TWdTerm.findAll", query="SELECT t FROM TWdTerm t")
public class TWdTerm extends CommonTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_WD_TERM_TERMSN_GENERATOR", sequenceName="T_WD_TERM_TERM_SN_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_WD_TERM_TERMSN_GENERATOR")
	@Column(name="term_sn")
	private Integer termSn;

	@Column(name="data_fom")
	private String dataFom;

	@Column(name="domain_sn")
	private Integer domainSn;

	@Column(name="term_en_abbr")
	private String termEnAbbr;

	@Column(name="term_en_nm")
	private String termEnNm;

	@Column(name="term_nm")
	private String termNm;

	public TWdTerm() {
	}

	public Integer getTermSn() {
		return this.termSn;
	}

	public void setTermSn(Integer termSn) {
		this.termSn = termSn;
	}

	public String getDataFom() {
		return this.dataFom;
	}

	public void setDataFom(String dataFom) {
		this.dataFom = dataFom;
	}

	public Integer getDomainSn() {
		return this.domainSn;
	}

	public void setDomainSn(Integer domainSn) {
		this.domainSn = domainSn;
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

	public String getTermEnAbbr() {
		return this.termEnAbbr;
	}

	public void setTermEnAbbr(String termEnAbbr) {
		this.termEnAbbr = termEnAbbr;
	}

	public String getTermEnNm() {
		return this.termEnNm;
	}

	public void setTermEnNm(String termEnNm) {
		this.termEnNm = termEnNm;
	}

	public String getTermNm() {
		return this.termNm;
	}

	public void setTermNm(String termNm) {
		this.termNm = termNm;
	}

}