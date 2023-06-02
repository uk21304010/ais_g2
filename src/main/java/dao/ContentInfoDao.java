package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContentInfoDao{
	private Connection cn = null;
	private PreparedStatement st = null;
	
	public void showDetail() {
		try {
		cn = ConnectionManager.getInstance().getConnection();
		String sql = " select attraction_name,Attraction_Con,Img_Name "
				+ " from Keyword_tbl kt, Attraction_tbl at "
				+ " where at.keyword_num = kt.keyword_Num and kt.keyword_num='?'";
		
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
	