package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class MemberList
 */
@WebServlet("/MemberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				HttpSession session = request.getSession();
				UserDataBeans u = (UserDataBeans)session.getAttribute("userInfo");

				//ログインセッションがない場合、ログイン画面にリダイレクトさせる
					if( u == null){
					  response.sendRedirect("login");
					  return;
					}

				// ユーザ一覧情報を取得
				UserDao userDao = new UserDao();
				List<UserDataBeans> userList = userDao.findAll();

				// リクエストスコープにユーザ一覧情報をセット
				request.setAttribute("userList", userList);

				// ユーザ一覧のjspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memberList.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 機能更新時にユーザ検索機能をつけても良いかも。
		doGet(request, response);
	}

}
