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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyCheck.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			//TODO エラーページを作成
			/*
			 * session.setAttribute("errorMessage", e.toString());
			 * response.sendRedirect("Error");
			 */

		}
	}

	/**
	 * 選択された配送方法から配送料金を取得
	 * 購入確認画面へフォワード
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			//選択された配送方法IDを取得・IDを使用しデータを取得
			int deliveryId = Integer.parseInt(request.getParameter("delivery_id"));
			DeliveryMethodDataBeans userSelectDMB = DeliveryMethodDAO.getDeliveryMethodDataBeansByID(deliveryId);

			//買い物かご
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			//商品の合計金額
			int totalPrice = Common.getTotalPrice(cart);  //買い物かごに入っているitemの金額をEchelperｸﾗｽのﾒｿｯﾄﾞで取得

			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setUserId((int) session.getAttribute("userInfo"));
			bdb.setTotalPrice(totalPrice);
			bdb.setDeliveryId(userSelectDMB.getId());
			bdb.setDeliveryMethodPrice(userSelectDMB.getPrice()); //★★
			bdb.setDeliveryMethodName(userSelectDMB.getDelivery());  //★★

			//購入確定で利用する為セット
			session.setAttribute("bdb", bdb);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ToBuy.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
