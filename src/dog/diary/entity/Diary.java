package dog.diary.entity;


public class Diary{
	private int id;
	private String diary;
	private String date;
	private int user_id;
	private double sum_cause;
	
	public double getSum_cause() {
		return sum_cause;
	}
	public void setSum_cause(double sum_cause) {
		this.sum_cause = sum_cause;
	}
	public Diary(int id, String diary, String date, int user_id,
			double sum_cause) {
		super();
		this.id = id;
		this.diary = diary;
		this.date = date;
		this.user_id = user_id;
		this.sum_cause = sum_cause;
	}
	public Diary() {

	}
	public Diary(int id, String diary, String date, int user_id) {
		super();
		this.id = id;
		this.diary = diary;
		this.date = date;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Diary [id=" + id + ", diary=" + diary + ", date=" + date
				+ ", user_id=" + user_id + ", sum_cause=" + sum_cause + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
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
