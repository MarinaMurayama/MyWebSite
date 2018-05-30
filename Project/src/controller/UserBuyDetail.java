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
import beans.ItemDataBeans;
import dao.BuyDao;
import dao.BuyDetailDao;

/**
 * Servlet implementation class UserBuyDetail
 */
@WebServlet("/UserBuyDetail")
public class UserBuyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBuyDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 購入履歴の詳細を表示する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
	try {

		// 選択された購入IDを受け取る
		String id = request.getParameter("id");
		int buyid = Integer.parseInt(id);
		System.out.println("buyid ="+ buyid);

		// 購入・商品データを取得して履歴詳細画面へフォワード
		BuyDataBeans hBdb = BuyDao.getBuyDataBeansByBuyId(buyid);
		ArrayList<ItemDataBeans> historyList = BuyDetailDao.getItemDataBeansListByBuyId(buyid);

		session.setAttribute("hBdb", hBdb);
		session.setAttribute("historyList", historyList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userBuydetail.jsp");
		dispatcher.forward(request, response);


		}catch (Exception e) {

		e.printStackTrace();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		dispatcher.forward(request, response);
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
