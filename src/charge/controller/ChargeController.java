package charge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChargeController {
	
	@RequestMapping("/charge/chargelog.do")
	public String charLog(){
		return "tile_log";
	}
	
	@RequestMapping("/charge/doCh.do")
	public String goChar(){
		return "tile_ch";
	}
}
