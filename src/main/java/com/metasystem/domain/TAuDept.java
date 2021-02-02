package com.metasystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_au_dept database table.
 * 
 */
@Entity
@Table(name="t_au_dept")
@NamedQuery(name="TAuDept.findAll", query="SELECT t FROM TAuDept t")
public class TAuDept extends com.metasystem.common.CommonTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dept_cd")
	private String deptCd;

	@Column(name="dept_nm")
	private String deptNm;

	@Column(name="upper_dept_cd")
	private String upperDeptCd;

	//bi-directional many-to-one association to TAuUser
	@OneToMany(mappedBy="TAuDept")
	private List<TAuUser> TAuUsers;

	public TAuDept() {
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

	public String getUpperDeptCd() {
		return this.upperDeptCd;
	}

	public void setUpperDeptCd(String upperDeptCd) {
		this.upperDeptCd = upperDeptCd;
	}

	public List<TAuUser> getTAuUsers() {
		return this.TAuUsers;
	}

	public void setTAuUsers(List<TAuUser> TAuUsers) {
		this.TAuUsers = TAuUsers;
	}

	public TAuUser addTAuUser(TAuUser TAuUser) {
		getTAuUsers().add(TAuUser);
		TAuUser.setTAuDept(this);

		return TAuUser;
	}

	public TAuUser removeTAuUser(TAuUser TAuUser) {
		getTAuUsers().remove(TAuUser);
		TAuUser.setTAuDept(null);

		return TAuUser;
	}

}