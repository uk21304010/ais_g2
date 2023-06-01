package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao{
	private Connection cn = null;
	private PreparedStatement st = null;

	public void checkId(String productId, int userId) {
		try{
			cn = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO `favorite_table` VALUES (?,?);";
			st = cn.prepareStatement(sql);


			st.setInt(2, Integer.parseInt(productId));

            int result = st.executeUpdate();
		

		}catch(SQLException e) {
			e.printStackTrace();
			ConnectionManager.getInstance().rollback();
		}catch(Exception e) {
			e.printStackTrace();
			ConnectionManager.getInstance().rollback();
	}finally {
			if(st != null) {
				try {
					st.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
	