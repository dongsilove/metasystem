package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_au_user database table.
 * 
 */
@Entity
@Table(name="t_au_user")
@NamedQuery(name="TAuUser.findAll", query="SELECT t FROM TAuUser t")
public class TAuUser extends com.metasystem.common.CommonTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="clsf_cd")
	private String clsfCd;

	@Column(name="ecny_ymd")
	private String ecnyYmd;

	@Column(name="user_nm")
	private String userNm;

	//bi-directional many-to-one association to TAuDept
	@ManyToOne
	@JoinColumn(name="dept_cd")
	private TAuDept TAuDept;

	public TAuUser() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClsfCd() {
		return this.clsfCd;
	}

	public void setClsfCd(String clsfCd) {
		this.clsfCd = clsfCd;
	}

	public String getEcnyYmd() {
		return this.ecnyYmd;
	}

	public void setEcnyYmd(String ecnyYmd) {
		this.ecnyYmd = ecnyYmd;
	}

	public String getUserNm() {
		return this.userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public TAuDept getTAuDept() {
		return this.TAuDept;
	}

	public void setTAuDept(TAuDept TAuDept) {
		this.TAuDept = TAuDept;
	}

}