package file.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pojo.FileObj;

@Component
public class FileViewService {
	@Autowired
	SqlSessionFactory fac;
	
	public List<FileObj> fileListShow(){
		SqlSession sql = fac.openSession();
		List<FileObj> al = sql.selectList("files.fileList");
		sql.close();
		return al;
	}
	
	public List<FileObj> topDownload(){
		SqlSession sql = fac.openSession();
		List<FileObj> al = sql.selectList("files.topDown");
		sql.close();
		return al;
	}
	
}
