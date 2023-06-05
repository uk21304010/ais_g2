package servlet;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import dto.Product;

public class WebRequestContext implements RequestContext{
    private Map parameters;
    private HttpServletRequest request;
    public WebRequestContext(){}

    public void setRequest(Object req){
        request=(HttpServletRequest) req;//陞溽判辟嗷equest邵ｺ�ｽｫ郢晢ｽｪ郢ｧ�ｽｯ郢ｧ�ｽｨ郢ｧ�ｽｹ郢晏沺繝･陜｣�ｽｱ髫ｪ�ｽｭ陞ｳ�ｿｽ
        parameters=request.getParameterMap();//陞溽判辟嗔arameters邵ｺ�ｽｫrequest邵ｺ�ｽｮ郢昜ｻ｣ﾎ帷ｹ晢ｽ｡郢晢ｽｼ郢ｧ�ｽｿ郢ｧ遏･apping邵ｺ蜉ｱ窶ｻ髫ｪ�ｽｭ陞ｳ�ｿｽ
    }
    public String getCommandPath(){
        //陞溽判辟嗷equest邵ｺ�ｽｫ邵ｺ繧��ｽ狗ｹ晢ｽｪ郢ｧ�ｽｯ郢ｧ�ｽｨ郢ｧ�ｽｹ郢晏現�ｿｽ�ｽｮServletPath郢ｧ蜻域ｭ楢怎�ｽｺ
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
    public boolean uploadFile(String path) {
		Boolean flag = false;
    	//String imgPath = request.getRealPath("images");
    	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
    	String paths = "/home/ec2-user/Bloom/images" + path;
    	try {
            List<FileItem> files =sf.parseRequest(imgRequest);
             for (FileItem fileItem : files) {
            	 if(!fileItem.isFormField()) {
            		 String fileName = fileItem.getName();
            		 setFileName(fileName);

            		 System.out.println("�t�@�C�����F" + fileName);
            		 System.out.println("�ۑ���p�X�F" + paths);

            		 String filePath = paths + File.separator + fileName;
            		 setFilePath(filePath);
            		 System.out.println(filePath);
            		 File file = new File(filePath);

            		 if(file.exists()) {

            		 }else {

            			 fileItem.write(file);
            			 flag = true;
            		 }
            	 }
             }
         } catch (FileUploadException ex) {
             ex.printStackTrace();
         } catch (Exception ex) {
             ex.printStackTrace();
         }
    	 return flag;
    }
    public void setSessionParameter(String key, Product value) {
		Map parameter = new HashMap();
		parameter.put(key, value);
		request.getSession().setAttribute("session", parameter);
		
	}
}
