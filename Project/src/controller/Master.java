package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import beans.UserDataBeans;
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

		HttpSession session = request.getSession();
		UserDataBeans u = (UserDataBeans)session.getAttribute("userInfo");

		 if( u == null){
		  response.sendRedirect("login");
		  return;
		}

	// 商品一覧情報を取得
	ItemDao itemDao = new ItemDao();
	List<ItemDataBeans> itemList = itemDao.findAll();

	request.setAttribute("itemList", itemList);

	// ユーザ一覧のjspにフォワード
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * 検索処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");

			try {
				// 入力した情報を全て取得する
				String Word = request.getParameter("word");

				ItemDao itemDao = new ItemDao();
				List<ItemDataBeans> itemList = itemDao.getItemsByItemName(Word);

				request.setAttribute("itemList",itemList);

		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
					e.printStackTrace();
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
					dispatcher.forward(request, response);
				}

	}

}
