package businesslogic.insteacherbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.StudentPO;
import dataservice.DatabaseService;
/**
 * 
 * @author luck
 * 院系教务老师批量添加课程记录
 */
public class InsTeacherMassManager {
	LessonUniquePO lesson;
	DatabaseService lessonRecordData;
	DatabaseService lessonData;
	
	public InsTeacherMassManager(	DatabaseService lessonRecordData,
	DatabaseService lessonData){
		this.lessonData = lessonData;
		this.lessonRecordData = lessonRecordData;
	}
	
	/**
	 * 根据课程号设置课程 
	 * 因为导入课程记录时同时需要更新课程信息：当前学生人数 
	 * @param les_id
	 * @throws RemoteException
	 * 
	 */
	public void setLesson(int les_id) throws RemoteException {
		this.lesson = (LessonUniquePO) lessonData.find(les_id);
	}
	
	/**
	 * 依次插入课程记录
	 * 同时更新该课程信息
	 * @param studentList
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public boolean addStudent(ArrayList<StudentPO> studentList) throws RemoteException {
		for (StudentPO po : studentList){
			lessonRecordData.insert(new LessonRecordPO(lesson.getLes_Id(), po.getStu_Id(), 0, po.getName(), lesson.getLes_name()));
		}
		lesson.setCur_stu_num(lesson.getCur_stu_num()+studentList.size());
		return lessonData.update(lesson);
	}

	/**
	 * 
	 * @return
	 * 此处为外部文件批量导入
	 * 暂空着
	 */
	public boolean addStudent() {
		return false;
	}
}
