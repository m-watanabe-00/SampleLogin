package jp.co.aforce.beans;

import java.io.Serializable;

public class MemberBean implements Serializable {

	private String id;
	private String name;
	private String password;
	private String msg;

	// 引数無しのデフォルトコンストラクタ
	public MemberBean() {

	}

	public String getMsg() {
		return msg;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
