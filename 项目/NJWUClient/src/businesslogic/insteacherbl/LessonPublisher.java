package businesslogic.insteacherbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonUniquePO;

import dataservice.DatabaseService;
/**
 * 负责发布课程
 * @author luck
 * @version  2013.11.10
 * 
 */
public class LessonPublisher {
	DatabaseService lessonData;
	ArrayList<LessonUniquePO> lessonList;
	public LessonPublisher(DatabaseService lessonData){
		this.lessonData = lessonData;
	}
	
	/**
	 * 发布课程
	 * @param po
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public boolean publish(LessonUniquePO po) throws RemoteException{
			return (lessonData.insert(po));
	}
	
	/**
	 * 修改已发布的课程
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean modify(LessonUniquePO po)throws RemoteException{
		for (LessonUniquePO lesson : lessonList) {
			if (lesson.getLes_Id()==po.getLes_Id()){
				lesson = po;
				break;
			}
		}
			return (lessonData.update(po));
	}
	public ArrayList<LessonUniquePO> getLessonList() {
		return lessonList;
	}
	public void setLessonList(ArrayList<LessonUniquePO> lessonList) {
		this.lessonList = lessonList;
	}

	public boolean delete(int les_Id) throws RemoteException {
		return lessonData.delete(les_Id);
	}
}
