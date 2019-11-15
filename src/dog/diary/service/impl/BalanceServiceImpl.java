package dog.diary.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dog.diary.dao.mapper.BalanceDaoInte;
import dog.diary.entity.Balance;
import dog.diary.entity.Cause;
import dog.diary.service.inte.BalanceServiceInte;

@Service("balanceService")
public class BalanceServiceImpl implements BalanceServiceInte{

	@Resource(name="balanceDao")
	private BalanceDaoInte bdi;
	
	public List<Balance> select(int user_id) {
		return bdi.select(user_id);
	}

	private double money;
	public void edit(List<Cause> causes,int flag) {
		List<Balance> balances = null;
		for (Cause cause : causes) {
			balances = select(cause.getUser_id());
			for (Balance balance : balances) {
				if(balance.getType_id() == 1 && cause.getManner().equals("支付宝")){
					if(flag == 1){
						money = balance.getMoney() - cause.getMoney();
					}
					if(flag == 2){
						money = balance.getMoney() + cause.getMoney();
					}
					bdi.update(1,money,cause.getUser_id());
				}
				if(balance.getType_id() == 2 && cause.getManner().equals("微信")){
					if(flag == 1){
						money = balance.getMoney() - cause.getMoney();
					}
					if(flag == 2){
						money = balance.getMoney() + cause.getMoney();
					}					
					bdi.update(2,money,cause.getUser_id());
				}
				if(balance.getType_id() == 3 && cause.getManner().equals("现金")){
					if(flag == 1){
						money = balance.getMoney() - cause.getMoney();
					}
					if(flag == 2){
						money = balance.getMoney() + cause.getMoney();
					}
					bdi.update(3,money,cause.getUser_id());
				}
			}
		}
		
	}

}
