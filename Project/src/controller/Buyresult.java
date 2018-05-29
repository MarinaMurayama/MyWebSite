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

import beans.BuyDataBeans;
import beans.BuyDetailDataBeans;
import beans.ItemDataBeans;
import dao.BuyDao;
import dao.BuyDetailDao;

/**
 * Servlet implementation class Buyresult
 */
@WebServlet("/Buyresult")
public class Buyresult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buyresult() {
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
	 * 購入・終了したら購入完了ページへフォワード
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				HttpSession session = request.getSession();
		try {
			// セッションからカート情報を取得・取得したらセッションを閉じる
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");
			BuyDataBeans bdb = (BuyDataBeans)session.getAttribute("bdb");
			session.removeAttribute("cart");
			session.removeAttribute("bdb");
			System.out.println("session removeAttribute");

			// 購入情報を登録
			int buyId = BuyDao.insertBuy(bdb);
			// 購入詳細情報を購入情報IDに紐づけして登録
			for (ItemDataBeans cartInItem : cart) {
				BuyDetailDataBeans bddb = new BuyDetailDataBeans();
				bddb.setBuyId(buyId);
				bddb.setItemId(cartInItem.getId());
				BuyDetailDao.insertBuyDetail(bddb);
			}


			/* ====購入完了ページ表示用====
			BuyDataBeans resultBDB = BuyDao.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("resultBDB", resultBDB);

			// 購入アイテム情報
			ArrayList<ItemDataBeans> buyIDBList = BuyDetailDao.getItemDataBeansListByBuyId(buyId);
			request.setAttribute("buyIDBList", buyIDBList); */

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buyresult.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			//TODO エラー処理
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
