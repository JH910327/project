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
	
	// 메일발송을 위해 mailsender를 가져옴
	@Autowired
	JavaMailSender sender;
	
	
	// 단순히 text기반(plain)의 mail이라면 SimpleMailMessage 
	// HTML기반의 mail이라면 MimeMessage
	
	
	// ============ MimeMessage
	
	@RequestMapping("mail/test02.do")
	public String sendResolve2(){
		
		try{
			//new MimeMessage로 생성하지 않는다. 
			// 수신자/발신자/제목/내용 필요
			// Address를 매개변수로 설정해야하는 경우가 있다. 
			// 하위 객체인 InternetAddress로 하면 된다. 
			// 여러명한테 보내야 하는 경우도 address배열로 만들어 넣어줄 수 있다.
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
			
			message.setSubject("환영합니다!");
			String text = "<h3>어서오세요!</h3>";
			text += "<b>이진희</b>님, 방문해주셔서 감사합니다.<br/>";
			text += "아래 링크를 눌러주세요.<br/>";
			text += "<a href='http://192.168.10.11/main.do?key=123456'>인증키 받기</a>";
			
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
			
			// 받을사람 / 제목 / 내용을 필수로 넣어야 한다. 
			// 보내는 사람도 설정 가능하지만, SMTP로 우회해서 보낸다면 적용이 안된다. 
			message.setTo("jh910327@gmail.com");	// String / String[]
			message.setFrom("admin@group.kr");
			message.setSubject("메일Test");
			String text = "안녕하세요\n 메일테스트 중입니다<br/>";
			text += "과연 메일이 제대로 갔을까요? ";
			message.setText(text);
			// exception이 생길 수 있다. 
			
			// 매개변수는 SimpleMailMessage / MimeMessage 둘 중 하나. 
			sender.send(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
