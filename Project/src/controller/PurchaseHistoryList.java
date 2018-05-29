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
import beans.UserDataBeans;
import dao.BuyDao;

/**
 * Servlet implementation class PurchaseHistoryList
 */
@WebServlet("/PurchaseHistoryList")
public class PurchaseHistoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistoryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


					// セッション開始
						HttpSession session = request.getSession();
				try {

					//ログインセッションがない場合、ログイン画面にリダイレクトさせる
						UserDataBeans u = (UserDataBeans)session.getAttribute("userInfo");

							if(u == null){
								RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
								dispatcher.forward(request, response);
								return;
							}


					// ★★★★↓↓ログイン時に取得したユーザーIDをセッションから取得
							int userId =u.getId();
							System.out.println("userid =" + userId);

					//ﾕｰｻﾞの購入履歴一覧を取得
					ArrayList<BuyDataBeans>buylist = BuyDao.getBuyDataBeansListByUserId(userId);
					request.setAttribute("buylist",buylist);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/purchaseHistoryList.jsp");
					dispatcher.forward(request, response);

				} catch (Exception e) {
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
