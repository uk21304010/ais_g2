package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;

public class ListInfoDao{
	final private String driver = "oracle.jdbc.OracleDriver";
	final private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	public ArrayList<Product> AttractionList(Integer keyNum){
		String select = "SELECT AT.ATTRACTION_NAME, AT.IMG_NAME, KT.KEYWORD_NAME "
				+ "FROM ATTRACTION_TBL AT, KEYWORD_TBL KT "
				+ "WHERE AT.KEYWORD_NUM = KT.KEYWORD_NUM "
				+ "AND KT.KEYWORD_NUM = ?";
			ArrayList<Product> list = new ArrayList<Product>();
			Product pd = null;
			try {
				System.out.println(keyNum);
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"hr","hr");
				pstmt = conn.prepareStatement(select);
				pstmt.setInt(1, keyNum);
				System.out.println(pstmt);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					pd = new Product();
					pd.setAtName(rs.getString(1));
					pd.setImgName(rs.getString(2));
					pd.setKeyName(rs.getString(3));
					list.add(pd);
					for(int i = 0; i<list.size(); i++) {
						System.out.println(list.get(i));
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				}catch(Exception e) {
					
				}
			}
		return list;
	}
	
	public ArrayList<Product> asdasd() {
		String select = "Select KEYWORD_NUM, KEYWORD_NAME from KEYWORD_TBL";
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"hr","hr");
			pstmt = conn.prepareStatement(select);
			ResultSet result = pstmt.executeQuery(select);
			
			while (result.next()) {
				Product pt = new Product();
				pt.setA_keyNum(result.getInt("KEYWORD_NUM"));
				pt.setName(result.getString("KEYWORD_NAME"));
				
				list.add(pt);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		

		return list;
		

	}
}
	