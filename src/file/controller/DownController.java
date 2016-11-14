package file.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import file.model.FileDownloadService;
import pojo.FileObj;

@Controller
public class DownController {
	
	@Autowired
	FileDownloadService fds;
	
	@RequestMapping("/file/down.do")
	public ModelAndView goDown(@RequestParam int num){
		ModelAndView mav = new ModelAndView();
		FileObj fi = fds.fileDown(num); 
		boolean b = fds.isEx(fi.getFileuuid());
		
		if(fi == null || !b){
			mav.setViewName("tile_error");
		}else{
			fds.fileCountUp(num);
			mav.setViewName("dlv");
			mav.addObject("file",fi);
		}
		return mav;
	}
}
