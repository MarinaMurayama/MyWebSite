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
        // TODO Auto-generated constructor stub
    }

	/**
	 * //memberListから受け取った対象者のidを使用し、ﾕｰｻﾞﾃﾞｰﾀを取得。ﾘｸｴｽﾄｽｺｰﾌﾟにｾｯﾄしてﾌｫﾜｰﾄﾞ。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);

		UserDao userDao = new UserDao();
		UserDataBeans Userdata = userDao.findByUserDetail(id);

		request.setAttribute("Userdata",Userdata);  //ﾘｸｴｽﾄｽｺｰﾌﾟにｲﾝｽﾀﾝｽを保存(属性名、ｲﾝｽﾀﾝｽ)
		UserDataBeans u = (UserDataBeans)request.getAttribute("Userdata");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Delete.jsp");
		dispatcher.forward(request, response);   //削除画面にﾃﾞｰﾀを渡す。
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");  //削除画面でokﾎﾞﾀﾝを押したらformでidﾃﾞｰﾀが送られてくるので取得する
		System.out.println(id);  //念のためｺﾝｿｰﾙに出力

		UserDao userDao = new UserDao();
		userDao.delete(id);

		response.sendRedirect("MemberList");
	}

}
