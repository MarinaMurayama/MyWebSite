package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import base.Common;

public class UserDataBeans implements Serializable{

	private int id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String address;
	private String password;
	private String createDate;
	private String updateDate;


	public UserDataBeans() {
	}

	//ログイン用
	public UserDataBeans(int id,String loginId) {
		this.id = id;
		this.loginId = loginId;
	}

    // 全てのデータをセットするコンストラクタUserDaoのfindByUserDetailﾒｿｯﾄﾞで使用
	public UserDataBeans(int id, String loginId, String name, Date birthDate, String password,String address, String createDate,String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.password = password;
		this.address = address;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public UserDataBeans(int id, String loginId, String name, Date birthDate, String password, String createDate,String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	// 更新情報(ﾊﾟｽﾜｰﾄﾞ含めてﾊﾞｰｼﾞｮﾝ)
	public UserDataBeans(String loginId, String name,Date birthDate,String address,String createDate,String updateDate,String password) {
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.password = password;
	}

	// 更新情報(ﾊﾟｽﾜｰﾄﾞは更新しないﾊﾞｰｼﾞｮﾝ)
	public UserDataBeans(String loginId, String name,Date birthDate,String address,String createDate,String updateDate) {
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getBirthDateStr() { //フォーマット修正して出力したい時に使用
		String str = null;
		str = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
		return str;
	}

	public String getBirthDateFmt() {  //フォーマット修正して出力したい時に使用
		String str = null;
		str = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
		return str;
	}

	public String getCreateDateFmt() {   //フォーマット修正して出力(ユーザ詳細画面で使用)
		String str = null;
		 str = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(Common.dateTimeConversion(createDate));
		return str;
	}

	public String getUpdateDateFmt() {     //フォーマット修正して出力(ユーザ詳細画面で使用)
		String str = null;
		str = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(Common.dateTimeConversion(updateDate));
		return str;
	}

}

