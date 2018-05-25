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

/**
 * Servlet implementation class ItemDelete
 */
@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDelete() {
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
	 * カート内から選択された商品を削除
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
		try {
			String[] deleteItem = request.getParameterValues("delete_item_id_list");
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			String cartMessage = "";

			//if :削除処理 ,else:削除商品がないのでメッセージだけ渡す
			if (deleteItem != null) {
				for (String deleteItemId : deleteItem) {  					 //削除商品idを取得(この時点ではString型で)
					for (ItemDataBeans cartInItem : cart) {						 //カート内の商品を全て取り出す
						if (cartInItem.getId() == Integer.parseInt(deleteItemId)) { //削除対象idと一致した要素を削除
							cart.remove(cartInItem);
							break;
						}
					}
				}
				cartMessage = "削除しました";
			} else {
				cartMessage = "削除する商品が選択されていません";
			}

			request.setAttribute("cartMessage", cartMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/InCart.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
