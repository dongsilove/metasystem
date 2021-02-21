package dicmeta.app.w.login;

import java.io.Serializable;

/**
 * @author 박이정
 * @since 2020.08.31
 * @version 1.0
 * @see
 * 
 *      <pre>
 *  == 개정이력(Modification Information) ==
 * 
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2020.08.31   박이정   로그인Vo    최초 생성
 *
 * </pre>
 */
public class LoginVo implements Serializable{

	private static final long serialVersionUID = 3445006228288315504L;
	
	private String userId;  // 사용자아이디
	private String userPwd; // 비밀번호
	private String userNam; // 이름
	private String userAtt; // 소속
	private String userAra; // 관할지역
	private String ugrpCde; // 사용자그룹코드
	private String auth;    // 권한
	private String salt; 	// 비밀번호SALT
	private String attNam;  // 소속명
	private String locInfo; // 위치즐겨찾기
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserNam() {
		return userNam;
	}
	public void setUserNam(String userNam) {
		this.userNam = userNam;
	}
	public String getUserAtt() {
		return userAtt;
	}
	public void setUserAtt(String userAtt) {
		this.userAtt = userAtt;
	}
	public String getUserAra() {
		return userAra;
	}
	public void setUserAra(String userAra) {
		this.userAra = userAra;
	}
	public String getUgrpCde() {
		return ugrpCde;
	}
	public void setUgrpCde(String ugrpCde) {
		this.ugrpCde = ugrpCde;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getAttNam() {
		return attNam;
	}
	public void setAttNam(String attNam) {
		this.attNam = attNam;
	}
	public String getLocInfo() {
		return locInfo;
	}
	public void setLocInfo(String locInfo) {
		this.locInfo = locInfo;
	}
	
}