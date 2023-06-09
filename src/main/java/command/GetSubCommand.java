package command;

import dao.ContentInfoDao;
import servlet.RequestContext;
import servlet.ResponseContext;

public class GetSubCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

		String[]numbers = reqc.getParameter("NUM");
		String number = numbers[0];
		ContentInfoDao db = new ContentInfoDao();
		System.out.println("나오니");
		resc.setResult(db.showSub(number));	
		resc.setTarget("subResult");
		return resc;
	}
}
