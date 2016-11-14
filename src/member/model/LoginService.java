package member.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	@Autowired
	SqlSessionFactory fac;
	
	public boolean login(String id, String pass){	
		SqlSession sql = fac.openSession();
		boolean r = false;
		HashMap param = new HashMap();
		param.put("id",id);
		param.put("pass",pass);
		HashMap rst = sql.selectOne("login",param);
		if(rst != null)
			r = true;
		return r;
	}
	
	public boolean adminCheck(String id){	
		SqlSession sql = fac.openSession();
		boolean r = false;
		HashMap rst = sql.selectOne("adcheck",id);
		if(rst != null)
			r = true;
		return r;
	}
}
