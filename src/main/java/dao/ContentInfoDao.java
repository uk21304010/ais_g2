package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContentInfoDao{
	private Connection cn = null;
	private PreparedStatement st = null;

	public void showDetail() {
		try{
			cn = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO `favorite_table` VALUES (?,?);";
			st = cn.prepareStatement(sql);


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
	