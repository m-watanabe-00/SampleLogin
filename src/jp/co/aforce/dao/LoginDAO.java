package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberBean;

public class LoginDAO extends DAO {

	//ログイン判定
	public MemberBean getMember(String id, String password) throws Exception {

		//実行結果を格納する変数
		ResultSet rs = null;
		MemberBean memberBean = new MemberBean();

		Connection con = getConnection();
		String sql = "SELECT * FROM login WHERE id = ? AND password = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, password);
		rs = st.executeQuery();

		if (rs.next()) {
			memberBean.setId(rs.getString("id"));
			memberBean.setName(rs.getString("name"));
			memberBean.setPassword(rs.getString("password"));
		} else {
			return null;
		}

		st.close();
		con.close();

		return memberBean;

	}
}
