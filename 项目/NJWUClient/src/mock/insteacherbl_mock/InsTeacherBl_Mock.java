package mock.insteacherbl_mock;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import mock.display_mock.FrameInfoDisplay_Mock;
import mock.display_mock.LessonDisplay_Mock;
import mock.display_mock.LessonRecordDisplay_Mock;
import mock.display_mock.PlanDisplay_Mock;
import mock.display_mock.StudentInfoDisplay_Mock;
import mock.display_mock.TeacherInfoDisplay_Mock;
import po.LessonAbstractPO;
import po.LessonRecordPO;
import po.LessonUniquePO;
import po.ModulePO;
import po.StudentPO;
import po.TeacherPO;
import po.TypePO;
import vo.LessonAbstractVO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;
import businesslogicservice.displayblservice.FrameInfoDisplayService;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.PlanDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import businesslogicservice.insteacherblservice.InsTeacherBlService;

public class InsTeacherBl_Mock implements InsTeacherBlService{
	TeacherInfoDisplayService teacherInfoDisplayService = new TeacherInfoDisplay_Mock();
	LessonDisplayService lessonDisplayService = new LessonDisplay_Mock();
	LessonRecordDisplayService lessonRecordDisplayService = new LessonRecordDisplay_Mock();
	PlanDisplayService planDisplayService = new PlanDisplay_Mock();
	FrameInfoDisplayService frameInfoDisplayService = new FrameInfoDisplay_Mock();
	StudentInfoDisplayService studentInfoDisplayService = new StudentInfoDisplay_Mock();
	@Override
	public boolean publishLesson(LessonUniqueVO newLesson)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean addStudent(File file) {
		return true;
	}

	@Override
	public boolean addLesson(LessonAbstractVO vo) throws RemoteException {
		return true;
	}

	@Override
	public boolean addStudent(LessonRecordVO les_RecordVO)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean modifyPlan(LessonAbstractVO lesson_abstractVO)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean modifyLesson(LessonUniqueVO lesson_uniqueVO)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean deleteStudent(LessonRecordVO les_RecordVO)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean deleteLesson(int Les_Id) throws RemoteException {
		return true;
	}

	@Override
	public boolean deletePlan(int les_Ab_id) throws RemoteException {
		return true;
	}

	@Override
	public Iterator<LessonUniqueVO> showLesson() throws RemoteException {
		ArrayList<LessonUniquePO> list = lessonDisplayService.getLessonOfTeacher(0);
		ArrayList<LessonUniqueVO> voList = new ArrayList<>();
		for (LessonUniquePO po : list){
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<LessonRecordVO> showStudentofLesson(int les_id)
			throws RemoteException {
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
	public PlanVO showPlan() throws RemoteException {
		ArrayList<LessonAbstractPO> list = planDisplayService.getPlanofIns(0);
		return new PlanVO(list);
	}

	@Override
	public Iterator<LessonAbstractVO> getPlan() throws RemoteException {
		ArrayList<LessonAbstractPO> list = planDisplayService.getPlanofIns(0);
		ArrayList<LessonAbstractVO> voList = new ArrayList<>();
		for (LessonAbstractPO po :list){
			voList.add(new LessonAbstractVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<StudentVO> showStudent(int grade) throws RemoteException {
		ArrayList<StudentPO> list = studentInfoDisplayService.getStudentList(25, grade);
		ArrayList<StudentVO> voList = new ArrayList<>();
		for (StudentPO po :list){
			voList.add(new StudentVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<TypeVO> getAllTypes() throws RemoteException {
		ArrayList<TypePO> list = frameInfoDisplayService.getType();
		ArrayList<TypeVO> voList = new ArrayList<>();
		for (TypePO po :list){
			voList.add(new TypeVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<ModuleVO> getAllModules() throws RemoteException {
		ArrayList<ModulePO> list = frameInfoDisplayService.getModule();
		ArrayList<ModuleVO> voList = new ArrayList<>();
		for (ModulePO po :list){
			voList.add(new ModuleVO(po));
		}
		return voList.iterator();
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return true;
	}

	@Override
	public ArrayList<TeacherVO> getTeacherOfIns(int ins_id)
			throws RemoteException {
		ArrayList<TeacherPO> list = teacherInfoDisplayService.getTeacherOfIns(ins_id);
		ArrayList<TeacherVO> voList = new ArrayList<>();
		for (TeacherPO po :list){
			voList.add(new TeacherVO(po));
		}
		return voList;
	}

	@Override
	public boolean addStudent(int les_Id, int grade) throws RemoteException {
		return true;
	}

	@Override
	public TeacherVO getTeacher(int tea_id) throws RemoteException {
		return new TeacherVO(teacherInfoDisplayService.getTeacher(tea_id));
	}

}
