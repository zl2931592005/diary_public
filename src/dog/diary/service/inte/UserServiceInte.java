package dog.diary.service.inte;

import java.util.List;

import dog.diary.entity.Balance;
import dog.diary.entity.User;

public interface UserServiceInte {

	public List<Balance> select(int user_id);

	public boolean reg_oldPass(String old_pass, int user_id);

	public void update(String yes_pass, int user_id);

	public int add_user(User user);

	public boolean add_balance(List<Balance> list);

	public void del(User user);

	public User find_userId(User user);

}
