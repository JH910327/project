package member.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pojo.Members;

@Component
public class JoinService {
	@Autowired
	SqlSessionFactory fac;
	
	public boolean joinResult(Members newmem){
		SqlSession sql = fac.openSession();
		boolean r = false;
		try{
			int r1 = sql.insert("join",newmem);
			int r2 = sql.insert("join2",newmem.getId());
			if(r1 == 1 && r2 == 1){
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
	
	public boolean idCheck(String id){
		SqlSession sql = fac.openSession();
		boolean r = true;
		ArrayList rst = (ArrayList)sql.selectList("detailOne",id);
		sql.close();
		if(rst.isEmpty()){
			return r;
		}else{
			r = false;
			return r;
		}
	}
	
}
