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
 * Servlet implementation class MasterItemDelete
 */
@WebServlet("/MasterItemDelete")
public class MasterItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterItemDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		ItemDataBeans Itemdata = ItemDao.getItemByItemID(id);

		request.setAttribute("Itemdata",Itemdata);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_delete.jsp");
		dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);

		ItemDao itemDao = new ItemDao();
		itemDao.deleteitem(id);

		response.sendRedirect("Master");
	}

}
