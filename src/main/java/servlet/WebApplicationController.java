package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AbstractCommand;
import command.CommandFactory;

public class WebApplicationController implements ApplicationController{
    public RequestContext getRequest(Object request){
        RequestContext reqc=new WebRequestContext();
        reqc.setRequest(request);//
        return reqc;
    }
    public ResponseContext handleRequest(RequestContext req){// 여기가 2번째 
   //우리가 처리를 해야할 Command를 찾아서, 처리를 한다. 
        AbstractCommand command = CommandFactory.getCommand(req);//얘는 처리해야할 Command들의 이름을 찾는 것.
        command.init(req);//
        ResponseContext resc = command.execute(new WebResponseContext());//이름을 찾아서 처리해야 할 Command를 찾아서
        //resc에 결과를 담아서 되돌려준다. FrontServlet으로 ..
        return resc;
    }
    public void handleResponse(RequestContext reqc, ResponseContext resc){ //Command(DAO)에서 설정한 값을 여기로 불러서재설정
        HttpServletRequest req= (HttpServletRequest) reqc.getRequest();//繝ｪ繧ｯ繧ｨ繧ｹ繝域ュ蝣ｱ
        HttpServletResponse res= (HttpServletResponse) resc.getResponse();//繝ｬ繧ｹ繝昴Φ繧ｹ諠�蝣ｱ

        req.setAttribute("result",resc.getResult());//ResponscContext縺ｧ邨先棡蜿門ｾ励＠縺ｦ險ｭ螳�
        RequestDispatcher rd = req.getRequestDispatcher(resc.getTarget());//ResponscContext縺ｧ螳帛�医ｒ蜿門ｾ励＠縺ｦ險ｭ螳�

        try{
            rd.forward(req, res);
        }catch(ServletException e){

        }catch(IOException e){}
    } 
}
