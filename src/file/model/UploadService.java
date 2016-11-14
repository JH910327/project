package file.model;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import pojo.FileObj;
import pojo.files;

@Component
public class UploadService {
	
	/*
	 * 	1. 중복파일은 어떻게 처리하죠? 
	 * 		! UUID라는 클래스를 사용합니다. 
	 * 	2. 사용자들이 업로드시킨 파일들을 특정 경로에다가 지정해야 하는가? 
	 * 		! Project내에 getRealPath로 저장하면 된다.
	 */
	
	@Autowired
	ServletContext application;
	@Autowired
	SqlSessionFactory fac;
	
	public boolean exupDB(FileObj fi){
		SqlSession sql = fac.openSession();
		boolean r = false;
		try{
			int r1 = sql.insert("fileUp",fi);
			if(r1 == 1){
				sql.commit();
				r = true;
			}else{
				sql.rollback();
			}
		}catch(Exception e){
			sql.rollback();
		}
		sql.close();
		return r;
	}
	
	public FileObj exUp(MultipartFile f){
		if(f.isEmpty())
			return null;
		
		FileObj fi = new FileObj(); 
		try{	
			String uid = UUID.randomUUID().toString();
			String fileuid = uid.substring(0,23);
			String fileDir=application.getRealPath("/files");
			String filename = f.getOriginalFilename();
			long filesize = f.getSize();

			File dest = new File(fileDir,fileuid);
			System.out.println(fileDir);
			f.transferTo(dest);
			
			fi.setFilename(filename);
			fi.setFileuuid(fileuid);
			fi.setFilesize(filesize);
			return fi;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	// WEB-INF/files에다가 저장해도 무관.
	// 빨간줄? application이 있으면 was의 위치를 알아내 파일을 저장할 수 있다. 
	// 그러나.. java에서는 Application이 없다. 
	// 사용하는 유일한 방법은? Autowired! 
	//S
	
	public boolean exUpOld(MultipartFile f){
		//얻어낼 수 있는 정보들은? 
		// 
		try{
			boolean b = f.isEmpty();
			InputStream is = f.getInputStream(); // 임시파일에서 inputStream을 얻어낼 수 있다. 
			String ct = f.getContentType();
			String filename = f.getOriginalFilename();	// 올려준 파일 이름
			String name = f.getName();
			long size = f.getSize();
			File dest = new File("d:/file",filename);
			f.transferTo(dest);	// 이것이 저장위치에 업로드시키는 메서드다. 
			
			/*
			System.out.println("isEmpty?"+b);
			System.out.println("contentType?"+ct);
			System.out.println("filename="+filename+" / name="+name);
			System.out.println("size?"+size);
			*/
			
			return true;
		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
