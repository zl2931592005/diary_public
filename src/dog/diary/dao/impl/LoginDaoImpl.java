package dog.diary.dao.impl;


import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import dog.diary.dao.mapper.LoginDaoInte;
import dog.diary.entity.User;

@Repository("logindao")
public class LoginDaoImpl implements LoginDaoInte{
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	public User login(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		LoginDaoInte loginDaoInte = sqlSession.getMapper(LoginDaoInte.class);
		
		
		return loginDaoInte.login(user);
		
	}

}
