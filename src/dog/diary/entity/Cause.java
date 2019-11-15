package dog.diary.entity;

public class Cause {
	private int id;
	private String cause;
	private double money;
	private String manner;
	private String date;
	private int user_id;

	
	public Cause(String cause, double money, String manner, String date,
			int user_id) {
		this.cause = cause;
		this.money = money;
		this.manner = manner;
		this.date = date;
		this.user_id = user_id;
	}
	public Cause() {

	}
	public Cause(int id, String cause, double money, String manner,
			String date, int user_id) {
		this.id = id;
		this.cause = cause;
		this.money = money;
		this.manner = manner;
		this.date = date;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Cause [id=" + id + ", cause=" + cause + ", money=" + money
				+ ", manner=" + manner + ", date=" + date + ", user_id="
				+ user_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getManner() {
		return manner;
	}
	public void setManner(String manner) {
		this.manner = manner;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
