package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		request.setCharacterEncoding("UTF-8");

		try {
			int id = Integer.parseInt(request.getParameter("item_id"));
			System.out.println(id); //確認用

			//idを引数にして、idに紐づく商品情報を取得

			ItemDataBeans itemDetail = ItemDao.getItemByItemID(id);
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
		/*
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			//追加した商品を表示するためリクエストパラメーターにセット
			ItemDataBeans item = ItemDao.getItemByItemID(id);
			request.setAttribute("item", item);

			//カートを取得
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<ItemDataBeans>();
			}
			//カートに商品を追加。
			cart.add(item);
			//カート情報更新
			session.setAttribute("cart", cart);
			request.setAttribute("cartActionMessage", "商品を追加しました");

			RequestDispatcher dispatcher = request.getRequestDispatcher("InCart");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}  */

	}

}
