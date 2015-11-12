package businesslogic.teacherbl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import po.LessonRecordPO;
import dataservice.DatabaseService;
/**
 * 协助教师录入分数
 * @author luck
 *
 */
public class ScoreRecordHelper {
	/**
	 * 原有记录
	 */
	ArrayList<LessonRecordPO> lesRecordList = new ArrayList<LessonRecordPO>();
	/**
	 * 修改过的记录
	 */
	ArrayList<LessonRecordPO> changeList = new ArrayList<>();
	DatabaseService lessonRecordData;
	int id;
	
	public boolean massImport(File file) throws BiffException, IOException{
		InputStream in = new FileInputStream(file);
		Workbook workbook = Workbook.getWorkbook(in);
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		for (int i = 0; i < rows; i++) {
			Cell[] cells = sheet.getRow(i);
			int stu_id = Integer.parseInt(cells[0].getContents());
			String stu_name = cells[1].getContents();
			int score = Integer.parseInt(cells[2].getContents());
			updataRecord(stu_id, score);
		}
		return true;
	}
	
	
	public ScoreRecordHelper(int lesId, ArrayList<LessonRecordPO> lesRecordList,
			DatabaseService lessonRecordData) {
		this.id = lesId;
		this.lesRecordList = lesRecordList;
		this.lessonRecordData = lessonRecordData;
	}

	public ArrayList<LessonRecordPO> getLesRecordList() {
		return lesRecordList;
	}

	/**
	 * 更新修改过的记录
	 * @param Stu_Id
	 * @param score
	 */
	public void updataRecord(int Stu_Id, int score) {
		for (LessonRecordPO po : lesRecordList) {
			if (po.getStu_Id() == Stu_Id) {
				po.setScore(score);
				changeList.add(po);
				break;
			}
		}
	}
	
	/**
	 * 保存
	 * @return
	 * @throws RemoteException
	 */
	public boolean recordScore() throws RemoteException {
		for (LessonRecordPO po : changeList) {
			if (!lessonRecordData.update(po)){
				return false;
			}
		}
		return true;
	}
}
