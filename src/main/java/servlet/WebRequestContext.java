package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import dto.Product;
@MultipartConfig
public class WebRequestContext implements RequestContext{
	private Map parameters;
	private Map<String, String[]> postParameters;
    private HttpServletRequest request;
    private String filePath;
    private String fileName; 
    private HttpServletRequest imgRequest;
    public WebRequestContext(){}

    public String getCommandPath(){
        
        String servletPath=request.getServletPath();
        String commandPath=servletPath.substring(1);
        return commandPath;
    }
    public void setRequest(Object req){//1. 여기가  파라미터를 보내면 받는 곳
    	request = (HttpServletRequest)req;

		try {
			imgRequest = new BufferedServletRequestWrapper((HttpServletRequest)req);
		} catch (IOException e) {
			e.printStackTrace();
		}
	parameters = request.getParameterMap();
	postParameters = getPostParameter();
    }
    public Map<String, String[]> getPostParameter() {
    	Map<String, String[]> map = new HashMap();
    	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		sf.setHeaderEncoding("UTF-8");

		List<FileItem> items;
		try {
			InputStream inputStream = imgRequest.getInputStream();
			items = sf.parseRequest(new ServletRequestContext(imgRequest));

			for (FileItem item : items) {
			    if (item.isFormField()) {
			        String name = item.getFieldName();
			        String[] value = {item.getString("UTF-8")};
			        map.put(name, value);
			    }
			}
		} catch (FileUploadException e) {
			System.out.println("post");
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		return map;
	}
    public String[] getParameter(String key){
        return (String[])parameters.get(key);
    }

    public Object getRequest(){
        return request;
    }
    public String[] postParameter(String key) {
    	return (String[])postParameters.get(key);
    }

    public boolean uploadFile() {
    	System.out.println("upload");
		Boolean flag = false;
    	String paths = request.getRealPath("image");
    	System.out.println(paths);
    	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
    	//String paths = "C:\\Users\\user\\eclipse-workspace\\ais_g2\\src\\main\\webapp\\image";
    	try {
    		List<FileItem> files =sf.parseRequest(imgRequest);
            System.out.println(files);
             for (FileItem fileItem : files) {
            	 if(!fileItem.isFormField()) {
            		 String fileName = new File(fileItem.getName()).getName();
            		 setFileName(fileName);

            		 System.out.println("filename" + fileName);
            		 System.out.println("filepath" + paths);

            		 String filePath = paths + File.separator + fileName;
            		 setFilePath(filePath);
            		 System.out.println(filePath);
            		 File file = new File(filePath);

            		 if(file.exists()) {

            		 }else {
            			 System.out.println("?");
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
    	System.out.println(flag);
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
