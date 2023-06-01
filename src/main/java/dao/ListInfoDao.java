package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListInfoDao{
	private Connection cn = null;
	private PreparedStatement st = null;

	public void setFavorite(String productId, int userId) {
		try{
			cn = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO `favorite_table` VALUES (?,?);";
			st = cn.prepareStatement(sql);

			st.setInt(1, userId);
			st.setInt(2, Integer.parseInt(productId));

            int result = st.executeUpdate();

			ConnectionManager.getInstance().commit();

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
	