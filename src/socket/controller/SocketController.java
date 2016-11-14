package socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocketController {

	@RequestMapping("/socket/view.do")
	public ModelAndView welcomeResolve(){
		return new ModelAndView("tile_socket");
	}
}
