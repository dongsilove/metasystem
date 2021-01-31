package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cm_code database table.
 * 
 */
@Entity
@Table(name="cm_code")
@NamedQuery(name="CmCode.findAll", query="SELECT c FROM CmCode c")
public class CmCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cd;

	@Column(name="cd_nm")
	private String cdNm;

	//bi-directional many-to-one association to CmCodeGrp
	@ManyToOne
	@JoinColumn(name="grp_cd")
	private CmCodeGrp cmCodeGrp;

	public CmCode() {
	}

	public String getCd() {
		return this.cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCdNm() {
		return this.cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public CmCodeGrp getCmCodeGrp() {
		return this.cmCodeGrp;
	}

	public void setCmCodeGrp(CmCodeGrp cmCodeGrp) {
		this.cmCodeGrp = cmCodeGrp;
	}

}