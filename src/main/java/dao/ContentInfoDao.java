package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import dto.Product;

public class ContentInfoDao{
	private Connection cn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@//localhost:1521/xe";

	public static List<Integer> getRandomNumbers(int min, int max, int count) {
		Random random = new Random();
		List<Integer> randomNumbers = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			int randomNumber = random.nextInt(max - min + 1) + min;
			System.out.println("난수생성하기");
			randomNumbers.add(randomNumber);
		}

		return randomNumbers;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	


	public static ArrayList main(String nums) {
		int min = 100;
		int max = 105;
		int count = 4;
System.out.println("난수받기");
		List<Integer> main = getRandomNumbers(min, max, count);
		return (ArrayList) main;
	}
	

/////////////////////////////////////////////////////	

	public ArrayList<Product> showSub (String nums) {
		String select = " select attraction_num, img_name from attraction_Tbl where attraction_num = ? or "
				+ " attraction_num = ? or attraction_num = ? or attraction_num =? ";
		ArrayList<Product> showSub = new ArrayList<Product>();

		try {
				Class.forName(driver);
				cn=DriverManager.getConnection(url,"hr","hr");
				st=cn.prepareStatement(select);
				ArrayList numbox = main(nums);
				for (int i = 0; i < numbox.size(); i++) {
				    int number = (int) numbox.get(i);
				    // 반복문 내에서 요소에 대한 작업 수행
				    System.out.println(number);
				}
				rs=st.executeQuery();
				
				while(rs.next()) {
					Product product = new Product();
					product.setSubthumbScreen(rs.getString(1));
					product.setSubthumbScreen(rs.getString(2));
					product.setSubthumbScreen(rs.getString(3));
					product.setSubthumbScreen(rs.getString(4));
					showSub.add(product);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); st.close(); cn.close();
			}catch(Exception e) {}
		}
		return showSub;
	}
	private PreparedStatement setString(int i, String string) {
	// TODO Auto-generated method stub
	return null;
}
	public ArrayList<Product> showDetail(int num) {
		String select = " at.attraction_name,at.attraction_con, at.img_name "
				+ " from keyword_tbl kt, attraction_tbl at "
				+ " where at.keyword_num = kt.keyword_num and at.attraction_num = ? ";

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
