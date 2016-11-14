package file.model;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pojo.FileObj;

@Component
public class FileDownloadService {
	@Autowired
	SqlSessionFactory fac;
	
	@Autowired
	ServletContext application;
	
	public FileObj fileDown(int pk){
		SqlSession sql = fac.openSession();
		FileObj fi = sql.selectOne("files.fileDown",pk);
		sql.close();
		return fi;
	}
	
	public boolean fileCountUp(int pk){
		boolean b = false;
		SqlSession sql = fac.openSession();
		int i = sql.update("files.upCount",pk);
		if(i == 1)
			b = true;
		sql.close();
		return b;
	}
	
	public boolean isEx(String uuid){
		String fileDir = application.getRealPath("/files");
		System.out.println(fileDir);
		File file = new File(fileDir,uuid);
		
		return file.exists();
	}
}
