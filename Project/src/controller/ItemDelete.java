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


    public ItemDelete() {
        super();
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

		// 削除処理
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
