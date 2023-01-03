package com.vijay.userlist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.vijay.userlist.dao.UserDao;
import com.vijay.userlist.entity.User;
import com.vijay.userlist.util.SortData;

@Controller
public class RegistartionController {
	@Autowired
	UserDao dao;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "loginPage";
	}

	@RequestMapping("/")
	public String page() {
		return "loginPage";
	}

	@RequestMapping("/regPage")
	public String RegPage() {
		return "regPage";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("password") String password, @RequestParam("username") String emailId, Model model) {
		User user = dao.getUser(emailId, password);
		if (user != null) {
			int offSet=0;
			int pageSize=10;
			String field="firstname";
			Page<User> users = dao.getUsers(offSet,pageSize,field);
			SortData sortData= new SortData();
			sortData.setField(field);
			sortData.setOffset(offSet);
			sortData.setPageSize(pageSize);
			model.addAttribute("users",users);
			model.addAttribute("sortData",sortData);
			return "users";
		}
		return "loginPage";
	}
	@RequestMapping("/sort")
	public String sorting(@RequestParam("offSet") int offSet, @RequestParam("pageSize") int pageSize,@RequestParam("field") String field, Model model) {
			
			System.out.println(offSet+" "+pageSize+" "+field);
			Page<User> users = dao.getUsers(offSet,pageSize,field);
			SortData sortData= new SortData();
			sortData.setField(field);
			sortData.setOffset(offSet);
			sortData.setPageSize(pageSize);
			model.addAttribute("users",users);
			model.addAttribute("sortData",sortData);
			return "users";
	}
	
	
	@PostMapping(value = "/registeruser")
	public String register(User user) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyHHmmss");
		Date date = new Date();
		user.setEmployeeid(Integer.parseInt(formatter.format(date)));
		user.setPassword(encoder.encode(user.getPassword()));
		dao.regUser(user);
		return "loginPage";
	}

	@RequestMapping("/logout")
	public String logout() {

		return "loginPage";
	}
}
