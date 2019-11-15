package dog.diary.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dog.diary.entity.Cause;
import dog.diary.entity.User;
import dog.diary.service.inte.CauseServiceInte;

@Controller
public class CauseController {

	@Resource(name = "causeService")
	private CauseServiceInte csi;
	private List<Cause> list;
	private User user;
	@RequestMapping(value = "/consume")
	public String select(HttpServletRequest req, HttpSession session,
			Model model) {
		session = req.getSession();
		user = (User) session.getAttribute("user");
		if(user == null){
			return "home";
		}
		
		list = csi.select_cause(user.getId());

		model.addAttribute("list", list);
		return "home/right/consume";
	}

	@RequestMapping(value = "/search_consume")
	public String search_consume(HttpServletRequest req, Model model,
			HttpSession session) {
		session = req.getSession();
		user = (User) session.getAttribute("user");
		if(user == null){
			return "home";
		}
		
		String search = req.getParameter("search");

		list = csi.search_consume(search, user.getId());
		model.addAttribute("list", list);
		return "home/right/consume_search";
	}
}
