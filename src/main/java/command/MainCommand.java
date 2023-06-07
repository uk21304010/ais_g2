package command;

import servlet.ResponseContext;

public class MainCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("main");
		return resc;
	}
}