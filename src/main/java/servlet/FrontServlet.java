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
        	req.setCharacterEncoding("UTF-8");

			ApplicationController app =new WebApplicationController();

			RequestContext reqc =app.getRequest(req);//여기까지 온 애들을 이제 적재함 진짜 찐으로 보내기 전에 준비완료 하는 곳 

			ResponseContext resc = app.handleRequest(reqc);//3번째가 여기
			//WebApplication에서 이름 조회해서 Command에다 담아서 보내고 받는곳이 여기다.
			//밑에서 set으로 보내기 전에 어디로 보내야될지 방향까지 설정 

			resc.setResponse(res);

			app.handleResponse(reqc, resc);
    }
}