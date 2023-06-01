package command;

import dao.ModifyDao;
import servlet.RequestContext;
import servlet.ResponseContext;

public class ModifyDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		String[]nums=reqc.getParameter("NUM");
		String num = nums[0];
		
		ModifyDao md = new ModifyDao();
		md.
		resc.setTarget("modifyDetail");
		return resc;
	}
}