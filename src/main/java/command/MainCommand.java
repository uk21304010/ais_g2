package command;

import servlet.RequestContext;
import servlet.ResponseContext;

<<<<<<<< HEAD:src/main/java/command/LoginCommand.java
public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("login");
========
public class MainCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("main");
>>>>>>>> 95a8a3d10af4e580d7b3757042fa899edf9573ff:src/main/java/command/MainCommand.java
		return resc;
	}
}