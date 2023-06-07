package command;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import dao.ListInfoDao;
import dto.Product;
import servlet.RequestContext;
import servlet.ResponseContext;

public class ListCommand extends AbstractCommand {
public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		
		String [] keyNumse = reqc.getParameter("keyNum");
		Integer keyNum = Integer.parseInt(keyNumse[0]);
		System.out.println(keyNum);
		ListInfoDao ld = new ListInfoDao();
		ArrayList<Product> list = ld.AttractionList(keyNum);
		
		System.out.println(list);
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		resc.setResult(list); 
		resc.setTarget("list");
		return resc;
	}
}
