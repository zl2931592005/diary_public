package dog.diary.dao.mapper;

import java.util.List;

import dog.diary.entity.Cause;

public interface CauseDaoInte {
	public boolean add_cause(List<Cause> list);
	public List<Cause> select_cause(int user_id);
	public List<Cause> search_consume(String search, int id);
	public List<Cause> find_cause(String date, int id);
	public boolean edit(List<Cause> list);
	public void edit_old(int user_id, String date);
}
