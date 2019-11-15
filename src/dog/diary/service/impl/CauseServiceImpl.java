package dog.diary.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dog.diary.dao.mapper.CauseDaoInte;
import dog.diary.entity.Cause;
import dog.diary.service.inte.BalanceServiceInte;
import dog.diary.service.inte.CauseServiceInte;

@Service("causeService")
public class CauseServiceImpl implements CauseServiceInte{

	@Resource(name="causeDao")
	private CauseDaoInte cdi;
	@Resource(name="balanceService")
	private BalanceServiceInte bsi;
	
	public boolean add_cause(List<Cause> list) {
		bsi.edit(list,1);
		return cdi.add_cause(list);
	}

	public List<Cause> select_cause(int user_id) {
		return cdi.select_cause(user_id);
	}

	public List<Cause> search_consume(String search, int id) {
		return cdi.search_consume(search,id);
	}

	public List<Cause> find_cause(String date, int id) {
		return cdi.find_cause(date,id);
	}

	public boolean edit_cause(int user_id, String date, List<Cause> list, List<Cause> old_causes) {
		
		bsi.edit(old_causes,2);
		cdi.edit_old(user_id,date);
		if(list != null){
			bsi.edit(list, 1);
			return cdi.edit(list);
		}
		return true;
	}

}
