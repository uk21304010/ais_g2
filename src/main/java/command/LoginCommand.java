package command;

import servlet.RequestContext;
import servlet.ResponseContext;

public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("login");
		return resc;
	}
}