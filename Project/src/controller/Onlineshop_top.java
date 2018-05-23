package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class Onlineshop_top
 */
@WebServlet("/Onlineshop_top")
public class Onlineshop_top extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Onlineshop_top() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインセッションがない場合、ログイン画面にリダイレクトさせる
		/* HttpSession session = request.getSession();
		UserDataBeans u = (UserDataBeans)session.getAttribute("userInfo");

		 if( u == null){
		  response.sendRedirect("login");
		  return;
		} */
	// 商品一覧情報を取得
	ItemDao itemDao = new ItemDao();
	List<ItemDataBeans>itemList = itemDao.findAll();

	request.setAttribute("itemList", itemList);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/onlineshop_top.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}