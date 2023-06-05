package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Product;

public class ModifyDao{
	final private String driver = "oracle.jdbc.OracleDriver";
	final private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public boolean deleteAttraction(int atNum) {
		String delete = "DELETE FROM ATTRACTION_TBL "
				+ "WHERE ATTRACTION_NUM = ? ";
		//Product pd = null;
		boolean result = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "hr","hr");
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, atNum);
			pstmt.executeUpdate();
			conn.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close(); pstmt.close();
			}catch(Exception e) {}
		}
		
		return result;
	}
}
	