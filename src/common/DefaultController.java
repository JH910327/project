package common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	@RequestMapping("/main.do")
	public String gomain(){
		return "tile_default";
		//return "tw_\\main";
	}
}
