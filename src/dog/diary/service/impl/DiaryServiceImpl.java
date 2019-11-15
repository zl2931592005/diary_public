package dog.diary.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import dog.diary.dao.mapper.DiaryDaoInte;
import dog.diary.entity.Diary;
import dog.diary.entity.User;
import dog.diary.service.inte.DiaryServiceInte;
import dog.diary.untis.GetDate;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryServiceInte{

	@Resource(name="diaryDao")
	private DiaryDaoInte ddi;
	
	public boolean add_diary(Diary d, HttpSession session) {
		if(d.getDiary()!=null && !"".equals(d.getDiary())){
			User user = (User) session.getAttribute("user");
			
			d.setDate(new GetDate().getDate());
			d.setUser_id(user.getId());
			return ddi.add_diary(d);
		}
		return false;
	}

	public List<Diary> select_diary_cause(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Diary> list = ddi.select_diary(user.getId());
		return list;
	}

	public boolean diary_yesorno(String date, int i) {
		List<Diary> list = ddi.diary_yesorno(date,i);
		if(list.size() > 0){
			return true;
		}
		return false;
	}

	public List<Diary> search(String search, int user_id) {
		return ddi.search(search,user_id);
	}

	public Diary find_diary(String date, int user_id) {
		return ddi.find_diary(date,user_id);
	}

	public boolean edit_diary(Diary d, int user_id) {
		if(d.getDiary()!=null && !"".equals(d.getDiary())){
			d.setUser_id(user_id);
			return ddi.edit_diary(d);
		}
		return false;
	}


}
