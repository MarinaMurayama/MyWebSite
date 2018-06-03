package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDataBeans;
import dao.UserDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
    }

	/**
	 * 削除確認画面にユーザデータを表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);

		UserDao userDao = new UserDao();
		UserDataBeans Userdata = userDao.findByUserDetail(id);

		request.setAttribute("Userdata",Userdata);
		UserDataBeans u = (UserDataBeans)request.getAttribute("Userdata");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Delete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * ユーザデータを削除
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);

		UserDao userDao = new UserDao();
		userDao.delete(id);

		response.sendRedirect("MemberList");
	}

}
