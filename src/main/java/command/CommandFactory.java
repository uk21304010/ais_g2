package command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import servlet.RequestContext;

public abstract class CommandFactory{
	public static AbstractCommand getCommand(RequestContext rc){
		AbstractCommand command = null;
		Properties prop = new Properties();
		
		try{
				
<<<<<<< HEAD
			prop.load(new FileInputStream("C:\\Users\\AIS-N\\eclipse-workspace\\ais_g2\\src\\main\\java\\command\\commands.properties"));
=======
			prop.load(new FileInputStream("C:\\Eclipse-workspace\\ais_g2\\src\\main\\java\\command\\commands.properties"));
>>>>>>> a9746dcdad974bc570ffe8d0277b74bab3a8345a

			String name = prop.getProperty(rc.getCommandPath());

			Class c = Class.forName(name);
			command = (AbstractCommand) c.newInstance();
		}catch(FileNotFoundException e){
			throw new RuntimeException(e.getMessage(),e);			
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(InstantiationException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e.getMessage(),e);
		}
		return command;
	}
}