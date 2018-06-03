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
    }

	/**
	 * 商品をカートに追加する(from: item.jsp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
		try {
			//選択された商品IDと個数を取得
			int id = Integer.parseInt(request.getParameter("id"));
			int count = Integer.parseInt(request.getParameter("count"));

			//対象のアイテム情報と個数をセット
			ItemDataBeans item = ItemDao.getItemByItemID(id);
			item.setCount(count);
			request.setAttribute("item", item);

			//カートを取得・セッションにカートがない場合はカートを作成
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			if (cart == null) {
				cart = new ArrayList<ItemDataBeans>();
			}

			// 同じIDの商品があったらその商品の個数をitem.Countに追加。商品情報が重複しないようにitem情報を削除
				for (ItemDataBeans cartitem : cart){
					if (cartitem.getId() == id) {
						 int Cartcount = cartitem.getCount();
						 item.setCount(Cartcount+count);
						 cart.remove(cartitem);
							break;
						}
					}

			//カートに商品を追加・カートの情報を更新
			cart.add(item);
			session.setAttribute("cart",cart);
			request.setAttribute("cartMessage", "商品を追加しました");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/InCart.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
