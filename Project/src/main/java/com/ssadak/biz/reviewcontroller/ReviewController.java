package com.ssadak.biz.reviewcontroller;
import com.ssadak.biz.review.ReviewService;
import com.ssadak.biz.reviewInfo.ReviewInfoVO;
import com.ssadak.biz.userInfo.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ReviewController {

	
	@Autowired
	private ReviewService reService;
	@Autowired
	private UserService service;
	
	@RequestMapping("review.do")
	public String review(Model model,HttpServletRequest request) {
		
	    int num = reService.getPageNum(); 
	    int str = (num/10)*10;
	   
	    if(request.getParameter("inum")==null || request.getParameter("inum")=="1" ) {
	    	str = (num/10)*10;
	    }
	    else{
	    		
	    	for(int i=1;i<Integer.parseInt(request.getParameter("inum"));i++) {
	    		
	    		str-=10;
	    	}
	    }
	   
	    
	    int rum = (num/10)+1;
	   
	    
	    ArrayList<Integer> page = new ArrayList<Integer>();
	    
	    for(int i=1;i<rum+1;i++) {
	    	
	    	page.add(i);
	    }
	    
	    model.addAttribute("page",page);
	    
	    model.addAttribute("reviewList",reService.getList(str));
		return "reviewMain.jsp";
	}
	@RequestMapping("insertReview.do")
	public String insertReview(HttpServletRequest request) {
		
		
		String ref = service.getRef(request.getParameter("list"));
		ReviewInfoVO vo = new ReviewInfoVO();
		if(ref!=null) {
			vo.setPagename(request.getParameter("list"));
			vo.setRef(ref);
		}
		vo.setId(request.getParameter("id"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setTitle(request.getParameter("title"));
		vo.setWriting(request.getParameter("writing"));
		
		reService.insertReview(vo);
	
		
		return "review.do";
		
	}
	@RequestMapping("insert.do")
	public String insert(HttpServletRequest request) {
		if(request.getParameter("id")!=null)
			return "insert.jsp";
		else {
			return "log.jsp";
		}
			
	}
	@RequestMapping("reinsertReview.do")
	public String reinsertReview(HttpServletRequest request) {
		ReviewInfoVO vo = new ReviewInfoVO();
		
		vo.setId(request.getParameter("myid"));
		vo.setNickname(request.getParameter("mynickname"));
		vo.setPost(request.getParameter("post"));
		vo.setCountNum(Integer.parseInt(request.getParameter("count")));
		
		reService.reinsertReview(vo);
		
		return "infoReview.do";
		
	}	
	@RequestMapping("updateReview.do")
	public String updateReview(HttpServletRequest request) {
		
		ReviewInfoVO vo = new ReviewInfoVO();
		
		
		vo.setTitle(request.getParameter("title"));
		vo.setCountNum(Integer.parseInt(request.getParameter("count")));
		vo.setWriting(request.getParameter("writing"));
		
		reService.updateReview(vo);
		return "review.do";
	}
	@RequestMapping("deleteReview.do")
	public String deleteReview(HttpServletRequest request) {
		
		ReviewInfoVO vo = new ReviewInfoVO();
		
		vo.setCountNum(Integer.parseInt(request.getParameter("count")));
		
		
		reService.deleteReview(vo);
		return "review.do";
	}
	@RequestMapping("infoReview.do")
	public String infoReview(HttpServletRequest request, Model model) {
		
		ReviewInfoVO vo = new ReviewInfoVO();
		
		
		vo.setCountNum(Integer.parseInt(request.getParameter("count")));
		
		
		List<ReviewInfoVO> postList = reService.infoPost(vo);
		ReviewInfoVO vo2 = reService.infoReview(vo);
		System.out.println(vo2.getNickname());
		
		model.addAttribute("main",reService.infoReview(vo));
		model.addAttribute("post",postList);
		
		return "review.jsp";
		
	}
	
	@RequestMapping("reviewinfo.do")
	public String reviewinfo(HttpServletRequest request) {
	
		
		ReviewInfoVO vo = new ReviewInfoVO();
		vo.setNickname(request.getParameter("nickname"));
		vo.setTitle(request.getParameter("title"));
		vo.setWriting(request.getParameter("writing"));
		vo.setCountNum(Integer.parseInt(request.getParameter("count")));
		
		reService.updateReview(vo);
	
		
		return "review.do";
		
	}
	
}
