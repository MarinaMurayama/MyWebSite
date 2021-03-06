package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class MasterPreview
 */
@WebServlet("/MasterPreview")
public class MasterPreview extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterPreview() {
        super();
    }

	/**
	 * 商品マスタのプレビュー画面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);

			ItemDataBeans Itemdata = ItemDao.getItemByItemID(id);

			request.setAttribute("Itemdata",Itemdata);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_preview.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
