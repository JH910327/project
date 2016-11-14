package review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import review.model.Review;
import review.model.ReviewListService;

@Controller
public class ReviewListController {

	@Autowired
	ReviewListService rls;
	
	@RequestMapping("/review/list.do")
	public ModelAndView goList(@RequestParam(defaultValue="1")int page){
		List<Review> li = rls.getRange(page);
		int p = rls.getAllSize();
		ModelAndView mav = new ModelAndView("tile_rvlist");
		mav.addObject("al",li);
		mav.addObject("pl",p);
		mav.addObject("np",page);
		return mav;
	}
	
}
