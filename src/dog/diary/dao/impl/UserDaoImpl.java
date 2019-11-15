package dog.diary.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import dog.diary.dao.mapper.UserDaoInte;
import dog.diary.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDaoInte {

	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	private SqlSession sqlSession;
	
	public List<User> reg_oldPass(String old_pass, int user_id) {
		sqlSession = sqlSessionFactory.openSession();
		UserDaoInte udi = sqlSession.getMapper(UserDaoInte.class);
		return udi.reg_oldPass(old_pass, user_id);
	}

	public void update(String yes_pass, int user_id) {
		sqlSession = sqlSessionFactory.openSession();
		UserDaoInte udi = sqlSession.getMapper(UserDaoInte.class);
		udi.update(yes_pass, user_id);
	}

	public boolean add_user(User user) {
		sqlSession = sqlSessionFactory.openSession();
		UserDaoInte udi = sqlSession.getMapper(UserDaoInte.class);
		try {
			udi.add_user(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<User> select(User user) {
		sqlSession = sqlSessionFactory.openSession();
		UserDaoInte udi = sqlSession.getMapper(UserDaoInte.class);
		return udi.select(user);
	}

	public List<User> select_sum() {
		sqlSession = sqlSessionFactory.openSession();
		UserDaoInte udi = sqlSession.getMapper(UserDaoInte.class);
		return udi.select_sum();
	}

	public void del(User user) {
		sqlSession = sqlSessionFactory.openSession();
		UserDaoInte udi = sqlSession.getMapper(UserDaoInte.class);
		udi.del(user);
	}

	public User find_userId(User user) {
		sqlSession = sqlSessionFactory.openSession();
		UserDaoInte udi = sqlSession.getMapper(UserDaoInte.class);
		return udi.find_userId(user);
	}

}
