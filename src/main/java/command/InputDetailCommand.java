package command;

import servlet.RequestContext;
import servlet.ResponseContext;

public class InputDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

		resc.setTarget("inputDetail");
		return resc;
	}
}