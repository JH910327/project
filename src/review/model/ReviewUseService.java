package review.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import review.model.*;

@Component
public class ReviewUseService {
	@Autowired
	SqlSessionFactory fac;
	public boolean open(){
		SqlSession sql = fac.openSession();
		boolean rst = false;
		if(sql != null)
			rst = true;
		sql.close();
		return rst;
	}
	
	public boolean reviewgo(String id, String memo){
		SqlSession sql = fac.openSession();
		Review re = new Review(id,memo);
		int i = sql.insert("review.insert", re);
		boolean rst = false;
		if(i == 1)
			rst = true;
		sql.close();
		return rst;
	}

	public boolean likeUpdate(int num){
		SqlSession sql = fac.openSession();
		int i = sql.update("review.upGood",num);
		boolean rst = false;
		if(i == 1)
			rst = true;
		sql.close();
		return rst;
	}
	
}
