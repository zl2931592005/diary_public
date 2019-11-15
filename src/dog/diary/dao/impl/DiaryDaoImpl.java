package dog.diary.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import dog.diary.dao.mapper.DiaryDaoInte;
import dog.diary.entity.Diary;

@Repository("diaryDao")
public class DiaryDaoImpl implements DiaryDaoInte {

	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	private SqlSession sqlSession;
	private boolean bool = false;
	
	public boolean add_diary(Diary d) {
		DiaryDaoInte diaryDaoInte = getMapper();
		
		try {
			diaryDaoInte.add_diary(d);
			bool = true;
		} catch (Exception e) {
			System.out.println(e.toString());
			bool = false;
		}
		
		return bool;
	}


	public List<Diary> select_diary(int userId) {
		DiaryDaoInte diaryDaoInte = getMapper();
		
		List<Diary> list = diaryDaoInte.select_diary(userId);
		return list;
	}

	
	private DiaryDaoInte getMapper() {
		sqlSession = sqlSessionFactory.openSession();
		DiaryDaoInte diaryDaoInte = sqlSession.getMapper(DiaryDaoInte.class);
		return diaryDaoInte;
	}


	public List<Diary> diary_yesorno(String date, int i) {
		DiaryDaoInte diaryDaoInte = getMapper();
		List<Diary> list = diaryDaoInte.diary_yesorno(date,i);
		return list;
	}


	public List<Diary> search(String search, int user_id) {
		DiaryDaoInte diaryDao = getMapper();
		List<Diary> list = diaryDao.search(search,user_id);
		return list;
	}


	public Diary find_diary(String date, int user_id) {
		DiaryDaoInte diaryDao = getMapper();
		Diary diary = diaryDao.find_diary(date,user_id);
		return diary;
	}


	public boolean edit_diary(Diary d) {
		DiaryDaoInte diaryDaoInte = getMapper();
		try {
			diaryDaoInte.edit_diary(d);
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}
}
