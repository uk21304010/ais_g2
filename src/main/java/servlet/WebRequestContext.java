package servlet;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext{
    private Map parameters;
    private HttpServletRequest request;
    public WebRequestContext(){}

    public void setRequest(Object req){//1. 여기가  파라미터를 보내면 받는 곳
        request=(HttpServletRequest) req;
        parameters=request.getParameterMap();
    }
    public String getCommandPath(){
        //螟画焚request縺ｫ縺ゅｋ繝ｪ繧ｯ繧ｨ繧ｹ繝医�ｮServletPath繧呈歓蜃ｺ
        String servletPath=request.getServletPath();
        String commandPath=servletPath.substring(1);
        return commandPath;
    }
    public String[] getParameter(String key){
        return (String[])parameters.get(key);
    }
    public Object getRequest(){ //setReques에서 설정한 것이 여기로 나온다. 
        return request;
    }    
}
