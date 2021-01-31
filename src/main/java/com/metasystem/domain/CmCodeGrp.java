package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cm_code_grp database table.
 * 
 */
@Entity
@Table(name="cm_code_grp")
@NamedQuery(name="CmCodeGrp.findAll", query="SELECT c FROM CmCodeGrp c")
public class CmCodeGrp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="grp_cd")
	private String grpCd;

	@Column(name="grp_cd_nm")
	private String grpCdNm;

	//bi-directional many-to-one association to CmCode
	@OneToMany(mappedBy="cmCodeGrp")
	private List<CmCode> cmCodes;

	public CmCodeGrp() {
	}

	public String getGrpCd() {
		return this.grpCd;
	}

	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}

	public String getGrpCdNm() {
		return this.grpCdNm;
	}

	public void setGrpCdNm(String grpCdNm) {
		this.grpCdNm = grpCdNm;
	}

	public List<CmCode> getCmCodes() {
		return this.cmCodes;
	}

	public void setCmCodes(List<CmCode> cmCodes) {
		this.cmCodes = cmCodes;
	}

	public CmCode addCmCode(CmCode cmCode) {
		getCmCodes().add(cmCode);
		cmCode.setCmCodeGrp(this);

		return cmCode;
	}

	public CmCode removeCmCode(CmCode cmCode) {
		getCmCodes().remove(cmCode);
		cmCode.setCmCodeGrp(null);

		return cmCode;
	}

}