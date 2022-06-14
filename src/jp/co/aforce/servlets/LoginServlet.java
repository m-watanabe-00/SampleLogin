package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.dao.LoginDAO;

@WebServlet(urlPatterns = { "/svlt/loginServlet" })
public class LoginServlet extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		//リクエストパラメータを受け取る
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String jsp = "../jsp/login.jsp";

		//会員情報のプロパティ
		MemberBean member = new MemberBean();

		try {

			//ログイン判定
			LoginDAO dao = new LoginDAO();
			member = dao.getMember(id, password);

			if (member != null) {
				jsp = "../jsp/success.jsp";
			} else {
				member = new MemberBean();
				member.setMsg("IDまたはパスワードが違います");
				member.setId(id);
				//member.setPassword(password);
			}

			request.setAttribute("member", member);
			request.getRequestDispatcher(jsp).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}

}
