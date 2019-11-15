package dog.diary.controller;




import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dog.diary.entity.User;
import dog.diary.service.inte.DiaryServiceInte;
import dog.diary.service.inte.LoginServiceInte;
import dog.diary.untis.GetDate;

//该类用于处理登录。目前尚未进行对应的登录校验及session的判断。后需要完善。
//现在已经完成session的处理以及判断登录时账号的存在与否。未进行前后端输入校验。
@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginServiceInte lsi;
	private HttpSession session;
	@Resource(name="diaryService")
	private DiaryServiceInte dsi;
	
	@RequestMapping(value="/exit")
	public String exit(HttpServletRequest req,Model model){
		req.getSession().invalidate();
		return index(model);
	}
	
	@RequestMapping(value="/login")
	public @ResponseBody User login(@RequestBody User user,HttpServletRequest req){
		session = req.getSession();
		
//		TODO 实际上线时，以下if语句删除
		/*if(user == null || "".equals(user.toString())){
			user.setUsername("demo1");
			user.setPassword("demo");
		}*/
		
		user  = lsi.login(user,session);
		if(user != null){
			session.setAttribute("user", user);
		}
		
		return user;
	}
	
	@RequestMapping(value="/index")
	public String index(Model model){
		
		if(session == null){
			return "login";
		}
		
		GetDate gd = new GetDate();
		String date = gd.getDate();
		model.addAttribute("date",date);
		
		User user = null;
		try {
			user = (User) session.getAttribute("user");
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
		String name = user.getUsername();
		
		model.addAttribute("name", name);
//		判断今天的日志是否已经写了
		boolean bool = false;
		if(dsi.diary_yesorno(date,user.getId())){
			bool = true;
		}
		model.addAttribute("bool", bool);
		return "home";
	}
	
}
