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

import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class Onlineshop_top
 */
@WebServlet("/Onlineshop_top")
public class Onlineshop_top extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Onlineshop_top() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 商品一覧情報を取得
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// 商品一覧情報を取得
			ItemDao itemDao = new ItemDao();
			List<ItemDataBeans>itemList = itemDao.findAll();

			request.setAttribute("itemList", itemList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/onlineshop_top.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * search wordの商品検索処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {

			String Word = request.getParameter("word");

			ItemDao itemDao = new ItemDao();
			List<ItemDataBeans>itemList = itemDao.getItemsByItemName(Word);

			request.setAttribute("itemList",itemList);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/onlineshop_top.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
	}

}
