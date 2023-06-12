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

		ArrayList<Product> list = new ArrayList<Product>();
		String [] keyNumse = reqc.getParameter("keyNum");
		String [] keyNamse = reqc.getParameter("keyName");

		if(keyNumse==null) {
			String keyName = keyNamse[0];
			ListInfoDao ld = new ListInfoDao();
			list = ld.AttractionList(keyName);
		}else{
			Integer keyNum = Integer.parseInt(keyNumse[0]);
			ListInfoDao ld = new ListInfoDao();
			list = ld.AttractionList(keyNum);
		}

//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		resc.setResult(list); 
		resc.setTarget("list");
		return resc;
	}
}
