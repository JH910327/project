package mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mail.model.MailAuthService;

@Controller
public class EmailAuthController {
	
	@Autowired
	MailAuthService mas;
	
	@RequestMapping("/member/auth.do")
	public String goAuth(){
		return "tile_Auth";
	}

	@RequestMapping("/member/authAjax.do")
	@ResponseBody
	public String authResolve(String email, String id){
		System.out.println(email+"/"+id);
		int r = mas.sendEmail(email,id);
		System.out.println("controller에서 알려드립니다=="+r);
		if(r==1)
			return "yes";
		else
			return "nope";
	}
	
	@RequestMapping("/member/authProcess.do")
	@ResponseBody
	public String authResolve2(String email, String key){
		//boolean b = mas.keyCheck(email,key);
		boolean b = true;
		if(b)
			return "yes";
		else
			return "nope";
	}
}
