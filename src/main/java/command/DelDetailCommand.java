package command;

import dao.ModifyDao;
import servlet.RequestContext;
import servlet.ResponseContext;

public class DelDetailCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		String [] atNumse = reqc.getParameter("ATNUM");
		Integer atNum = Integer.parseInt(atNumse[0]);
		ModifyDao md = new ModifyDao();
		boolean result = md.deleteAttraction(atNum);
		System.out.println("boolean is : " + result);
		ListCommand lc = new ListCommand();
		
		resc.setResult(result);
		resc.setTarget("deletePopup");
		return resc;
	}
}
