package dog.diary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dog.diary.entity.Balance;
import dog.diary.entity.User;
import dog.diary.service.inte.UserServiceInte;

@Controller
public class UserController {

	@Resource(name="userService")
	private UserServiceInte usi;
	private HttpSession session;
	
	@RequestMapping(value="/add_user")
	public String add_user(User user,HttpServletRequest req,Model model){
		if(user.getUsername()==null||"".equals(user.getUsername())||user.getPassword()==null||"".equals(user.getPassword())){
			model.addAttribute("mess", 0);
			return "login";
		}
		
		int flag = usi.add_user(user);
		if(flag == 0){
			model.addAttribute("mess", 2);
			return "login";
		}
		
		String[] moneys = req.getParameterValues("money");
		Balance balance = null;
		double money = 0;
		user = usi.find_userId(user);
		List<Balance> list = new ArrayList<Balance>();
		for (int i = 0; i < moneys.length; i++) {
			if(moneys[i]==null||"".equals(moneys[i])){
				money = 0;
			}else{
				money = Double.parseDouble(moneys[i]);
			}
			balance = new Balance(money, i+1, user.getId());
			list.add(balance);
		}
		if(usi.add_balance(list)==false){
			usi.del(user);
			model.addAttribute("bal", 0);
			return "login";
		}
		model.addAttribute("mess", 1);
		return "login";
	}
	
	@RequestMapping(value="/adduser")
	public String adduser(){
		return "add_user";
	}
	
	@RequestMapping(value="/go_update_user")
	public String go_update_user(HttpServletRequest req,Model model){
		session = req.getSession();
		if(session == null){
			return "login";
		}
		User user = (User) session.getAttribute("user");
		if(user == null){
			return "home";
		}
		
		List<Balance> list = usi.select(user.getId());
		
		model.addAttribute("list", list);
		return "home/right/update_user";
	}
	
	@RequestMapping(value="/update")
	public String update_user(HttpServletRequest req,Model model){
		session = req.getSession();
		if(session == null){
			return "login";
		}
		String old_pass = req.getParameter("old_pass");
		if(old_pass == null || "".equals(old_pass)){
			model.addAttribute("mess", true);
			return "home/right/update_user";
		}
		
		User user = (User) session.getAttribute("user");
		if(user == null){
			return "home";
		}
		
		boolean bool = usi.reg_oldPass(old_pass,user.getId());

		if(!bool){
			model.addAttribute("mess", true);
		}
		
		String new_pass = req.getParameter("new_pass");
		String yes_pass = req.getParameter("yes_pass");
		if(new_pass == null||"".equals(new_pass)){
			model.addAttribute("mess", true);
		}
		if(yes_pass == null ||"".equals(yes_pass)){
			model.addAttribute("mess", true);
		}
		if(!yes_pass.equals(new_pass)){
			model.addAttribute("mess", true);
		}else{
			usi.update(yes_pass,user.getId());
			model.addAttribute("mess", false);
		}

		return "home/right/update_user";
		
	}
	
}
