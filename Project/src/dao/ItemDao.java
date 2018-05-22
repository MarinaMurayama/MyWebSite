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
     * 全ての商品情報を取得する
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
	 * 商品IDによる商品検索
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
	 * 商品検索
	 * @param searchWord
	 * @param pageNum
	 * @param pageMaxItemCount
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ItemDataBeans> getItemsByItemName(String searchWord, int pageNum, int pageMaxItemCount) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			int startiItemNum = (pageNum - 1) * pageMaxItemCount;
			con = DBManager.getConnection();

			if (searchWord.length() == 0) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM m_item ORDER BY id ASC LIMIT ?,? ");  //商品のid番号昇順でｿｰﾄ。LIMIT、行数指定。
				st.setInt(1, startiItemNum);
				st.setInt(2, pageMaxItemCount);
			} else {
				// 商品名検索
				st = con.prepareStatement("SELECT * FROM m_item WHERE name LIKE ? ORDER BY id ASC LIMIT ?,? ");
				st.setString(1, "%" +searchWord+ "%");  //setStringになっているから '' で囲むのは不要
				st.setInt(2, startiItemNum);
				st.setInt(3, pageMaxItemCount);
			}

			ResultSet rs = st.executeQuery();
			ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
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
}
