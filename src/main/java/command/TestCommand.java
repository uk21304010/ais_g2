package command;

import servlet.RequestContext;
import servlet.ResponseContext;


public class TestCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("test");
		return resc;
		
	
	}
}