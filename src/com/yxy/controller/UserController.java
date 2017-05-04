package com.yxy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxy.bean.User;
import com.yxy.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user_list")
	public String user_list(HttpServletRequest request,HttpSession httpSession,Model model){
		String s=request.getParameter("s");
		String abc=userService.gets(s);
		model.addAttribute("s", abc);
		return "user/user_list";
	}
	
	@ResponseBody
	@RequestMapping("/json")
	public Object getJson(){
		List<User> list=new ArrayList<User>();
		for(int i=0;i<5;i++){
			User u=new User();
			u.setUserName("你好"+i);
			u.setPassword("不好"+i);
			list.add(u);
		}
		return list;
	}
}
