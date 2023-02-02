package com.springboot.api_crud.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	

	public final String UPLOAD_DIR="D:\\Api_Crud_Boot\\src\\main\\resources\\static\\images";
	public boolean fileStatus(MultipartFile  file) {
		boolean f=false;
		try {
			//Method 1
			
//		  InputStream in=	file.getInputStream();
//		  byte data[]=new byte[in.available()];
//		  in.read(data);
//		  FileOutputStream out =new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//		  out.write(data);
//		  out.flush();
//		  out.close();
			
			//Method 2
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()) ,StandardCopyOption.REPLACE_EXISTING);
			
		  f=true;
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return f;
	}
}
