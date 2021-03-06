package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import base.Common;
import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class MasterEdit
 */
@WebServlet("/MasterEdit")
@MultipartConfig(location="C:\\Users\\marin\\OneDrive\\ドキュメント\\git\\MyWebSite\\Project\\WebContent\\picture", maxFileSize=10485760)
public class MasterEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterEdit() {
        super();
    }

	/**
	 * マスタ画面から商品idを受け取って情報編集画面へ旧情報をフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		ItemDataBeans Itemdata = ItemDao.getItemByItemID(id);

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("Itemdata",Itemdata);
		ItemDataBeans u = (ItemDataBeans)request.getAttribute("Itemdata");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_edit.jsp");
		dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * 編集したデータを受け取り入力確認。OKの場合は情報更新。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //入力データを取得
			request.setCharacterEncoding("UTF-8");

  			Part part = request.getPart("pic");
  			String fName = "";

  			if(part.getSize() > 0 ) {
  	  			 fName = Common.getFileName(part);
  	  			part.write(fName);
  	  			fName = Common.IMAGE_PATH + fName;
  			}

        	String name = request.getParameter("name");
        	String detail = request.getParameter("detail");
        	String category = request.getParameter("category");
        	String tastenum = request.getParameter("taste");
        	String itemnum = request.getParameter("itemnum");
        	int Id = (int)(Integer.parseInt(request.getParameter("id")));
        	int stocks = (int)(Integer.parseInt(request.getParameter("stocks")));
        	int price = (int)(Integer.parseInt(request.getParameter("price")));

      //確認1. 金額と在庫数が0より小さい場合はエラー表示してjspへフォワード
        if (stocks <= 0 || price <= 0) {
            request.setAttribute("errMsg1", "入力された内容は正しくありません。");
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_edit.jsp");
    		dispatcher.forward(request, response);
      		return;
		}

      //確認2. 型番を変更する場合は重複していないか確認をする
        if(!(itemnum.equals(""))){
        	ItemDao item = new ItemDao();
        	boolean i = item.matchingNum(itemnum);
        	if(i){
			request.setAttribute("errMsg2", "既に存在している型番です。再入力をして下さい。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_edit.jsp");
			dispatcher.forward(request, response);
			return;
        	}
        }

  	  //確認3. 商品カテゴリとtastenumの関連
        if (tastenum != null && category.equals("2")) { //商品カテゴリが２のコーヒー豆以外なら豆分類の入力は必要ない
        		request.setAttribute("errMsg1", "入力された内容は正しくありません。");
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
        		dispatcher.forward(request, response);
        		return;

			}else if(tastenum == null && category.equals("1")){ //コーヒー豆なのに豆分類の登録がされていない場合
				request.setAttribute("errMsg3", "コーヒー豆の場合はジャンル選択をして下さい。");
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
	    		dispatcher.forward(request, response);
	    		return;
		   }

       //データ更新
        if ( fName.equals("") && itemnum.equals("")) { 		 //画像と型番は更新なし
        	ItemDao itemDao = new ItemDao();
    		itemDao.update(tastenum,name,detail,category,stocks,price,Id);
    		response.sendRedirect("Master");
    		return;
        }else if(fName.equals("") && !(itemnum.equals(""))) { //画像は更新なし
        	ItemDao itemDao = new ItemDao();
    		itemDao.updateNimg(itemnum,tastenum,name,detail,category,stocks,price,Id);
    		response.sendRedirect("Master");
    		return;
        }else if(!(fName.equals("")) && itemnum.equals("")) { //型番は更新なし
        	ItemDao itemDao = new ItemDao();
        	itemDao.updateNnum(fName,tastenum,name,detail,category,stocks,price,Id);
    		response.sendRedirect("Master");
    		return;
        }

        	ItemDao itemDao = new ItemDao();				 //全てのﾃﾞｰﾀを更新したい
    		itemDao.updateAll(itemnum,tastenum,fName,name,detail,category,stocks,price,Id);

    		//画像を配置する時間分まつ
		    Common.Delaytime();
    		response.sendRedirect("Master");
	}

}
