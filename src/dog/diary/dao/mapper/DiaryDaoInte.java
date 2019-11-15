package dog.diary.dao.mapper;

import java.util.List;

import dog.diary.entity.Diary;

public interface DiaryDaoInte {
	public boolean add_diary(Diary d);
	public List<Diary> select_diary(int i);
	public List<Diary> diary_yesorno(String date, int i);
	public List<Diary> search(String search, int id);
	public Diary find_diary(String date, int id);
	public boolean edit_diary(Diary d);
}
