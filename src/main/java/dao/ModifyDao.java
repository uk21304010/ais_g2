package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Product;

public class ModifyDao{
	private static final String LOCAL = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	private static final String USER = "hr";
	private static final String PASS = "hr";
	private Connection con = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	//String s;
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

		}catch(Exception e) {
			e.printStackTrace();
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
			String sql2 = "update ATTRACTION_TBL set ATTRACTION_NAME = ?,ATTRACTION_CON = ?, KEYWORD_NUM=? where ATTRACTION_NUM=? ";
			if(p.getThumbnail()==null) {
			st = con.prepareStatement(sql2);
			
			st.setString(1, p.getName());
			st.setString(2, p.getCon());
			st.setInt(3, knum);
			st.setInt(4, anum);
			
			st.executeUpdate();
			con.commit();
			}else {
				st = con.prepareStatement(sql);
				
				st.setString(1, p.getName());
				st.setString(2, p.getCon());
				st.setString(3, p.getThumbnail());
				st.setInt(4, knum);
				st.setInt(5, anum);
				
				st.executeUpdate();
				con.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
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
			st.setString(2, p.getName());
			st.setString(3, p.getCon());
			st.setString(4, p.getThumbnail());
			st.setInt(5, knum);
			
			st.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean deleteAttraction(int atNum) {
		String delete = "DELETE FROM ATTRACTION_TBL "
				+ "WHERE ATTRACTION_NUM = ? ";
		//Product pd = null;
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(LOCAL,USER,PASS);
			st = con.prepareStatement(delete);
			st.setInt(1, atNum);
			st.executeUpdate();
			con.commit();
			result = true;

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close(); st.close();
			}catch(Exception e) {}
		}
		return result;
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
	