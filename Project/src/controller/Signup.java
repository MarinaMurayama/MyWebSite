package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 新規作成画面のjspにフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * ユーザの新規登録処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 入力した情報を全て取得する
        request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
        String name = request.getParameter("name");
        String birthDate = request.getParameter("birth_date");
        String Address1 = request.getParameter("zip11");
        String Address2 = request.getParameter("addr11");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordcheck");

        String Address= Address1 + Address2 ;

        //パスワードの入力確認
        if (!password.equals(passwordCheck)) {
            request.setAttribute("errMsg1", "入力された内容は正しくありません。");
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
    		dispatcher.forward(request, response);
      		return;
		}

        //ログインIDの重複確認
        UserDao user = new UserDao();
  		boolean i = user.matchingId(loginId);
  		if (i) {
			request.setAttribute("errMsg2", "既に存在しているログインIDです。再入力をして下さい。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

    	UserDao userDao = new UserDao();
  		userDao.create(loginId,name,birthDate,Address,password);

  		response.sendRedirect("main");

	}

}
