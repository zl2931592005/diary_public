package dog.diary.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dog.diary.dao.mapper.BalanceDaoInte;
import dog.diary.dao.mapper.UserDaoInte;
import dog.diary.entity.Balance;
import dog.diary.entity.User;
import dog.diary.service.inte.UserServiceInte;

@Service("userService")
public class UserServiceImpl implements UserServiceInte {
	
	@Resource(name="balanceDao")
	private BalanceDaoInte bdi;
	@Resource(name="userDao")
	private UserDaoInte udi;
	
	public List<Balance> select(int user_id) {
		return bdi.select(user_id);
	}

	public boolean reg_oldPass(String old_pass, int user_id) {
		List<User> list = udi.reg_oldPass(old_pass, user_id);
		if(list.size() > 0){
			return true;
		}
		return false;
	}

	public void update(String yes_pass,int user_id) {
		udi.update(yes_pass,user_id);
	}

	public int add_user(User user) {
		List<User> list = udi.select(user);
		if(list.size() != 0){
			return 0;
		}
		udi.add_user(user);
		return 1;
		
	}

	public boolean add_balance(List<Balance> list) {
		return bdi.add(list);
	}

	public void del(User user) {
		udi.del(user);
	}

	public User find_userId(User user) {
		return udi.find_userId(user);
	}

}
