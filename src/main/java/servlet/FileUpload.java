package servlet;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {
	public boolean uploadFile(String path, RequestContext reqc) {
    	HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
    	String imgPath = req.getRealPath("image");
    	System.out.println(imgPath);
    	System.out.println("aa");
    	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
    	String paths = "C:\\Users\\user\\eclipse-workspace\\ais_g2\\src\\main\\webapp\\image";
    	try {
             List<FileItem> files =sf.parseRequest(req);
             System.out.println(files);
             for (FileItem fileItem : files) {
            	 System.out.println(paths + fileItem.getName());
                 fileItem.write(new File(paths + fileItem.getName()));
             }
         } catch (FileUploadException ex) {
             System.err.println("アップロードのエラーです");
             ex.printStackTrace();
         } catch (Exception ex) {
             System.err.println("エラーです");
             ex.printStackTrace();
         }
    	 return false;
    }
}
