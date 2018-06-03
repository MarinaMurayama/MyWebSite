package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Topics
 */
@WebServlet("/Topics")
public class Topics extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Topics() {
        super();
    }

	/**
	 * 各トピックスの記事へ移動
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int topicsId = Integer.parseInt(request.getParameter("id"));

		if(topicsId == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topics1.jsp");
			dispatcher.forward(request, response);
			return;

		}else if(topicsId == 2) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topics2.jsp");
			dispatcher.forward(request, response);
			return;

		}else if(topicsId == 3) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topics3.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}
