package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the au_user database table.
 * 
 */
@Entity
@Table(name="au_user")
@NamedQuery(name="AuUser.findAll", query="SELECT a FROM AuUser a")
public class AuUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="hire_date")
	private String hireDate;

	@Column(name="position_cd")
	private String positionCd;

	@Column(name="user_nm")
	private String userNm;

	//bi-directional many-to-one association to AuDept
	@ManyToOne
	@JoinColumn(name="dept_cd")
	private AuDept auDept;

	public AuUser() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getPositionCd() {
		return this.positionCd;
	}

	public void setPositionCd(String positionCd) {
		this.positionCd = positionCd;
	}

	public String getUserNm() {
		return this.userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public AuDept getAuDept() {
		return this.auDept;
	}

	public void setAuDept(AuDept auDept) {
		this.auDept = auDept;
	}

}