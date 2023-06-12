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
		String select = "SELECT AT.ATTRACTION_NUM, AT.ATTRACTION_NAME, AT.IMG_NAME "
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
				String path = "C:/Users/user/eclipse-workspace/ais_g2/image/"; 
				while(rs.next()) {
					pd = new Product();
					pd.setAnum(Integer.parseInt( rs.getString(1)));
					pd.setAtName(rs.getString(2));
					pd.setImgName(path+rs.getString(3));

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

	public ArrayList<Product> AttractionList(String keyName){
		String select = "SELECT ATTRACTION_NUM, ATTRACTION_NAME, IMG_NAME "
				+ "FROM ATTRACTION_TBL "
				+ "WHERE KEYWORD_NUM = (SELECT KEYWORD_NUM FROM KEYWORD_TBL WHERE KEYWORD_NAME = ?)";
			ArrayList<Product> list = new ArrayList<Product>();
			Product pd = null;
			try {
				System.out.println(keyName);
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"hr","hr");
				pstmt = conn.prepareStatement(select);
				pstmt.setString(1, keyName);
				rs = pstmt.executeQuery();
				String path = "C:/Users/user/eclipse-workspace/ais_g2/image/"; 
				while(rs.next()) {
					pd = new Product();
					pd.setAnum(Integer.parseInt( rs.getString(1)));
					pd.setAtName(rs.getString(2));
					pd.setImgName(path+rs.getString(3));
					list.add(pd);
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
}
	