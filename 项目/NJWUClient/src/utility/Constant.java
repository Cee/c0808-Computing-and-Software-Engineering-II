package utility;
/**
 * 系统参数
 * @author luck
 *
 */
public class Constant {
	public static class UserType{
		public final static int STUDENT = 0;
		public final static int TEACHER = 1;
		public final static int INS_TEACHER = 2;
		public final static int SCH_TEACHER = 3;
		public final static int ADMIN = -1;
		public final static int WRONG_PASSWORD = -2;
		public final static int NO_LOGIN =  -3;
	}

	public static class UserTypeString{
		public final static String STUDENT_STRING = "学生";
		public final static String TEACHER_STRING = "老师";
		public final static String INS_TEACHER_STRING = "院系教务老师";
		public final static String SCH_TEACHER_STRING = "学校教务老师";
		
	}
	
	
	public static class AdminInfo{
		public final static int ID = 0;
		public final static String PASSWORD = "";
	}
	
	public static class NetInfo{
		public final static String ADDRESS = "//localhost:1099/NJWU";
	}
	
	public static class Student{
		public final static int MAXSELECTION = 4;
	}
}
