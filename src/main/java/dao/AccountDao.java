package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Product;

public class AccountDao{

	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public boolean checkId(String id, String pass) {
		boolean check = false;
		try{
			cn = ConnectionManager.getInstance().getConnection();

			String sql = "select count(*) from ADMIN_ACCOUNT_TBL where PASSWORD = ? and ACC_NAME = ?";

			st = cn.prepareStatement(sql);

			st.setString(1, pass);
			st.setString(2, id);

			rs = st.executeQuery();

			rs.next();
			if(rs.getInt(1) == 1) {
				check = true;
			}
			System.out.println(check);

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
		return check;
	}
	public Product getUser(String id, String pass) {
		Product p = new Product();
		try{
			cn = ConnectionManager.getInstance().getConnection();
			String sql = "select * from ADMIN_ACCOUNT_TBL where PASSWORD = ? and ACC_NAME = ?";
			st = cn.prepareStatement(sql);

			st.setString(1, pass);
			st.setString(2, id);

			rs = st.executeQuery();

			rs.next();
			p.setId(rs.getString(1));
			p.setPass(rs.getString(2));

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
		return p;
	}
}
	