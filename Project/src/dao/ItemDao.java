package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ItemDataBeans;

public class ItemDao {

	/**
     * ★全ての商品情報を取得する
     * @return
     */
    public List<ItemDataBeans> findAll() {
        Connection conn = null;
        List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

        try {

            conn = DBManager.getConnection();
            String sql = "SELECT * FROM m_item";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("item_id");
                String ItemNum = rs.getString("item_num");
                String Taste = rs.getString("taste_num");
                String Img = rs.getString("item_img");
                String ItemName = rs.getString("item_name");
                String Detail = rs.getString("item_detail");
                String Category = rs.getString("category_id");
                int Stocks = rs.getInt("stocks");
                int Price = rs.getInt("price");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");

                ItemDataBeans item = new ItemDataBeans(id,ItemNum,Taste,Img,ItemName,Detail,Category,Stocks,Price,createDate, updateDate);
                itemList.add(item);
            }

            System.out.println("getAllItem completed");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return itemList;
    }

    /**
     * ★新規登録時のユーザID重複確認
     * @return 重複時はtrue
     */
    public boolean matchingNum(String itemnum){

    	Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            // SELECT文を準備
            String sql = "SELECT item_num FROM m_item WHERE item_num =?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,itemnum);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return false;
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * ★新規登録(コーヒー豆以外の場合)
     */
    public void create(String item_num,String item_img,String item_name,String item_detail,String category_id,int stocks,int price) {
    	Connection conn = null;
        try {
          	// データベースへ接続
            conn = DBManager.getConnection();
            // INSERT文を準備
            String sql = "INSERT INTO m_item(item_num,item_img,item_name,item_detail,category_id,stocks,price,create_Date,update_Date)"
            		    + "values (?,?,?,?,?,?,?,now(),now())";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, item_num);
            pStmt.setString(2, item_img);
            pStmt.setString(3, item_name);
            pStmt.setString(4, item_detail);
            pStmt.setString(5, category_id);
            pStmt.setInt(6, stocks);
            pStmt.setInt(7, price);

            int result = pStmt.executeUpdate();
            // 追加された行数を出力
            System.out.println(result);
            pStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ★新規登録(コーヒー豆の場合)
     */
    public void create(String item_num,String taste_num,String item_img,String item_name,String item_detail,String category_id,int stocks,int price) {
    	Connection conn = null;
        try {
          	// データベースへ接続
            conn = DBManager.getConnection();
            // INSERT文を準備
            String sql = "INSERT INTO m_item(item_num,taste_num,item_img,item_name,item_detail,category_id,stocks,price,create_Date,update_Date)"
            		    + "values (?,?,?,?,?,?,?,?,now(),now())";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, item_num);
            pStmt.setString(2, taste_num);
            pStmt.setString(3, item_img);
            pStmt.setString(4, item_name);
            pStmt.setString(5, item_detail);
            pStmt.setString(6, category_id);
            pStmt.setInt(7, stocks);
            pStmt.setInt(8, price);

            int result = pStmt.executeUpdate();
            // 追加された行数を出力
            System.out.println(result);
            pStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

	/**
	 * ★商品IDによる商品検索
	 * @param itemId
	 * @return ItemDataBeans
	 * @throws SQLException
	 */
	public static ItemDataBeans getItemByItemID(int itemId) throws SQLException {
		ItemDataBeans item = new ItemDataBeans();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM m_item WHERE item_id = ?");
			st.setInt(1, itemId);

			ResultSet rs = st.executeQuery();


			if (rs.next()) {
				item.setId(rs.getInt("item_id"));
				item.setItem_num(rs.getString("item_num"));
				item.setTaste_num(rs.getString("taste_num"));
				item.setItem_img(rs.getString("item_img"));
				item.setName(rs.getString("item_name"));
				item.setDetail(rs.getString("item_detail"));
				item.setCategory_id(rs.getString("category_id"));
				item.setStocks(rs.getInt("stocks"));
				item.setPrice(rs.getInt("price"));
				item.setCreateDate(rs.getString("create_date"));
				item.setUpdateDate(rs.getString("update_date"));

			}

			System.out.println("searching item by itemID has been completed");
			return item;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}




	/**
	 * ★データ更新(全てのデータを更新したい)
	 */
	 public void updateAll(String item_num,String taste_num,String item_img,String item_name,String item_detail,String category_id,int stocks,int price,int id) {
	    	Connection conn = null;
	        try {
	          	// データベースへ接続
	            conn = DBManager.getConnection();

	            String sql ="UPDATE m_item SET item_num=?,taste_num=?,item_img=?,item_name=?,item_detail=?,category_id=?,stocks=?,price=?,update_date=now()"
	            			+ " WHERE item_id =?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, item_num);
	            pStmt.setString(2, taste_num);
	            pStmt.setString(3, item_img);
	            pStmt.setString(4, item_name);
	            pStmt.setString(5, item_detail);
	            pStmt.setString(6, category_id);
	            pStmt.setInt(7, stocks);
	            pStmt.setInt(8, price);
	            pStmt.setInt(9, id);

	            int result = pStmt.executeUpdate();
	            System.out.println(result);
	            System.out.println("データ更新(全てのデータ)");

	            pStmt.close();

	        } catch (SQLException e) {
	            e.printStackTrace();

	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	 	/**
		 *★データ更新(画像と型番は更新なし)
		 */
	    public void update(String taste_num,String item_name,String item_detail,String category_id,int stocks,int price,int id) {
	    	Connection conn = null;
	        try {
	          	// データベースへ接続
	            conn = DBManager.getConnection();

	            String sql ="UPDATE m_item SET taste_num=?,item_name=?,item_detail=?,category_id=?,stocks=?,price=?,update_date=now()"
            			+ " WHERE item_id =?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, taste_num);
	            pStmt.setString(2, item_name);
	            pStmt.setString(3, item_detail);
	            pStmt.setString(4, category_id);
	            pStmt.setInt(5, stocks);
	            pStmt.setInt(6, price);
	            pStmt.setInt(7, id);

	            int result = pStmt.executeUpdate();
	            System.out.println(result);
	            System.out.println("データ更新更新(画像と型番は更新なし)");

	            pStmt.close();

	        } catch (SQLException e) {
	            e.printStackTrace();

	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	    /**
		 *★データ更新(画像は更新なし)
		 */
	    public void updateNimg(String item_num,String taste_num,String item_name,String item_detail,String category_id,int stocks,int price,int id) {
	    	Connection conn = null;
	        try {
	          	// データベースへ接続
	            conn = DBManager.getConnection();

	            String sql ="UPDATE m_item SET item_num=?,taste_num=?,item_name=?,item_detail=?,category_id=?,stocks=?,price=?,update_date=now()"
            			+ " WHERE item_id =?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, item_num);
	            pStmt.setString(2, taste_num);
	            pStmt.setString(3, item_name);
	            pStmt.setString(4, item_detail);
	            pStmt.setString(5, category_id);
	            pStmt.setInt(6, stocks);
	            pStmt.setInt(7, price);
	            pStmt.setInt(8, id);

	            int result = pStmt.executeUpdate();
	            System.out.println(result);
	            System.out.println("データ更新(画像は更新なし)");

	            pStmt.close();

	        } catch (SQLException e) {
	            e.printStackTrace();

	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	    /**
		 *★データ更新(型番は更新なし)
		 */
	    public void updateNnum(String img,String taste_num,String item_name,String item_detail,String category_id,int stocks,int price,int id) {
	    	Connection conn = null;
	        try {
	          	// データベースへ接続
	            conn = DBManager.getConnection();

	            String sql ="UPDATE m_item SET item_img=?,taste_num=?,item_name=?,item_detail=?,category_id=?,stocks=?,price=?,update_date=now()"
            			+ " WHERE item_id =?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, img);
	            pStmt.setString(2, taste_num);
	            pStmt.setString(3, item_name);
	            pStmt.setString(4, item_detail);
	            pStmt.setString(5, category_id);
	            pStmt.setInt(6, stocks);
	            pStmt.setInt(7, price);
	            pStmt.setInt(8, id);

	            int result = pStmt.executeUpdate();
	            System.out.println(result);
	            System.out.println("データ更新(型番は更新なし)");

	            pStmt.close();

	        } catch (SQLException e) {
	            e.printStackTrace();

	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }


	/**
	 * ★商品検索(ワード検索: Master＆Onlineshop)
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public List<ItemDataBeans> getItemsByItemName(String word) throws SQLException {

		Connection con = null;
		PreparedStatement st = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		try {
			con = DBManager.getConnection();

			if (word.length() == 0) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM m_item ORDER BY item_id ASC ");  //商品のid番号昇順でｿｰﾄ
				System.out.println("SearchAllItem");

			} else {
				// 商品名検索
				st = con.prepareStatement("SELECT * FROM m_item WHERE item_name LIKE ? ORDER BY item_id ASC");
				st.setString(1, "%" +word+ "%");
				System.out.println("WordSearchItem");
			}

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("item_id"));
				item.setItem_num(rs.getString("item_num"));
				item.setTaste_num(rs.getString("taste_num"));
				item.setItem_img(rs.getString("item_img"));
				item.setName(rs.getString("item_name"));
				item.setDetail(rs.getString("item_detail"));
				item.setCategory_id(rs.getString("category_id"));
				item.setStocks(rs.getInt("stocks"));
				item.setPrice(rs.getInt("price"));
				item.setCreateDate(rs.getString("create_date"));
				item.setUpdateDate(rs.getString("update_date"));

				itemList.add(item);
			}
			System.out.println("get Items by itemName has been completed");
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * ★商品検索(商品カテゴリ別: Onlineshop)
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public List<ItemDataBeans> getItemByCategoryID(String category) throws SQLException {

		Connection con = null;
		PreparedStatement st = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		try {
			con = DBManager.getConnection();

			if (category.equals("1") || category.equals("2")) {

				st = con.prepareStatement("SELECT * FROM m_item WHERE category_id= ? ORDER BY item_id ASC");//商品のid番号昇順でｿｰﾄ
				st.setString(1, category);
				System.out.println("Search CoffeeOnly or OtherItem");

			} else if(category.equals("3")){

				st = con.prepareStatement("SELECT * FROM m_item ORDER BY item_id ASC");
				System.out.println("AllItem");
			}

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("item_id"));
				item.setItem_num(rs.getString("item_num"));
				item.setTaste_num(rs.getString("taste_num"));
				item.setItem_img(rs.getString("item_img"));
				item.setName(rs.getString("item_name"));
				item.setDetail(rs.getString("item_detail"));
				item.setCategory_id(rs.getString("category_id"));
				item.setStocks(rs.getInt("stocks"));
				item.setPrice(rs.getInt("price"));
				item.setCreateDate(rs.getString("create_date"));
				item.setUpdateDate(rs.getString("update_date"));

				itemList.add(item);
			}
			System.out.println("get Items by Category_id has been completed");
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


	 /**
     * ★商品データ削除
     */
    public void deleteitem(String id){

    	Connection conn = null;
        try {
            conn = DBManager.getConnection();
            String sql = "DELETE FROM m_item WHERE item_id=?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);

            int result = pStmt.executeUpdate();
            System.out.println(result);
            pStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



	/**
	 * 商品総数を取得
	 *
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public static double getItemCount(String searchWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("select count(*) as cnt from m_item where name like ?");
			st.setString(1, "%"+searchWord+"%");
			ResultSet rs = st.executeQuery();
			double coung = 0.0;
			while (rs.next()) {
				coung = Double.parseDouble(rs.getString("cnt"));
			}
			return coung;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * ★商品検索(BEANS NAVI)
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public List<ItemDataBeans> beansnavi(String tastenum) throws SQLException {

		Connection con = null;
		PreparedStatement st = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM m_item WHERE taste_num= ? ORDER BY stocks DESC");//商品のストックが多い順でｿｰﾄ
			st.setString(1, tastenum);
			System.out.println("BEANS NAVI ANSWER");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("item_id"));
				item.setItem_num(rs.getString("item_num"));
				item.setTaste_num(rs.getString("taste_num"));
				item.setItem_img(rs.getString("item_img"));
				item.setName(rs.getString("item_name"));
				item.setDetail(rs.getString("item_detail"));
				item.setCategory_id(rs.getString("category_id"));
				item.setStocks(rs.getInt("stocks"));
				item.setPrice(rs.getInt("price"));
				item.setCreateDate(rs.getString("create_date"));
				item.setUpdateDate(rs.getString("update_date"));

				itemList.add(item);
			}
			System.out.println("get Items by Category_id has been completed");
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


}
