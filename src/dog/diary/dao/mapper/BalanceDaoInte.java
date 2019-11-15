package dog.diary.dao.mapper;

import java.util.List;

import dog.diary.entity.Balance;

public interface BalanceDaoInte {

	public List<Balance> select(int user_id);

	public void update(int manner, double d, int i);

	public boolean add(List<Balance> list);

}
