package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;

public class ContentInfoDao{
	private Connection cn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@//localhost:1521/xe";

	public ArrayList<Product> showSub (String code) {
		String select ="select KEYWORD_NUM, KEYWORD_NAME from KEYWORD_TBL " +
								"where THEME_CODE = ?"; 
		
		ArrayList<Product> showSub = new ArrayList<Product>(); 
		
		try { 
			Class.forName(driver);
			cn=DriverManager.getConnection(url,"hr","hr");
			st=cn.prepareStatement(select); 
			st.setString(1, code); 
			rs=st.executeQuery();
		
			while(rs.next()) {
				Product product = new Product();
				product.setAtNum(rs.getInt(1));
				product.setName(rs.getString(2));
				showSub.add(product); 
			}
		}catch(Exception e) { 
			e.printStackTrace(); 
		}finally { 
			try { 
				rs.close();
				st.close();
				cn.close(); 
			}catch(Exception e) {
				} 
			} 
		return showSub; 
		}

	public ArrayList<Product> showDetail(int num) {
		String select = " select at.attraction_name,at.attraction_con, at.img_name "
				+ " from keyword_tbl kt, attraction_tbl at "
				+ " where at.keyword_num = kt.keyword_num and at.attraction_num= ? ";

		ArrayList<Product> showDetail = new ArrayList<Product>();
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url,"hr","hr");
			st=cn.prepareStatement(select);
			st.setInt(1, num);
			rs=st.executeQuery();

			String path = "image\\";

				while(rs.next()) {
					Product product = new Product();
					product.setTitlePlace(rs.getString(1));
					product.setDetailContent(rs.getString(2));
					product.setThumbnailScreen(path+rs.getString(3));
					showDetail.add(product);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); st.close(); cn.close();
				}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return showDetail; 
	}

}
