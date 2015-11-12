package vo;

import po.LessonUniquePO;

public abstract class VO {
	
	public static  String judgeCompulsory(int compulsory) {
		if (compulsory == 1)
			return "必修";
		else if (compulsory == 2)
			return "指选";
		else
			return "选修";
	}

	static protected String judgeCredit(int max_credit, int min_credit) {
		if (max_credit == min_credit)
			return max_credit + "";
		else
			return min_credit + "-" + max_credit;

	}

	static protected String judgeTerm(int term_start, int term_end) {
		if (term_start == term_end)
			return term_start + "";
		else {
			String term = "";
			for (int i = term_start; i < term_end; i++) {
				term = term + i + ";";
			}
			term = term + term_end;
			return term;
		}

	}
	
	static protected String formTime(LessonUniquePO po ){
		String day=null;
		switch (po.getDay()) {
		case 1:
			day="周一 ";
			break;
		case 2:
			day="周二 ";
			break;
		case 3:
			day="周三 ";
			break;
		case 4:
			day="周四 ";
			break;
		case 5:
			day="周五 ";
			break;
		case 6:
			day="周六 ";
			break;
		case 7:
			day="周日  ";
			break;
		default:
			break;
		}
		return day+po.getStart()+"到"+po.getEnd()+"节";
	}
	
}
