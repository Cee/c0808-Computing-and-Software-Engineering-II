package mock.schteacherbl_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import mock.display_mock.FrameInfoDisplay_Mock;
import mock.display_mock.LessonDisplay_Mock;
import mock.display_mock.PlanDisplay_Mock;
import mock.display_mock.StudentInfoDisplay_Mock;
import mock.display_mock.TeacherInfoDisplay_Mock;

import po.LessonAbstractPO;
import po.LessonUniquePO;
import po.StudentPO;
import po.SystemState;
import po.TeacherPO;
import vo.FrameVO;
import vo.LessonAbstractVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;
import businesslogicservice.displayblservice.FrameInfoDisplayService;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.PlanDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import businesslogicservice.schteacherblservice.SchTeacherBlService;

public class SchTeacherBl_Mock implements SchTeacherBlService {
	FrameInfoDisplayService frameInfoDisplayService = new FrameInfoDisplay_Mock();
	PlanDisplayService planDisplayService = new PlanDisplay_Mock();
	StudentInfoDisplayService studentInfoDisplayService = new StudentInfoDisplay_Mock();
	TeacherInfoDisplayService teacherInfoDisplayService = new TeacherInfoDisplay_Mock();
	LessonDisplayService lessonDisplayService = new LessonDisplay_Mock();

	@Override
	public boolean addLesson(LessonAbstractVO lesson) throws RemoteException {
		return true;
	}

	@Override
	public boolean addType(TypeVO typeVO) throws RemoteException {
		return true;
	}

	@Override
	public boolean addModule(ModuleVO moduleVO) throws RemoteException {
		return true;
	}

	@Override
	public boolean modifyLesson(LessonAbstractVO lessonAbstractVO)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean modifyType(TypeVO typeVO) throws RemoteException {
		return true;
	}

	@Override
	public boolean modifyModule(ModuleVO moduleVO) throws RemoteException {
		return true;
	}

	@Override
	public boolean deleteType(int id) throws RemoteException {
		return true;
	}

	@Override
	public boolean deleteModule(int id) throws RemoteException {
		return true;
	}

	@Override
	public boolean deleteLesson(int id) throws RemoteException {
		return true;
	}

	@Override
	public Iterator<StudentVO> showStudentList(int ins_id, int grade) {
		ArrayList<StudentPO> list;
		try {
			list = studentInfoDisplayService.getStudentList(0, 0);
			ArrayList<StudentVO> voList = new ArrayList<>();
			for (StudentPO po : list) {
				voList.add(new StudentVO(po));
			}
			return voList.iterator();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterator<TeacherVO> showTeacherList(int ins_id)
			throws RemoteException {
		ArrayList<TeacherPO> list = teacherInfoDisplayService
				.getTeacherOfIns(ins_id);
		ArrayList<TeacherVO> voList = new ArrayList<>();
		for (TeacherPO po : list) {
			voList.add(new TeacherVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<LessonUniqueVO> showLessonList(int ins_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> list = lessonDisplayService
				.getLessonOfTeacher(0);
		ArrayList<LessonUniqueVO> voList = new ArrayList<>();
		for (LessonUniquePO po : list) {
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean setState(SystemState state) throws RemoteException {
		return true;
	}

	@Override
	public PlanVO showPlan(int ins_id) throws RemoteException {
		ArrayList<LessonAbstractPO> list = planDisplayService.getPlanofIns(0);
		return new PlanVO(list);
	}

	@Override
	public FrameVO showFrame() throws RemoteException {
		return new FrameVO(frameInfoDisplayService.getModule(),
				frameInfoDisplayService.getType(),
				planDisplayService.getPlanofIns(0));
	}

	@Override
	public void alloSelect() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean sendBroadCast(String message) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}
}
