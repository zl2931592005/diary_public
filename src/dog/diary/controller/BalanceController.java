package dog.diary.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dog.diary.entity.Balance;
import dog.diary.entity.User;
import dog.diary.service.inte.BalanceServiceInte;

@Controller
public class BalanceController {
	@Resource(name = "balanceService")
	private BalanceServiceInte bsi;
	private User user;

	@RequestMapping(value = "/balance")
	public String balance(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		if (session == null) {
			return "login";
		}

		user = (User) session.getAttribute("user");
		if(user == null){
			return "home";
		}
		
		List<Balance> list = bsi.select(user.getId());

		model.addAttribute("list", list);

		return "home/right/balance";
	}
}
