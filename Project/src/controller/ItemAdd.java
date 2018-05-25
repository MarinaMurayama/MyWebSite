package controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 商品をカートに追加する(from: item.jsp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
		try {
			//選択された商品IDを取得
			int id = Integer.parseInt(request.getParameter("id"));
			//対象のアイテム情報を取得して情報セット
			ItemDataBeans item = ItemDao.getItemByItemID(id);
			request.setAttribute("item", item);

			//カートを取得・セッションにカートがない場合はカートを作成
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
				if (cart == null) {
					cart = new ArrayList<ItemDataBeans>();
				}

			//カートに商品を追加・カートの情報を更新
			cart.add(item);
			session.setAttribute("cart",cart);
			request.setAttribute("cartMessage", "商品を追加しました");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/InCart.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
