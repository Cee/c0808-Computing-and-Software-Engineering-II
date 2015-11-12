package dataservice;

public enum Table {
	broadcast,system,module,type,teacher,student,select_record,lesson_abstract,Lesson_unique,lesson_record,institute;
	public String toString(){
		switch (this) {
		case broadcast:
			return "broadcast";
		case system:
			return "system";
		case module:
			return "module";
		case type:
			return "type";
		case student:
			return "student";
		case teacher:
			return "teacher";
		case select_record:
			return "select_record";
		case lesson_abstract:
			return "lesson_abstract";
		case Lesson_unique:
			return "lesson_unique";
		case lesson_record:
			return "lesson_record";
		case institute:
			return "institute";
		default:
			return null;
		}
	}

	
}
