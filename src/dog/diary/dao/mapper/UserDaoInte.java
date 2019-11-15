package dog.diary.dao.mapper;

import java.util.List;

import dog.diary.entity.User;

public interface UserDaoInte {

	public List<User> reg_oldPass(String old_pass, int user_id);

	public void update(String yes_pass, int user_id);

	public boolean add_user(User user);

	public List<User> select(User user);

	public List<User> select_sum();

	public void del(User user);

	public User find_userId(User user);

}
