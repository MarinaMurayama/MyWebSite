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

import base.Common;
import beans.BuyDataBeans;
import beans.DeliveryMethodDataBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class BuyCheck
 */
@WebServlet("/BuyCheck")
public class BuyCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 購入手続き画面: カート内の情報をjpsにフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
		try {

			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			//カート内に商品が入っていなかったら前の処理に戻す
			if(cart.size() == 0){
				String cartMessage = "カートに商品がありません";
				response.sendRedirect("Cart");
				return;
			 }

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyCheck.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);

		}
	}

	/**
	 * 選択された配送方法から配送料金を取得
	 * 購入確認画面へフォワード
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {

			//ログインセッションがない場合、ログイン画面にリダイレクトさせる
			UserDataBeans u = (UserDataBeans)session.getAttribute("userInfo");
				if( u == null){
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
					return;
				}

			//選択された配送方法IDを取得・IDを使用しデータを取得
			int deliveryId = Integer.parseInt(request.getParameter("delivery_id"));
			DeliveryMethodDataBeans userSelectDMB = DeliveryMethodDAO.getDeliveryMethodDataBeansByID(deliveryId);

			//買い物かご・ログインユーザデータ呼び出し
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			UserDataBeans user = (UserDataBeans)session.getAttribute("userInfo");

			//商品の合計金額
			int totalPrice = Common.getTotalPrice(cart);

			//購入確定していないが確認画面で使用するのでidとbuyDate以外の情報をBuyDataBeansに値をセット
			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setUserId(user.getId());
			bdb.setTotalPrice(totalPrice);
			bdb.setDeliveryId(userSelectDMB.getId());
			bdb.setDeliveryMethodPrice(userSelectDMB.getPrice());
			bdb.setDeliveryMethodName(userSelectDMB.getDelivery());

			//購入確定で利用する為セット
			session.setAttribute("bdb", bdb);
			session.setAttribute("cart", cart);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ToBuy.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
