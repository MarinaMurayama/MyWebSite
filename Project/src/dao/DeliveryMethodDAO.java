package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.DeliveryMethodDataBeans;

public class DeliveryMethodDAO {

	//インスタンスオブジェクトを返却させてコードの簡略化
			public static DeliveryMethodDAO getInstance() {
				return new DeliveryMethodDAO();
			}

		/**
		 *★ 配送方法をIDをもとに取得
		 * @param DeliveryMethodId
		 * @return DeliveryMethodDataBeans
		 * @throws SQLException
		 */
		public static DeliveryMethodDataBeans getDeliveryMethodDataBeansByID(int DeliveryMethodId) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = DBManager.getConnection();

				st = con.prepareStatement(
						"SELECT * FROM m_delivery WHERE delivery_id = ?");
				st.setInt(1, DeliveryMethodId);

				ResultSet rs = st.executeQuery();

				DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans();
				if (rs.next()) {
					dmdb.setId(rs.getInt("delivery_id"));
					dmdb.setDelivery(rs.getString("delivery"));
					dmdb.setPrice(rs.getInt("delivery_priceprice"));
				}

				System.out.println("searching DeliveryMethodDataBeans by DeliveryMethodID has been completed");

				return dmdb;
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
