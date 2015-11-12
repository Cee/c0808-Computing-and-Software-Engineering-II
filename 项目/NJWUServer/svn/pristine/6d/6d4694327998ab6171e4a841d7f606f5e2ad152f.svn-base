package po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BroadCastPO extends PO{
	String message;
	String date;
	int id;
	public String getDate() {
		return date;
	}
	public int getId() {
		return id;
	}
	public BroadCastPO(String message){
		this.message = message;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		this.date=df.format(new Date());
	}
	public BroadCastPO(int id,String message,String date){
		this.id = id ;
		this.message = message;
		this.date=date;
	}
	public String getMessage() {
		return message;
	}
	
}
