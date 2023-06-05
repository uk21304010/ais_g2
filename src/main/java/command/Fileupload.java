package command;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class Fileupload {
	 public String upload(MultipartHttpServletRequest mre, HttpServletRequest req){
	        
	        MultipartFile mf = mre.getFile("file"); // jsp file name mapping
	        String uploadPath = "";
	        
	        String path = "C:\\"+"upload\\"+"test\\"; // 파일 업로드 경로
	            
	        String original = mf.getOriginalFilename(); // 업로드하는 파일 name
	            
	        System.out.println("!!!!!!!!!!"+test);        // text value
	        System.out.println("!!!!!!!!!!"+original);    // file original name
	        System.out.println("!!!!!!!!!!"+mf.getSize());// file size
	            
	        uploadPath = path+original; // 파일 업로드 경로 + 파일 이름
	        
	        
	        try {
	            mf.transferTo(new File(uploadPath)); // 파일을 위에 지정 경로로 업로드
	        } catch (IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        return "";
	    }
}
