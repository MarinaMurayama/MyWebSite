package controller;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class Onlineshop_category
 */
@WebServlet("/Onlineshop_category")
public class Onlineshop_category extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Onlineshop_category() {
        super();
    }

	/**
	 * 商品ジャンルごとにオンラインショップへアイテムを表示する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {
			String Categoryid = request.getParameter("id");

			ItemDao itemDao = new ItemDao();
			List<ItemDataBeans>itemList = itemDao.getItemByCategoryID(Categoryid);

			request.setAttribute("itemList",itemList);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/onlineshop_top.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
	}

}
