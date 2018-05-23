package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Common;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.ItemDao;
import dao.UserDao;

/**
 * Servlet implementation class MasterEdit
 */
@WebServlet("/MasterEdit")
public class MasterEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * マスタ画面から商品idを受け取って情報編集を行う
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		ItemDataBeans Itemdata = ItemDao.getItemByItemID(id);

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("Itemdata",Itemdata);  //ﾘｸｴｽﾄｽｺｰﾌﾟにｲﾝｽﾀﾝｽを保存(属性名、ｲﾝｽﾀﾝｽ)
		ItemDataBeans u = (ItemDataBeans)request.getAttribute("Itemdata");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_edit.jsp");
		dispatcher.forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
