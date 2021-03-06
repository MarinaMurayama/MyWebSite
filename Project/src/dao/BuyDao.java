package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDataBeans;

public class BuyDao {

	   //インスタンスオブジェクトを返却させてコードの簡略化
		public static BuyDao getInstance() {
			return new BuyDao();
		}

		/**
		 *★購入情報登録処理
		 * @param bdb 購入情報
		 * @throws SQLException 呼び出し元にスローさせるため
		 */
		public static int insertBuy(BuyDataBeans bdb) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			int autoIncKey = -1;
			try {
				con = DBManager.getConnection();
				st = con.prepareStatement(
						"INSERT INTO t_buy(user_id,total_price,delivery_id,create_date) VALUES(?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				st.setInt(1, bdb.getUserId());
				st.setInt(2, bdb.getTotalPrice());
				st.setInt(3, bdb.getDeliveryId());
				st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				st.executeUpdate();

				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					autoIncKey = rs.getInt(1);
				}
				System.out.println("inserting buy-datas has been completed");

				return autoIncKey;
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
		 * ★UserBuyDetail(購入IDによる購入詳細情報検索)
		 * @param buyId
		 * @return BuyDataBeans
		 * 				購入情報のデータを持つJavaBeansのリスト
		 * @throws SQLException
		 * 				呼び出し元にスローさせるため
		 */
		public static BuyDataBeans getBuyDataBeansByBuyId(int buyId) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = DBManager.getConnection();

				st = con.prepareStatement(
						"SELECT * FROM t_buy"
								+ " JOIN m_delivery"  //結合・配送ﾃｰﾌﾞﾙと
								+ " ON t_buy.delivery_id = m_delivery.delivery_id"
								+ " WHERE t_buy.buy_id = ?");
				st.setInt(1, buyId);

				ResultSet rs = st.executeQuery();

				BuyDataBeans bdb = new BuyDataBeans();

				while (rs.next()) {
					bdb.setId(rs.getInt("buy_id"));
					bdb.setTotalPrice(rs.getInt("total_price"));
					bdb.setBuyDate(rs.getTimestamp("create_date"));
					bdb.setDeliveryId(rs.getInt("delivery_id"));
					bdb.setUserId(rs.getInt("user_id"));
					bdb.setDeliveryMethodPrice(rs.getInt("delivery_priceprice"));
					bdb.setDeliveryMethodName(rs.getString("delivery"));
				}

				System.out.println("searching BuyDataBeans by buyID has been completed");

				return bdb;
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
		 * ★PurchaseHistoryList(指定されたユーザの購入履歴一覧データ取得)
		 * @param userId
		 * @return buyDataList(JavaBeansのリスト)
		 * @throws SQLException
		 */
		public static ArrayList<BuyDataBeans> getBuyDataBeansListByUserId(int userId) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = DBManager.getConnection();

				st = con.prepareStatement(
						"SELECT * FROM t_buy"
								+ " JOIN m_delivery"
								+ " ON t_buy.delivery_id = m_delivery.delivery_id"
								+ " WHERE t_buy.user_id = ?"
								+ " ORDER BY create_date DESC");  //最新の購入日順に並び替え
				st.setInt(1, userId);

				ResultSet rs = st.executeQuery();

				ArrayList<BuyDataBeans> buyDataList = new ArrayList<BuyDataBeans>();

				while (rs.next()) {
					BuyDataBeans bdb = new BuyDataBeans();
					bdb.setId(rs.getInt("buy_id"));
					bdb.setTotalPrice(rs.getInt("total_price"));
					bdb.setBuyDate(rs.getTimestamp("create_date"));
					bdb.setUserId(rs.getInt("user_id"));
					bdb.setDeliveryMethodName(rs.getString("delivery"));
					bdb.setDeliveryMethodPrice(rs.getInt("delivery_priceprice"));
					buyDataList.add(bdb);
				}

				System.out.println("searching BuyDataBeansList by UserID has been completed");

				return buyDataList;

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
