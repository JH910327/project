package file.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pojo.FileObj;

@Component
public class FileSearchService {
	@Autowired
	SqlSessionFactory fac;
	
	public List<FileObj> startWith(String text){
		SqlSession sql = fac.openSession();
		//String ser = "'"+text+"%'";
		String ser = text+"%";
		//System.out.println(ser);
		List<FileObj> al = sql.selectList("files.fileSearch",ser);
		sql.close();
		return al;
	}
	
	public List<FileObj> contains(String text){
		SqlSession sql = fac.openSession();
		String ser = "'%"+text+"%'";
		System.out.println(ser);
		List<FileObj> al = sql.selectList("files.fileSearch",ser);
		sql.close();
		return al;
	}
	
	public List<FileObj> endWith(String text){
		SqlSession sql = fac.openSession();
		String ser = "'%"+text+"'";
		System.out.println(ser);
		List<FileObj> al = sql.selectList("files.fileSearch",ser);
		sql.close();
		return al;
	}
}
