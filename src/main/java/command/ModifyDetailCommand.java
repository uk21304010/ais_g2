package command;

import dao.ModifyDao;
import servlet.RequestContext;
import servlet.ResponseContext;

public class ModifyDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		String[]nums=reqc.getParameter("NUM");
		int num = Integer.parseInt(nums[0]);
		
		ModifyDao md = new ModifyDao();
		
		resc.setResult(md.getDetail(num));
		resc.setTarget("modifyDetail");
		return resc;
	}
}