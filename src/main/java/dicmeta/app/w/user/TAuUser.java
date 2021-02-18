package dicmeta.app.w.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_au_user database table.
 * 
 */
@Entity
@Table(name="t_au_user")
@NamedQuery(name="TAuUser.findAll", query="SELECT t FROM TAuUser t")
public class TAuUser extends dicmeta.app.common.CommonTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="clsf_cd")
	private String clsfCd;

	@Column(name="dept_cd")
	private String deptCd;

	@Column(name="ecny_ymd")
	private String ecnyYmd;

	@Column(name="user_nm")
	private String userNm;

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

	public String getDeptCd() {
		return this.deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
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

}