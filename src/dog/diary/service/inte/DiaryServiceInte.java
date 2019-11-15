package dog.diary.service.inte;

import java.util.List;

import javax.servlet.http.HttpSession;

import dog.diary.entity.Diary;

public interface DiaryServiceInte {
	public boolean add_diary(Diary d, HttpSession session);
	public List<Diary> select_diary_cause(HttpSession httpSession);
	public boolean diary_yesorno(String date, int i);
	public List<Diary> search(String search, int id);
	public Diary find_diary(String date, int user_id);
	public boolean edit_diary(Diary d, int id);
}
