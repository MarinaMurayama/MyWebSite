package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
    }


	/**
	 * ログイン画面表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインセッションがある場合、mein画面にリダイレクトさせる
		HttpSession session = request.getSession();
		UserDataBeans u = (UserDataBeans)session.getAttribute("userInfo");

		if(u != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * ログインの入力チェック・ユーザIDをセッションにセット
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータの入力項目を取得
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		//ユーザIDを取得
		UserDao userDao = new UserDao();
		UserDataBeans userInfo = userDao.getUserId(loginId, password);

		/** テーブルに該当のデータが見つからなかった場合 **/
		if (userInfo == null) {
			request.setAttribute("errMsg", "ログインに失敗しました。");
			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		/** テーブルに該当のデータが見つかった場合 **/
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", userInfo);

		System.out.println("login success");
		response.sendRedirect("main");
	}

}
