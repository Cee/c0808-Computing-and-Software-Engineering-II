package mock.teacherbl_mock;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.StudentPO;

import mock.display_mock.LessonDisplay_Mock;
import mock.display_mock.LessonRecordDisplay_Mock;
import mock.display_mock.StudentInfoDisplay_Mock;

import jxl.read.biff.BiffException;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.teacherblservice.TeacherBlService;

public class TeacherBl_Mock implements TeacherBlService{
	LessonDisplayService lessonDisplayService = new LessonDisplay_Mock();
	StudentInfoDisplayService studentInfoDisplayService = new StudentInfoDisplay_Mock();
	LessonRecordDisplayService lessonRecordDisplayService = new LessonRecordDisplay_Mock();
	@Override
	public boolean recordScore() throws RemoteException {
		return true;
	}

	@Override
	public boolean editLesInfo(LessonUniqueVO lesson) throws RemoteException {
		return true;
	}

	@Override
	public Iterator<LessonUniqueVO> showMyLesson() throws RemoteException {
		ArrayList<LessonUniquePO> list = lessonDisplayService.getLessonOfTeacher(0);
		ArrayList<LessonUniqueVO> voList = new ArrayList<>();
		for (LessonUniquePO po : list){
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<StudentVO> showMyStudent(int les_id) throws RemoteException {
		ArrayList<StudentPO> list = studentInfoDisplayService.getStudentList(0, 0);
		ArrayList<StudentVO> voList = new ArrayList<>();
		for (StudentPO po :list){
			voList.add(new StudentVO(po));
		}
		return voList.iterator();
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean addScore(int Stu_Id, int score) throws RemoteException {
		return true;
	}

	@Override
	public Iterator<LessonRecordVO> chooseLesson(int les_id)
			throws RemoteException {
		return null;
	}

	@Override
	public LessonUniqueVO showDetail(int les_id) throws RemoteException {
		return new LessonUniqueVO(lessonDisplayService.getLessonInfo(les_id));
	}

	@Override
	public Iterator<LessonRecordVO> showNewScore() {
		try {
			ArrayList<LessonRecordPO> list = lessonRecordDisplayService.getLessonRecord(0);
			ArrayList<LessonRecordVO> voList = new ArrayList<LessonRecordVO>();
			for (LessonRecordPO po : list){
				voList.add(new LessonRecordVO(po));
			}
			return voList.iterator();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public boolean massImport(File file) throws BiffException, IOException {
		return true;
	}

}
