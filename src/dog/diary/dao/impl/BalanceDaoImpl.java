package dog.diary.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import dog.diary.dao.mapper.BalanceDaoInte;
import dog.diary.entity.Balance;

@Repository("balanceDao")
public class BalanceDaoImpl implements BalanceDaoInte {

	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	private SqlSession sqlSession;
	
	public List<Balance> select(int user_id) {
		sqlSession = sqlSessionFactory.openSession();
		BalanceDaoInte balanceDao = sqlSession.getMapper(BalanceDaoInte.class);
		return balanceDao.select(user_id);
	}

	public void update(int manner, double money, int user_id) {
		sqlSession = sqlSessionFactory.openSession();
		BalanceDaoInte balanceDao = sqlSession.getMapper(BalanceDaoInte.class);
		balanceDao.update(manner, money ,user_id);
	}

	public boolean add(List<Balance> list) {
		sqlSession = sqlSessionFactory.openSession();
		BalanceDaoInte balanceDao = sqlSession.getMapper(BalanceDaoInte.class);
		try {
			balanceDao.add(list);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

}
