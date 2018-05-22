package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class Item
 */
@WebServlet("/Item")
public class Item extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 商品idを元に商品詳細情報を取得してjspに表示する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		try {
			int id = Integer.parseInt(request.getParameter("item_id"));
			System.out.println(id); //確認用

			//idを引数にして、idに紐づく商品情報を取得
			ItemDao itemDao = new ItemDao();
			ItemDataBeans itemDetail = itemDao.getItemByItemID(id);
			request.setAttribute("itemDetail", itemDetail);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
