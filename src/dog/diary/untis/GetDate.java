package dog.diary.untis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}
}
