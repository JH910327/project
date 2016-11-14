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
			message.setSubject("���� Ű �����帳�ϴ�.");
			String text = "<h3>���� Ű�� Ȯ�����ּ���.</h3>";
			text += "��û�Ͻ� Ű��<b>";
			text += key;
			text += "</b>�Դϴ�.<br/>";
			//text += "�Ʒ� ��ũ�� �����ø� �ڵ����� �����˴ϴ�.<br/>";
			//text += "<a href='http://192.168.10.11/main.do?key="+key;
			//text += "'>����Ű �ޱ�</a>";
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
				System.out.println("insert���="+r);
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
