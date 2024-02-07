package com.ssadak.biz.logInAndLogout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssadak.biz.userInfo.UserInfoVO;
import com.ssadak.biz.userInfo.impl.UserService;

import org.springframework.ui.Model;

@Controller
public class LoginController {

	
		@Autowired
		private UserService service;
		
		@RequestMapping("/log.do")
		public String logg(HttpSession session,Model model,HttpServletRequest request) {
			
			
			System.out.println("환영합니다.");
			
			UserInfoVO user = new UserInfoVO();
			user.setId(request.getParameter("id"));
			user.setPw(request.getParameter("pw"));
			
			
			if(user.getId()==null || user.getPw()==null) {
			
				session.setAttribute("sure",false);
				return "log.jsp";
			}
			else {
				
				
				user = service.infoUser(user);	
				
				
				
				if(user!=null) {
					session.setAttribute("sure",true);
					session.setAttribute("info", user);
					if(service.zzimList(user)!=null)
						session.setAttribute("list", service.zzimList(user));
					else
						session.setAttribute("list"," ");
					return "main.do";
					
				}else {
					
					model.addAttribute("sure",false);
					return "log.jsp";
					
				}
				
				
			}
		}
			
			@RequestMapping("/find_id.do")
			public String findId(HttpServletRequest request,Model model) {
				
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				UserInfoVO vo = new UserInfoVO();
				vo.setPhone(phone);
				vo.setEmail(email);
				vo = service.findId(vo);
				
			
				
				if(vo!=null) {
					
					model.addAttribute("id",true);
					model.addAttribute("find_id",vo.getId());
					return "find_id.jsp";
				}
				else  {
					
					model.addAttribute("id",false);
					return "find_id.jsp";
				}
				
				
				
			}
			@RequestMapping("/find_pw.do")
			public String findPw(HttpServletRequest requpest,Model model) {
				UserInfoVO vo = new UserInfoVO();
				
				vo.setId(requpest.getParameter("id"));
				vo=service.findPw(vo);
				
				if(vo!=null) {
					
					model.addAttribute("pw",true);
					model.addAttribute("find_pw",vo.getPw());
					return "find_pw.jsp";
				}
				else {
					
					model.addAttribute("pw",false);
					return "find_pw.jsp";
				}
				
			}
			@RequestMapping("/member.do")
			public String member(HttpServletRequest requset,Model model) {
				UserInfoVO vo = new UserInfoVO();
				
				vo.setId(requset.getParameter("id"));
				vo.setPw(requset.getParameter("pw"));
				vo.setAge(requset.getParameter("age"));
				vo.setSex(requset.getParameter("sex"));
				vo.setPhone(requset.getParameter("phone"));
				vo.setEmail(requset.getParameter("email"));
				vo.setNickname(requset.getParameter("nickname"));
				service.insertUser(vo);
				
				model.addAttribute("vo",vo);
				return "log.jsp";
				
				
			}
			@RequestMapping("zzim.do")
			public String zzim(HttpServletRequest request,HttpSession session) {
				
				UserInfoVO vo = new UserInfoVO();
				vo.setId(request.getParameter("id"));
				vo.setPagename(request.getParameter("pagename"));
				vo.setRef(request.getParameter("ref"));
				if(service.serRef(vo)==null) {
				
				
					service.addRef(vo);
				
					session.setAttribute("list",service.zzimList(vo));
					session.setAttribute("zzim",1);
					return "main.do";
				}else {
					
					return "main.do";
				}
					
		
				
				
			}
			@RequestMapping("/zzimpage.do")
			public String zzimpage(HttpServletRequest request,HttpSession session) {
				
				UserInfoVO vo = new UserInfoVO();
				vo.setId(request.getParameter("id"));
				vo.setPw(request.getParameter("pw"));
				session.setAttribute("list",service.zzimList(vo));
				return "zzimpage.jsp";
				
			}
			@RequestMapping("/zzimdel.do")
			public String zzimdel(HttpServletRequest request) {
				
				UserInfoVO vo = new UserInfoVO();
				vo.setPagename(request.getParameter("name"));
				vo.setRef(request.getParameter("ref"));
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				service.zzimdel(vo);
				
				return "zzimpage.do?"+"id="+id+"&pw="+pw;
				
				
			}
			@RequestMapping("/logOut.do")
			public String logOut(HttpServletRequest request) {
				 HttpSession session = request.getSession(true); // false 옵션은 세션이 없으면 null을 반환하도록 합니다.

			        // 세션 무효화
			        if (session != null) {
			            session.invalidate();
			        }
			        
			        return "main.do";
			}
			@RequestMapping("/memberinfo.do")
			public String memberinfo(HttpServletRequest request) {
				
				UserInfoVO vo = new UserInfoVO();
				vo.setId(request.getParameter("id"));
				vo.setPw(request.getParameter("pw"));
				vo.setAge(request.getParameter("age"));
				vo.setPhone(request.getParameter("phone"));
				vo.setEmail(request.getParameter("email"));
				vo.setNickname(request.getParameter("nickname"));
				
				service.updatetUser(vo);
				
				return "log.do?id="+vo.getId()+"&pw="+vo.getPw();
				
				
				
				
				
			}
			
			
		
			
			
			
		
}
