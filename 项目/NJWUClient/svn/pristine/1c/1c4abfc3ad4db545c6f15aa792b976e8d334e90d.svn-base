package mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.PO;
import po.SelectRecordPO;
import po.StudentPO;
import businesslogic.schteacherbl.SelectManager;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.SelectRecordDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import dataservice.lessonrecorddataservice.LessonRecordDataService;

public class SelectManagerMock {
	
	private static SelectRecordDisplayService selectRecordDisplay;
	private static LessonRecordDisplayService lessonRecordDisplay;
	private static LessonRecordDataService lessonRecordDataService;
	private static LessonDisplayService lessonDisplay;
	private static StudentInfoDisplayService studentDisplay;
	
	public static void main(String [] args){
		
		
		SelectManager selectManager = new SelectManager(selectRecordDisplay,lessonRecordDisplay,lessonRecordDataService,lessonDisplay,studentDisplay, null);
		
	}
	
	
	
}

class selR implements SelectRecordDisplayService{

	public ArrayList<SelectRecordPO> getChooseList(int stu_id, int type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SelectRecordPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SelectRecordPO> getRecordOfLesson(int lesson_Id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}


class lessonRDis implements LessonRecordDisplayService{

	@Override
	public ArrayList<LessonRecordPO> getLessonRecord(int stu_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LessonRecordPO> getStudentOfLesson(int les_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}

class lessonRDat implements LessonRecordDataService{

	@Override
	public boolean insert(PO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PO find(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PO> find(int condition, int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class lessonDis implements LessonDisplayService{

	@Override
	public ArrayList<LessonUniquePO> getByChooseLesson(int type, int ins_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LessonUniquePO> getLessonsOfIns(int ins_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LessonUniquePO> getLessonOfTeacher(int tea_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LessonUniquePO getLessonInfo(int Les_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}


class student implements StudentInfoDisplayService{

	@Override
	public StudentPO getStudent(int stu_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StudentPO> getStudentList(int ins_id, int grade)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

