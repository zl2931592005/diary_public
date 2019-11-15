package dog.diary.service.impl;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import dog.diary.dao.mapper.LoginDaoInte;
import dog.diary.entity.User;
import dog.diary.service.inte.LoginServiceInte;

@Service("loginService")
public class LoginServiceImpl implements LoginServiceInte{

	@Resource(name="logindao")
	private LoginDaoInte ldi;
	
	public User login(User user, HttpSession session) {
		user = ldi.login(user);
		return user;
	}
	
}
