package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import base.Common;
import dao.ItemDao;

/**
 * Servlet implementation class MasterSignup
 */
@WebServlet("/MasterSignup")
@MultipartConfig(location="C:\\Users\\marin\\OneDrive\\ドキュメント\\git\\MyWebSite\\Project\\WebContent\\picture", maxFileSize=10485760)
public class MasterSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterSignup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 新規作成画面のjspにフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * 入力した値を受け取り入力確認。OKの場合は商品情報を新規登録
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 入力した情報を全て取得する
        request.setCharacterEncoding("UTF-8");

        Part part = request.getPart("pic");
        String fName = Common.getFileName(part);
        part.write(fName); //ファイルを上記の場所においておきます
        fName = Common.IMAGE_PATH + fName;

        String name = request.getParameter("name");
        String detail = request.getParameter("detail");
        String category = request.getParameter("category");
        String tastenum = request.getParameter("taste");
        String itemnum = request.getParameter("itemnum");
        int stocks = (int)(Integer.parseInt(request.getParameter("stocks")));
        int price = (int)(Integer.parseInt(request.getParameter("price")));

        //確認1. 金額と在庫数が0より小さい場合はエラー表示してjspへフォワード
        if (stocks <= 0 || price <= 0) {
            request.setAttribute("errMsg1", "入力された内容は正しくありません。");
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
    		dispatcher.forward(request, response);
      		return;
		}

      //確認2. 型番の重複確認
        ItemDao item = new ItemDao();
  		boolean i = item.matchingNum(itemnum);
  		if (i) {
			request.setAttribute("errMsg2", "既に存在している型番です。再入力をして下さい。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

  		//最終確認
        if (tastenum != null && category.equals("2")) { //商品カテゴリがコーヒー豆以外の場合は豆のジャンル入力は必要ない
        		request.setAttribute("errMsg1", "入力された内容は正しくありません。");
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
        		dispatcher.forward(request, response);
        		return;

			}else if(category.equals("2")){  //確認を抜けたカテゴリ２の商品は登録
				ItemDao itemDao = new ItemDao();
		  		itemDao.create(itemnum,fName,name,detail,category,stocks,price);
		  		response.sendRedirect("Master");

			}else if(tastenum == null && category.equals("1")){ //コーヒー豆なのに豆のジャンル登録がされていない場合
				request.setAttribute("errMsg3", "コーヒー豆の場合はジャンル選択をして下さい。");
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
	    		dispatcher.forward(request, response);
		   }else {
			   ItemDao itemDao = new ItemDao();
			   itemDao.create(itemnum,tastenum,fName,name,detail,category,stocks,price);


		 //画像を配置する時間分まつ
			    Common.Delaytime();
			    response.sendRedirect("Master");

		   }
	}


}


