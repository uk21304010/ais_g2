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

	public ArrayList<Product> showDetail(int num) {
		String select = " select attraction_name,Attraction_Con,Img_Name "
				+ " from Keyword_tbl kt, Attraction_tbl at "
				+ " where at.keyword_num = kt.keyword_Num and kt.keyword_num='?'";

		ArrayList<Product> showDetail = new ArrayList<Product>();
			
		
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url,"hr","hr");
			st=cn.prepareStatement(select);
			st.setInt(1, num);
			rs=st.executeQuery();
			
				while(rs.next()) {
					Product product = new Product();
					product.setTitlePlace(rs.getString(1));
					product.setDetailContent(rs.getString(2));
					product.setThumbnailScreen(rs.getString(3));
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
		return showDetail; //내가 쓸 처리가 있는 Command로 이게 이동 
	}
}
