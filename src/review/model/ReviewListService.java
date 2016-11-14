package review.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewListService {
	@Autowired
	SqlSessionFactory fac;
	
	public List<Review> getRange(int p){
		SqlSession sql = fac.openSession();
		int end = p*5;
		int start = end-4;
		System.out.println(start+"/"+end);
		HashMap map = new HashMap();
		map.put("start",start);
		map.put("end",end);
		List<Review> li = sql.selectList("pageList",map);
		
		sql.close();
		return li;
	}
	
	public int getAllSize(){
		SqlSession sql = fac.openSession();
		int size = sql.selectOne("totalCount");
		sql.close();
		return size%5 == 0 ? size/5 : (size/5)+1;
	}
	
	
	
}
