package member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.model.JoinService;
import member.model.LoginService;
import pojo.Members;

@Controller
public class MemberController {
	
	@Autowired
	LoginService ls;
	@Autowired
	JoinService js;
	
	
	// ==================================== 가입처리
	
	@RequestMapping("memberjoinrst.do")
	public ModelAndView memjoinrst(@RequestParam String id, @RequestParam String pass, @RequestParam String name){
		ModelAndView mav = new ModelAndView("tile_memberjoinrst");
		Members newmem = new Members(id,pass,name);
		boolean rst = js.joinResult(newmem);
		if(rst)
			mav.addObject("joinrst",true);
		else
			mav.addObject("joinrst",false);
		return mav;
	}
	
	@RequestMapping("memberJoin.do")
	public String memjoin(){
		return "tile_memberjoin";
	}
	
	@RequestMapping("newmemIdCheck.do")
	@ResponseBody
	public String nicheck(@RequestParam String id){
		System.out.println("넘어온 아이디는! "+id);
		boolean r = js.idCheck(id);
		if(r)
			return "Y";
		else
			return "N";
	}
	
	
	// ===================================== 로그인처리

	@RequestMapping("memberlogin.do")
	public ModelAndView memlogin(@RequestParam String id, @RequestParam String pass, HttpSession ss){
		
		ModelAndView mav = new ModelAndView("tile_loginRst");
		boolean logr = ls.login(id, pass);
		boolean adr;
		if(logr){
			System.out.println("로그인!");
			ss.setAttribute("sid", id);
			mav.addObject("log",true);
			adr = ls.adminCheck(id);
			if(adr)
				mav.addObject("admin",true);
		}else{
			System.out.println("실패!");
			mav.addObject("log",false);
		}
		return mav;
	}
	
	@RequestMapping("memberlogout.do")
	public String memlogout(){
		return "tile_logout";
	}
}
