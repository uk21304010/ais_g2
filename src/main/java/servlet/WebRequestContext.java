package servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import dto.Product;

public class WebRequestContext implements RequestContext{
	private Map parameters;
	private Map<String, String[]> postParameters;
    private HttpServletRequest request;
    private String filePath;
    private String fileName; 
    private HttpServletRequest imgRequest;
    public WebRequestContext(){}

    public void setRequest(Object req){
    	request = (HttpServletRequest)req;
    	parameters=request.getParameterMap();
    	postParameters=request.getParameterMap();
		try {
			imgRequest = new BufferedServletRequestWrapper((HttpServletRequest)req);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public String[] getParameter(String key){
        return (String[])parameters.get(key);
    }
    public String[] postParameter(String key) {
    	return (String[])postParameters.get(key);
    }
    public String getCommandPath(){
    	String servletPath=request.getServletPath();
        String commandPath=servletPath.substring(1);
        return commandPath;
    }
    public Object getRequest(){
        return request;
    } 
    public boolean uploadFile() {
		Boolean flag = false;
    	//String imgPath = request.getRealPath("images");
    	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
    	String paths = "C:\\Users\\user\\eclipse-workspace\\ais_g2\\src\\main\\image";
    	try {
            List<FileItem> files = sf.parseRequest(new ServletRequestContext(request));
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
    private void setFileName(String fileName) {
    	this.fileName = fileName;
		
	}
    public String getFileName() {
		return fileName;
	}
    public void setFilePath(String path) {
    	filePath = path;
    }
	public void setSessionParameter(String key, Product value) {
		Map parameter = new HashMap();
		parameter.put(key, value);
		request.getSession().setAttribute("session", parameter);
		
	}
}
