package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Product;

public class ModifyDao{
	private static  String LOCAL = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	private static String USER = "hr";
	private static String PASS = "hr";
	private static Connection con = null;
	//private static ConnectionManager manager = null;

	private PreparedStatement st = null;
	private ResultSet rs = null;
	String s;
	int i;
	public String getNumber(String s) {
		String sql = "Select KEYWORD_NUM from KEYWORD_TBL where KEYWORD_NAME = ?";
		try{

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(LOCAL,USER,PASS);
			
			st = con.prepareStatement(sql);
			st.setString(1, s);
			rs = st.executeQuery();

			rs.next();
			s = rs.getString(1);
			
			//ConnectionManager.getInstance().commit();

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
		return s;
	}
	
	public void setDetail(Product p,int anum,String knum) {
		try{
			con = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO ATTRACTION_TBL VALUES (?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, anum);
			st.setString(2, p.getPid());
			st.setString(3, p.getName());
			st.setString(4, p.getPrice());
			st.setInt(5, Integer.parseInt(knum));
			
			st.executeUpdate();
			con.commit();
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
	public int getANum() {
		String sql = "Select max(attraction_num) from ATTRACTION_TBL";
		try{

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(LOCAL,USER,PASS);
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			rs.next();
			
			
			i =rs.getInt(1)+1;
			//ConnectionManager.getInstance().commit();

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
		return i;
	}
	public int getContent(String s) {
		String sql = "Select max(attraction_num) from ATTRACTION_TBL";
		try{

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(LOCAL,USER,PASS);
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			rs.next();
			
			
			i =rs.getInt(1)+1;
			//ConnectionManager.getInstance().commit();

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
		return i;
	}
}
	