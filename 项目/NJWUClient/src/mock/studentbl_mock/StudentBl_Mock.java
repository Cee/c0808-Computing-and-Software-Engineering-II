package mock.studentbl_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonAbstractPO;
import po.LessonRecordPO;
import po.LessonUniquePO;

import mock.display_mock.LessonDisplay_Mock;
import mock.display_mock.LessonRecordDisplay_Mock;
import mock.display_mock.PlanDisplay_Mock;

import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.PlanVO;
import vo.ScheduleVO;
import vo.ScoreVO;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.PlanDisplayService;
import businesslogicservice.studentblservice.StudentBlService;

public class StudentBl_Mock implements StudentBlService{
	LessonDisplayService lessonDisplayService = new LessonDisplay_Mock();
	LessonRecordDisplayService lessonRecordDisplayService = new LessonRecordDisplay_Mock();
	PlanDisplayService planDisplayService = new PlanDisplay_Mock();
	@Override
	public boolean submit() throws RemoteException {
		return true;
	}

	@Override
	public boolean select(int Les_id) throws RemoteException {
		return true;
	}

	@Override
	public boolean cancel(int Les_id) throws RemoteException {
		return true;
	}

	@Override
	public boolean by_select(int Les_id) throws RemoteException {
		return true;
	}

	@Override
	public boolean by_cancel(int Les_id) throws RemoteException {
		return true;
	}

	@Override
	public ScheduleVO show_myLesson() throws RemoteException {
		return new ScheduleVO(lessonDisplayService.getLessonsOfIns(25).iterator());
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return true;
	}

	@Override
	public ScoreVO show_myScore() throws RemoteException {
		try {
			ArrayList<LessonRecordPO> list = lessonRecordDisplayService.getLessonRecord(0);
			ArrayList<LessonRecordVO> voList = new ArrayList<LessonRecordVO>();
			for (LessonRecordPO po : list){
				voList.add(new LessonRecordVO(po));
			}
			return new ScoreVO(voList.iterator());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
			
	}

	@Override
	public Iterator<LessonUniqueVO> showBySelection(int Ins_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> list = lessonDisplayService.getLessonOfTeacher(0);
		ArrayList<LessonUniqueVO> voList = new ArrayList<>();
		for (LessonUniquePO po : list){
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();		
	}

	@Override
	public void setLessonType(int lessonType) throws RemoteException {
	}

	@Override
	public Iterator<LessonUniqueVO> showSelection(int Ins_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> list = lessonDisplayService.getLessonOfTeacher(0);
		ArrayList<LessonUniqueVO> voList = new ArrayList<>();
		for (LessonUniquePO po : list){
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<LessonUniqueVO> show_mySelection() throws RemoteException {
		ArrayList<LessonUniquePO> list = lessonDisplayService.getLessonOfTeacher(0);
		ArrayList<LessonUniqueVO> voList = new ArrayList<>();
		for (LessonUniquePO po : list){
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();
	}

	@Override
	public PlanVO showPlan() throws RemoteException {
		ArrayList<LessonAbstractPO> list = planDisplayService.getPlanofIns(0);
		return new PlanVO(list);
	}

}
