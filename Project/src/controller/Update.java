package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Common;
import beans.UserDataBeans;
import dao.UserDao;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Update() {
        super();
    }

	/**
	 * ユーザデータ更新画面を表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);

		UserDao userDao = new UserDao();
		UserDataBeans Userdata = userDao.findByUserDetail(id);

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("Userdata",Userdata);
		UserDataBeans u = (UserDataBeans)request.getAttribute("Userdata");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * 入力された値の確認とデータ更新
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("errMsg1", "入力された内容は正しくありません。");

		// 入力した情報を全て取得する
		String loginId = request.getParameter("loginId");
        String name = request.getParameter("name");
        String birthDate = request.getParameter("birth_date");
        String Address = request.getParameter("address");
        String password = request.getParameter("password");
        String passwordcheck = request.getParameter("passwordCheck");

        //データ更新(ﾊﾟｽﾜｰﾄﾞなしver)
        if ( passwordcheck == null ||  password == null ) {
        	UserDao userDao = new UserDao();
    		userDao.update(loginId,name,Address,birthDate);
    		response.sendRedirect("MemberList");
        }

      //データ更新(全てのﾃﾞｰﾀver)
        if (password.equals(passwordcheck)) {
        	UserDao userDao = new UserDao();
    		userDao.update(loginId,name,Address,birthDate,password);
    		response.sendRedirect("MemberList");

		}else {
	   //入力エラーの場合は値をﾘｸｴｽﾄｽｺｰﾌﾟもう一度ｾｯﾄして更新画面へフォワード
			 request.setAttribute("errMsg1", "入力された内容は正しくありません。");
			 UserDataBeans Userdata = new UserDataBeans(loginId, name,Common.dateConversion(birthDate),Address, null, null, password);
			 request.setAttribute("Userdata",Userdata);  //ﾘｸｴｽﾄｽｺｰﾌﾟにｲﾝｽﾀﾝｽを保存(属性名、ｲﾝｽﾀﾝｽ)

			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Update.jsp");
			 dispatcher.forward(request, response);
			 return;
		}
	}

}
