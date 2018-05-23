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
	 * マスタ画面から商品idを受け取って情報編集画面へ旧情報をフォワード
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
	 * 編集したデータを受け取り入力確認。OKの場合は情報更新。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 入力した情報を全て取得する
        request.setCharacterEncoding("UTF-8");
		String img = request.getParameter("pic");
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

      //確認2. 型番変更の場合は重複確認をする
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

  	  //最終確認
        if (tastenum != null && category.equals("2")) { //商品カテゴリが２のコーヒー豆以外なら豆のジャンル入力は必要ない
        		request.setAttribute("errMsg1", "入力された内容は正しくありません。");
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
        		dispatcher.forward(request, response);
        		return;

			}else if(tastenum == null && category.equals("1")){ //コーヒー豆なのに豆のジャンル登録がされていない場合
				request.setAttribute("errMsg3", "コーヒー豆の場合はジャンル選択をして下さい。");
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/master_signup.jsp");
	    		dispatcher.forward(request, response);
	    		return;
		   }


        if ( img .equals("") && itemnum.equals("")) { //データ更新(画像と型番は更新なし)
        	ItemDao itemDao = new ItemDao();
    		itemDao.update(tastenum,name,detail,category,stocks,price,Id);
    		response.sendRedirect("Master");
    		return;
        }else if(img .equals("") && !(itemnum.equals(""))) { //データ更新(画像は更新なし)
        	ItemDao itemDao = new ItemDao();
    		itemDao.updateNimg(itemnum,tastenum,name,detail,category,stocks,price,Id);
    		response.sendRedirect("Master");
    		return;
        }else if(!(img .equals("")) && itemnum.equals("")) { //データ更新(型番は更新なし)
        	ItemDao itemDao = new ItemDao();
        	itemDao.updateNnum(img,tastenum,name,detail,category,stocks,price,Id);
    		response.sendRedirect("Master");
    		return;
        }

      //データ更新(全てのﾃﾞｰﾀを更新したい)
        	ItemDao itemDao = new ItemDao();
    		itemDao.updateAll(itemnum,tastenum,img,name,detail,category,stocks,price,Id);
    		response.sendRedirect("Master");

	}

}
