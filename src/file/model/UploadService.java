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
	 * 	1. �ߺ������� ��� ó������? 
	 * 		! UUID��� Ŭ������ ����մϴ�. 
	 * 	2. ����ڵ��� ���ε��Ų ���ϵ��� Ư�� ��ο��ٰ� �����ؾ� �ϴ°�? 
	 * 		! Project���� getRealPath�� �����ϸ� �ȴ�.
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
	// WEB-INF/files���ٰ� �����ص� ����.
	// ������? application�� ������ was�� ��ġ�� �˾Ƴ� ������ ������ �� �ִ�. 
	// �׷���.. java������ Application�� ����. 
	// ����ϴ� ������ �����? Autowired! 
	//S
	
	public boolean exUpOld(MultipartFile f){
		//�� �� �ִ� ��������? 
		// 
		try{
			boolean b = f.isEmpty();
			InputStream is = f.getInputStream(); // �ӽ����Ͽ��� inputStream�� �� �� �ִ�. 
			String ct = f.getContentType();
			String filename = f.getOriginalFilename();	// �÷��� ���� �̸�
			String name = f.getName();
			long size = f.getSize();
			File dest = new File("d:/file",filename);
			f.transferTo(dest);	// �̰��� ������ġ�� ���ε��Ű�� �޼����. 
			
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
