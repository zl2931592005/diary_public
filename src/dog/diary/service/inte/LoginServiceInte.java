package dog.diary.service.inte;


import javax.servlet.http.HttpSession;

import dog.diary.entity.User;

public interface LoginServiceInte {
	public User login(User user, HttpSession session);
}
