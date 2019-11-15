package dog.diary.service.inte;

import java.util.List;

import dog.diary.entity.Balance;
import dog.diary.entity.Cause;

public interface BalanceServiceInte {

	public List<Balance> select(int i);

	public void edit(List<Cause> list, int flag);

}
