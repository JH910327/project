package mail.controller;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendController {
	
	// ���Ϲ߼��� ���� mailsender�� ������
	@Autowired
	JavaMailSender sender;
	
	
	// �ܼ��� text���(plain)�� mail�̶�� SimpleMailMessage 
	// HTML����� mail�̶�� MimeMessage
	
	
	// ============ MimeMessage
	
	@RequestMapping("mail/test02.do")
	public String sendResolve2(){
		
		try{
			//new MimeMessage�� �������� �ʴ´�. 
			// ������/�߽���/����/���� �ʿ�
			// Address�� �Ű������� �����ؾ��ϴ� ��찡 �ִ�. 
			// ���� ��ü�� InternetAddress�� �ϸ� �ȴ�. 
			// ���������� ������ �ϴ� ��쵵 address�迭�� ����� �־��� �� �ִ�.
			/*
			 * 
			Address[] targets = new Address[] {
					new InternetAddress("admin@group.kr"),
					new InternetAddress("admin@group.kr")
			};
			 */
			MimeMessage message = sender.createMimeMessage();
			message.setRecipients(RecipientType.TO, "jh910327@gmail.com");
			message.setFrom(new InternetAddress("admin@group.kr"));
			
			message.setSubject("ȯ���մϴ�!");
			String text = "<h3>�������!</h3>";
			text += "<b>������</b>��, �湮���ּż� �����մϴ�.<br/>";
			text += "�Ʒ� ��ũ�� �����ּ���.<br/>";
			text += "<a href='http://192.168.10.11/main.do?key=123456'>����Ű �ޱ�</a>";
			
			message.setText(text,"utf-8","html");

			sender.send(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	// =========== SimpleMailMessage 
	
	@RequestMapping("/mail/test01.do")
	public String sendResolve(){

		
		try{
			SimpleMailMessage message = new SimpleMailMessage();
			
			// ������� / ���� / ������ �ʼ��� �־�� �Ѵ�. 
			// ������ ����� ���� ����������, SMTP�� ��ȸ�ؼ� �����ٸ� ������ �ȵȴ�. 
			message.setTo("jh910327@gmail.com");	// String / String[]
			message.setFrom("admin@group.kr");
			message.setSubject("����Test");
			String text = "�ȳ��ϼ���\n �����׽�Ʈ ���Դϴ�<br/>";
			text += "���� ������ ����� �������? ";
			message.setText(text);
			// exception�� ���� �� �ִ�. 
			
			// �Ű������� SimpleMailMessage / MimeMessage �� �� �ϳ�. 
			sender.send(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
