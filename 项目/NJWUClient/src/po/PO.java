package po;

import java.io.Serializable;
import java.rmi.Remote;

public class PO implements Remote, Serializable {
	public int UserType = 0;// 0代表学生、1代表任课老师、2代表院系教务老师、3代表学校教务老师
}
