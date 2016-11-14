package file.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import file.model.FileSearchService;
import pojo.FileObj;

@Controller
public class SearchController {

	@Autowired
	FileSearchService fss;

	@RequestMapping("/file/fileSearch.do")
	@ResponseBody
	public String searchText(String sea){
		if (sea.equals(""))
			return null;
		List<FileObj> al = fss.startWith(sea);
		if(al.isEmpty()){
			return null;
		}else{
			String st = "";
			for(FileObj fi : al){
				st += fi.getTitle()+" ";
			}
			return st;
		}
	}
	
	@RequestMapping
	@ResponseBody
	public List searchResolve(String q){
		List li = fss.startWith(q);
		return li;
	}
	
	
	@RequestMapping("/file/fileSearchxml.do")
	@ResponseBody
	public ModelAndView searchResolve2(String q){
		List li = fss.startWith(q);
		ModelAndView mav = new ModelAndView("file/searchResult.jsp");
		mav.addObject("li",li);
		return mav;
	}
	
}
