package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the au_dept database table.
 * 
 */
@Entity
@Table(name="au_dept")
@NamedQuery(name="AuDept.findAll", query="SELECT a FROM AuDept a")
public class AuDept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dept_cd")
	private String deptCd;

	@Column(name="dept_nm")
	private String deptNm;

	//bi-directional many-to-one association to AuDept
	@ManyToOne
	@JoinColumn(name="up_dept_cd")
	private AuDept auDept;

	//bi-directional many-to-one association to AuDept
	@OneToMany(mappedBy="auDept")
	private List<AuDept> auDepts;

	//bi-directional many-to-one association to AuUser
	@OneToMany(mappedBy="auDept")
	private List<AuUser> auUsers;

	public AuDept() {
	}

	public String getDeptCd() {
		return this.deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getDeptNm() {
		return this.deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public AuDept getAuDept() {
		return this.auDept;
	}

	public void setAuDept(AuDept auDept) {
		this.auDept = auDept;
	}

	public List<AuDept> getAuDepts() {
		return this.auDepts;
	}

	public void setAuDepts(List<AuDept> auDepts) {
		this.auDepts = auDepts;
	}

	public AuDept addAuDept(AuDept auDept) {
		getAuDepts().add(auDept);
		auDept.setAuDept(this);

		return auDept;
	}

	public AuDept removeAuDept(AuDept auDept) {
		getAuDepts().remove(auDept);
		auDept.setAuDept(null);

		return auDept;
	}

	public List<AuUser> getAuUsers() {
		return this.auUsers;
	}

	public void setAuUsers(List<AuUser> auUsers) {
		this.auUsers = auUsers;
	}

	public AuUser addAuUser(AuUser auUser) {
		getAuUsers().add(auUser);
		auUser.setAuDept(this);

		return auUser;
	}

	public AuUser removeAuUser(AuUser auUser) {
		getAuUsers().remove(auUser);
		auUser.setAuDept(null);

		return auUser;
	}

}