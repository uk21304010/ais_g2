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
	public int getNumber(String s) {
		String sql = "Select KEYWORD_NUM from KEYWORD_TBL where KEYWORD_NAME = ?";
		int i = 0;
		try{

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(LOCAL,USER,PASS);
			
			st = con.prepareStatement(sql);
			st.setString(1, s);
			rs = st.executeQuery();

			rs.next();
			i = Integer.parseInt(rs.getString(1));
			
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
	public void updateDetail(Product p,int anum,int knum) {
		try{
			con = ConnectionManager.getInstance().getConnection();
			String sql = "update ATTRACTION_TBL set ATTRACTION_NAME = ?,ATTRACTION_CON = ?, IMG_NAME =?, KEYWORD_NUM=? where ATTRACTION_NUM=? ";
			st = con.prepareStatement(sql);
			
			st.setString(1, p.getPid());
			st.setString(2, p.getName());
			st.setString(3, p.getPrice());
			st.setInt(4, knum);
			st.setInt(5, anum);
			
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
	public void setDetail(Product p,int anum,int knum) {
		try{
			con = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO ATTRACTION_TBL VALUES (?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, anum);
			st.setString(2, p.getPid());
			st.setString(3, p.getName());
			st.setString(4, p.getPrice());
			st.setInt(5, knum);
			
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
		int i=0;
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
	public Product getDetail(int num) {
		String sql = "Select ATTRACTION_NAME,ATTRACTION_CON,IMG_NAME from ATTRACTION_TBL where ATTRACTION_NUM = ?";
		Product p =new Product();
		try{

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(LOCAL,USER,PASS);
			
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			
			rs = st.executeQuery();

			rs.next();

			p.setName(rs.getString(1));
			p.setCon(rs.getString(2));
			p.setImg(rs.getString(3));
			p.setAnum(num);
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
		return p;		
	}
}
	