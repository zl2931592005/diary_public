package dog.diary.entity;

public class Balance {
	private int id;
	private double money;
	private int type_id;
	private int user_id;

	
	public Balance(double money, int type_id, int user_id) {
		this.money = money;
		this.type_id = type_id;
		this.user_id = user_id;
	}
	public Balance() {

	}
	public Balance(int id, double money, int type_id, int user_id) {
		this.id = id;
		this.money = money;
		this.type_id = type_id;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Balance [id=" + id + ", money=" + money + ", type_id="
				+ type_id + ", user_id=" + user_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
