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
        reqc.setRequest(request);//RequestContext縺ｫ迴ｾ蝨ｨ縺ｮ繝ｪ繧ｯ繧ｨ繧ｹ繝�(request)諠�蝣ｱ繧定ｨｭ螳�
        return reqc;
    }
    public ResponseContext handleRequest(RequestContext req){
        AbstractCommand command = CommandFactory.getCommand(req);//繝ｪ繧ｯ繧ｨ繧ｹ繝�(req)縺ｧclassName繧呈歓蜃ｺ縺励※蜃ｦ逅�class繧定ｭ伜挨
        command.init(req);//
        ResponseContext resc = command.execute(new WebResponseContext());//蜃ｦ逅�縺励※邨先棡繧坦esponse縺ｫ險ｭ螳�
        return resc;
    }
    public void handleResponse(RequestContext reqc, ResponseContext resc){
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
