package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class Master
 */
@WebServlet("/Master")
public class Master extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Master() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインセッションがない場合、ログイン画面にリダイレクトさせる
	 /* HttpSession session = request.getSession();
		UserDataBeans u = (UserDataBeans)session.getAttribute("userInfo");

		 if( u == null){
		  response.sendRedirect("login");
		  return;
		} */

	// ユーザ一覧情報を取得
	ItemDao itemDao = new ItemDao();
	List<ItemDataBeans> itemList = itemDao.findAll();

	// リクエストスコープにユーザ一覧情報をセット
	request.setAttribute("itemList", itemList);

	// ユーザ一覧のjspにフォワード
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO SEARCHのフォームからﾊﾟﾗﾒｰﾀで値を受け取ってDAOで検索。結果をJSPにﾌｫﾜｰﾄﾞ
		doGet(request, response);
	}

}