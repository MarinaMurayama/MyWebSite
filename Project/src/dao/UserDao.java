package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.Common;
import base.DBManager;
import beans.UserDataBeans;


public class UserDao {


		/**
	     * ★ログインIDとパスワードに紐づくユーザ情報を返す
	     * @param loginId
	     * @param password
	     * @return
	     */
	    public UserDataBeans getUserId(String loginId, String password) {
	    	Connection conn = null;
	        try {
	            conn = DBManager.getConnection();

	            String sql = "SELECT * FROM c_user WHERE login_id = ? and password = ?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, loginId);
	            pStmt.setString(2, Common.encryption(password));
	            ResultSet rs = pStmt.executeQuery();


	            if (!rs.next()) { //該当データなしの場合はnullを返す
	                return null;
	            }

	            int userId = rs.getInt("user_id");
	            String login_Id = rs.getString("login_id");

	            return new UserDataBeans(userId,login_Id);

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	    }

	    /**
	     *★新規登録時のユーザID重複確認
	     * @return 重複時はtrueを返す
	     */
	    public boolean matchingId(String loginId){

	    	Connection conn = null;
	        try {
	            conn = DBManager.getConnection();
	            String sql = "SELECT login_id FROM c_user WHERE login_id =?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, loginId);
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
	     * ★新規登録処理
	     */
	    public void create(String loginId,String name,String birth_date,String Address,String password) {
	    	Connection conn = null;
	        try {
	            conn = DBManager.getConnection();
	            String sql = "INSERT INTO c_user(login_id,name,birth_date,address,password,create_date,update_date)values (?,?,?,?,?,now(),now())";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, loginId);
	            pStmt.setString(2, name);
	            pStmt.setString(3, birth_date);
	            pStmt.setString(4, Address);
	            pStmt.setString(5, Common.encryption(password));

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
	     * ★データ更新
	     */
	    public void update(String loginId,String name,String Address,String birth_date,String password) {
	    	Connection conn = null;
	        try {
	            conn = DBManager.getConnection();

	            String sql ="UPDATE c_user SET name=?,birth_date=?,address=?,password=?,update_date=now() WHERE login_id =?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, name);
	            pStmt.setString(2, birth_date);
	            pStmt.setString(3, Address);
	            pStmt.setString(4, Common.encryption(password));
	            pStmt.setString(5, loginId);


	            int result = pStmt.executeUpdate();
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
	     * ★データ更新(パスワード以外のデータを更新)
	     */
	    public void update(String loginId,String name,String Address,String birth_date) {
	    	Connection conn = null;
	        try {
	            conn = DBManager.getConnection();

	            String sql ="UPDATE c_user SET name=?,birth_date=?,address=?,update_date=now() WHERE login_id =?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, name);
	            pStmt.setString(2, birth_date);
	            pStmt.setString(3, Address);
	            pStmt.setString(4, loginId);

	            int result = pStmt.executeUpdate();
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
	     * ★ユーザデータ削除
	     */
	    public void delete(String id){

	    	Connection conn = null;
	        try {

	            conn = DBManager.getConnection();
	            String sql = "DELETE FROM c_user WHERE user_id=?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, id);

	            int result = pStmt.executeUpdate();
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
	     * ★ユーザ詳細
	     */
	    public UserDataBeans findByUserDetail(String id) {

	        Connection conn = null;
	        try {
	            conn = DBManager.getConnection();
	            String sql = "SELECT * FROM c_user WHERE user_id = ? ";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, id);
	            ResultSet rs = pStmt.executeQuery();

	            if (!rs.next()) {
	                return null;
	            }

	            int Id = rs.getInt("user_id");
	            String loginIdData = rs.getString("login_id");
	            String nameData = rs.getString("name");
	            Date birthData = rs.getDate("birth_date");
	            String passWord = rs.getString("password");
	            String Addres = rs.getString("address");
	            String createData = rs.getString("create_date");
	            String updateData = rs.getString("update_date");

	            return new UserDataBeans(Id,loginIdData, nameData,birthData,passWord,Addres,createData,updateData);

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	    }

	    /**
	     * ★全てのユーザ情報を取得する
	     * @return
	     */
	    public List<UserDataBeans> findAll() {
	        Connection conn = null;
	        List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

	        try {
	            conn = DBManager.getConnection();
	            String sql = "SELECT * FROM c_user where login_id not in ('admin')";

	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                int id = rs.getInt("user_id");
	                String loginId = rs.getString("login_id");
	                String name = rs.getString("name");
	                Date birthDate = rs.getDate("birth_date");
	                String password = rs.getString("password");
	                String createDate = rs.getString("create_date");
	                String updateDate = rs.getString("update_date");
	                UserDataBeans user = new UserDataBeans(id, loginId, name, birthDate, password, createDate, updateDate);

	                userList.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	        return userList;
	    }

	}
