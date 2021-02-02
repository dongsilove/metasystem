package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_cm_cd_grp database table.
 * 
 */
@Entity
@Table(name="t_cm_cd_grp")
@NamedQuery(name="TCmCdGrp.findAll", query="SELECT t FROM TCmCdGrp t")
public class TCmCdGrp extends com.metasystem.common.CommonTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="grp_cd")
	private String grpCd;

	@Column(name="grp_cd_nm")
	private String grpCdNm;

	public TCmCdGrp() {
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

}