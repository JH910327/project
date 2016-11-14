package mail.model;

import java.util.HashMap;
import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailAuthService {

	@Autowired
	JavaMailSender sender;
	
	@Autowired
	SqlSessionFactory fac;
	
	public int sendEmail(String to,String id){
		try{
			String uid = UUID.randomUUID().toString();
			String key = uid.substring(0,8);
			
			MimeMessage message = sender.createMimeMessage();
			message.setRecipients(RecipientType.TO, to);
			message.setFrom(new InternetAddress("admin@group.kr"));
			message.setSubject("인증 키 보내드립니다.");
			String text = "<h3>인증 키를 확인해주세요.</h3>";
			text += "요청하신 키는<b>";
			text += key;
			text += "</b>입니다.<br/>";
			//text += "아래 링크를 누르시면 자동으로 인증됩니다.<br/>";
			//text += "<a href='http://192.168.10.11/main.do?key="+key;
			//text += "'>인증키 받기</a>";
			message.setText(text,"utf-8","html");
			sender.send(message);
			
			SqlSession sql = fac.openSession();
			int r = 0;
			HashMap<String,String> map = new HashMap<>();
			map.put("id", id);
			map.put("email",to);
			map.put("key",key);
			try{
				r = sql.insert("member.keyin",map);
				System.out.println("insert결과="+r);
				if(r == 1){
					sql.commit();
				}else{
					sql.rollback();
					return 0;
				}
			}catch(Exception e){
				sql.rollback();
				return 0;
			}
			sql.close();
			return r;

		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
