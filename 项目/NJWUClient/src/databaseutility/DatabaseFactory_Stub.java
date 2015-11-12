package databaseutility;

import java.rmi.RemoteException;

import dataservice.DatabaseService;
import dataservice.Table;
import dataservice.choosedataservice.SelectRecordData_Stub;
import dataservice.framedataservice.ModuleData_Stub;
import dataservice.framedataservice.TypeData_Stub;
import dataservice.lessondataservice.LessonUnData_Stub;
import dataservice.lessonrecorddataservice.LessonRecordData_Stub;
import dataservice.plandataservice.LessonAbData_Stub;
import dataservice.userdataservice.StudentData_Stub;
import dataservice.userdataservice.TeacherData_Stub;

public class DatabaseFactory_Stub implements DatabaseFactory{
	public DatabaseService getDataBase_Stub(Table table) {
		//根据Table类别 返回相应 Data
		switch (table) {
		case student:
			return new StudentData_Stub();
		case teacher:
			return new TeacherData_Stub();
		case institute:
			return new TeacherData_Stub();
		case lesson_abstract:
			return new LessonAbData_Stub();
		case Lesson_unique:
			return new LessonUnData_Stub();
		case lesson_record:
			return new LessonRecordData_Stub();
		case select_record:
			return new SelectRecordData_Stub();
		case module:
			return new ModuleData_Stub();
		case type:
			return new TypeData_Stub();
		}
		return null;
	}

	@Override
	public String getDataBase(Table table) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

 }
