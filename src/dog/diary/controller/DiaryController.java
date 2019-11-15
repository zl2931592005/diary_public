package dog.diary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dog.diary.entity.Cause;
import dog.diary.entity.Diary;
import dog.diary.entity.User;
import dog.diary.service.inte.CauseServiceInte;
import dog.diary.service.inte.DiaryServiceInte;
import dog.diary.untis.GetDate;

@Controller
public class DiaryController {

	@Resource(name = "diaryService")
	private DiaryServiceInte dsi;
	@Resource(name = "causeService")
	private CauseServiceInte csi;
	private double sumCause = 0;
	private GetDate gd = new GetDate();
	private List<Cause> old_causes;
	private String date;
	private User user;

	@RequestMapping(value = "/edit_diary")
	public String edit_diary(Diary d, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "home";
		}

		List<Cause> list = new ArrayList<Cause>();

		String[] causes = req.getParameterValues("cause");
		String[] moneys = req.getParameterValues("money");
		String[] manners = req.getParameterValues("manner");
		sumCause = 0;
		if (causes != null) {
			for (int i = 0; i < causes.length; i++) {
				if (!"".equals(causes[i]) && causes[i] != null) {
					Cause cause = new Cause(causes[i],
							Double.parseDouble(moneys[i]), manners[i], date,
							user.getId());
					list.add(cause);
					sumCause += Double.parseDouble(moneys[i]);
				}
			}
			d.setSum_cause(sumCause);
		} else {
			d.setSum_cause(sumCause);
		}

		d.setDate(date);
		d.setUser_id(user.getId());
		if (dsi.edit_diary(d, user.getId())
				&& csi.edit_cause(user.getId(), date, list, old_causes)) {
			return select_diary(model, req);
		}

		model.addAttribute("mess", 0);
		return find_diary(req, session, model);

	}

	@RequestMapping(value = "/find_diary")
	public String find_diary(HttpServletRequest req, HttpSession session,
			Model model) {
		session = req.getSession();
		user = (User) session.getAttribute("user");
		if (user == null) {
			return "home";
		}

		date = req.getParameter("date");
		if (date == null || "".equals(date)) {
			date = gd.getDate();
		}
		Diary diary = dsi.find_diary(date, user.getId());
		List<Cause> causes = csi.find_cause(date, user.getId());

		this.old_causes = causes;

		model.addAttribute("diary", diary);
		model.addAttribute("causes", causes);

		return "home/right/diary_edit";
	}

	@RequestMapping(value = "/search_diary")
	public String search_diary(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		if (session == null) {
			return "login";
		}
		user = (User) session.getAttribute("user");
		if (user == null) {
			return "home";
		}

		String search = req.getParameter("search");
		List<Diary> list = dsi.search(search, user.getId());
		model.addAttribute("list", list);
		return "home/right/diary_search";
	}

	@RequestMapping(value = "/add_diary")
	public String add_diary(Diary d, HttpServletRequest req, Model model,
			HttpSession session) {

		session = req.getSession();
		if (session == null) {
			return "login";
		}
		date = gd.getDate();
		user = (User) session.getAttribute("user");
		if(user == null){
			return "home";
		}
		
		
		if (dsi.diary_yesorno(date, user.getId())) {
			model.addAttribute("bool", true);
			return "home";
		}
		List<Cause> list = new ArrayList<Cause>();

		String[] causes = req.getParameterValues("cause");
		String[] moneys = req.getParameterValues("money");
		String[] manners = req.getParameterValues("manner");
		
		sumCause = 0;
		// 可以接收到来自diary_add.jsp的财务项的值，目前推断，如果将实体类cause内的属性改为数组，可能可用实体类来直接接收
		// System.out.println(causes.length+":"+moneys.length+":"+manners.length);
		for (int i = 0; i < causes.length; i++) {
			if (!"".equals(causes[i]) && causes[i] != null) {
				Cause cause = new Cause(causes[i],
						Double.parseDouble(moneys[i]), manners[i], date,
						user.getId());
				list.add(cause);
				sumCause += Double.parseDouble(moneys[i]);
			}
		}

		d.setSum_cause(sumCause);
		if (dsi.add_diary(d, session) && csi.add_cause(list)) {
			return select_diary(model, req);
		}

		model.addAttribute("mess", 0);
		return "home/right/diary_add";

	}

	public void del_diary() {
	}

	@RequestMapping(value = "/list_diary")
	public String select_diary(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session == null) {
			return "login";
		}

		List<Diary> list = dsi.select_diary_cause(session);

		model.addAttribute("list", list);
		return "home/right/diary_list";
	}

	@RequestMapping(value = "/diary_add")
	public String diary_add(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String date = gd.getDate();
		User user = (User) session.getAttribute("user");

		if (dsi.diary_yesorno(date, user.getId())) {
			model.addAttribute("bool", true);
			return find_diary(req, session, model);
		}
		return "home/right/diary_add";
	}

}
