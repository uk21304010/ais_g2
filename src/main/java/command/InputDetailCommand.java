package command;

import servlet.RequestContext;
import servlet.ResponseContext;

public class InputDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

		String[]names=reqc.getParameter("NUM");
		String name = names[0];
		System.out.println(name);
		resc.setTarget("inputDetail");
		return resc;
	}
}