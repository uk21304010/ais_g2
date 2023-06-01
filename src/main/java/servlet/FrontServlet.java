package servlet;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;



public class FrontServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
			doPost(req, res);
		}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException{
        	req.setCharacterEncoding("Windows-31J");

			ApplicationController app =new WebApplicationController();

			RequestContext reqc =app.getRequest(req);//郢晢ｽｪ郢ｧ�ｽｯ郢ｧ�ｽｨ郢ｧ�ｽｹ郢晏沺繝･陜｣�ｽｱ髫ｪ�ｽｭ陞ｳ�ｿｽ

			ResponseContext resc = app.handleRequest(reqc);//陷�ｽｦ騾��ｿｽ

			resc.setResponse(res);

			app.handleResponse(reqc, resc);
    }
}