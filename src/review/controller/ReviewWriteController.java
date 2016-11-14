package review.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import review.model.ReviewUseService;

@Controller
public class ReviewWriteController {
	
	@Autowired
	ReviewUseService rus;

	@RequestMapping("/review/Write.do")
	public String goReview(){
		return "tile_rvwrite";
	}
	/*
	@RequestMapping("/reviewlist.do")
	public String goList(Map map){
		List<Review> al = mybatisService.reviewList();
		map.put("al", al);
		return "/review/list.jsp";
	}
	*/
	@RequestMapping("/review/Writerst.do")
	public ModelAndView revWrite(HttpServletRequest req){
		String id = req.getParameter("writer");
		String memo = req.getParameter("memo");
		ModelAndView mav = new ModelAndView("tile_rvwrirst");
		boolean r = rus.reviewgo(id,memo);
		mav.addObject("rvrst", r);		
		
		return mav;
	}
	
	@RequestMapping("/review/rvLike.do")
	public String goListTwo(HttpServletRequest req){
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println(num);
		boolean r = rus.likeUpdate(num);
		if(r)
			System.out.println("좋아요 성공!");
		else
			System.out.println("좋아요 실패!");
		return "/review/list.jsp";
	}
	
}









