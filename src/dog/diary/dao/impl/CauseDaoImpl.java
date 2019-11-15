package dog.diary.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import dog.diary.dao.mapper.CauseDaoInte;
import dog.diary.entity.Cause;

@Repository("causeDao")
public class CauseDaoImpl implements CauseDaoInte{

	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	private SqlSession sqlSession;
	private CauseDaoInte causeDao;
	
	public boolean add_cause(List<Cause> list) {
		sqlSession = sqlSessionFactory.openSession();
		causeDao = sqlSession.getMapper(CauseDaoInte.class);
		try {
			causeDao.add_cause(list);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public List<Cause> select_cause(int user_id) {
		sqlSession = sqlSessionFactory.openSession();
		causeDao = sqlSession.getMapper(CauseDaoInte.class);
		return causeDao.select_cause(user_id);
	}

	public List<Cause> search_consume(String search, int id) {
		sqlSession = sqlSessionFactory.openSession();
		causeDao = sqlSession.getMapper(CauseDaoInte.class);
		
		List<Cause> list = causeDao.search_consume(search, id);
		return list;
	}

	public List<Cause> find_cause(String date, int user_id) {
		sqlSession = sqlSessionFactory.openSession();
		causeDao = sqlSession.getMapper(CauseDaoInte.class);
		List<Cause> list = causeDao.find_cause(date, user_id);
		return list;
	}

	public boolean edit(List<Cause> list) {
		sqlSession = sqlSessionFactory.openSession();
		causeDao = sqlSession.getMapper(CauseDaoInte.class);
		return causeDao.edit(list);
	}

	public void edit_old(int user_id, String date) {
		sqlSession = sqlSessionFactory.openSession();
		causeDao = sqlSession.getMapper(CauseDaoInte.class);
		causeDao.edit_old(user_id, date);
	}

}
