package servlet;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext{
    private Map parameters;
    private HttpServletRequest request;
    public WebRequestContext(){}

    public void setRequest(Object req){
        request=(HttpServletRequest) req;//螟画焚request縺ｫ繝ｪ繧ｯ繧ｨ繧ｹ繝域ュ蝣ｱ險ｭ螳�
        parameters=request.getParameterMap();//螟画焚parameters縺ｫrequest縺ｮ繝代Λ繝｡繝ｼ繧ｿ繧知apping縺励※險ｭ螳�
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
    public Object getRequest(){
        return request;
    }    
}
