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
 * Servlet implementation class BeansNavi
 */
@WebServlet("/BeansNavi")
public class BeansNavi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeansNavi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * BEANS NAVI画面表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/beansnavi.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * BEANS NAVI診断結果
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 入力した情報を全て取得する
		request.setCharacterEncoding("UTF-8");
		int Roast = (int)(Integer.parseInt(request.getParameter("roast")));
		int Flavor = (int)(Integer.parseInt(request.getParameter("flavor")));
		int Kind = (int)(Integer.parseInt(request.getParameter("kind")));
		int Taste = (int)(Integer.parseInt(request.getParameter("taste")));

		int total =Roast + Flavor + Kind + Taste ;
		String tastenum = "";

		if(total < 5) {
			tastenum = "B";
		}else if(total >= 5 && total<= 8){
			tastenum = "C";
		}else if(total >= 9 && total<= 12){
			tastenum = "A";
		}

		try {

		ItemDao itemDao = new ItemDao();
		List<ItemDataBeans>itemList = itemDao.beansnavi(tastenum);

		request.setAttribute("itemList",itemList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/beansnaviAnswer.jsp");
		dispatcher.forward(request, response);

		} catch (SQLException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
