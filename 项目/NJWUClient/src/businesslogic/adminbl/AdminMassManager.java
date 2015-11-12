package businesslogic.adminbl;

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
import po.StudentPO;
import po.TeacherPO;
import vo.StudentVO;
import vo.TeacherVO;
import dataservice.DatabaseService;
/**
 * 
 * @author luck
 * 支持管理员批量导入以及批量删除
 */
public class AdminMassManager {
	/**
	 * 学生数据服务
	 */
	DatabaseService studentData;
	/**
	 * 教师数据服务
	 */
	DatabaseService teacherData;
	/**
	 * 通过Admin共享
	 * @param studentData
	 * @param teacherData
	 */
	public AdminMassManager(DatabaseService studentData,
			DatabaseService teacherData) {
		this.studentData = studentData;
		this.teacherData = teacherData;
	}
	/**
	 * 
	 * @param studentListFile
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 * 使用外部包jxls.jar进行xls文件的读取
	 * 
	 */
	public ArrayList<StudentVO> addStudent(File studentListFile) throws BiffException,
			IOException {
		ArrayList<StudentVO> studentList = new ArrayList<>();
		InputStream in = new FileInputStream(studentListFile);
		Workbook workbook = Workbook.getWorkbook(in);
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int id=-1;
		int ins_id=-1;
		int name=-1;
		int password=-1;
		int gender=-1;
		int grade=-1;
		int insName = -1;
		Cell[] cells = sheet.getRow(0);
		for (int i = 0; i < cells.length; i++){
			switch (cells[i].getContents()) {
			case "学号":
				id=i;
				break;
			case "院系号":
				ins_id=i;
				break;
			case "院系名":
				insName=i;
				break;
			case "姓名":
				name=i;
				break;
			case "性别":
				gender=i;
				break;
			case "年级":
				grade = i;
				break;
			case "密码":
				password = i;
				break;
			default:
				break;
			}
		}
		if ((id+1)*(ins_id+1)*(name+1)*(gender+1)*(grade+1)*(password+1)==0){
			return null;
		}
		for (int i = 1; i < rows; i++) {
			cells = sheet.getRow(i);
		
			int stu_id= Integer.parseInt(cells[id].getContents());
			int ins_Id = Integer.parseInt(cells[ins_id].getContents());
			String stu_name = cells[name].getContents();
			String genderContent = cells[gender].getContents();
			int gradeContent = Integer.parseInt(cells[grade].getContents());
			String passwordContent = cells[password].getContents();
			String insString = cells[insName].getContents();
			StudentPO student = new StudentPO(stu_id, stu_name,
					passwordContent.toCharArray(), ins_Id, insString, genderContent, gradeContent);
			studentData.insert(student);
			studentList.add(new StudentVO(student));
		}
		in.close();
		return studentList;
	}
	
	/**
	 * 批量导入教师列表
	 * @param teacherListFile
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public ArrayList<TeacherVO> addTeacher(File teacherListFile) throws BiffException,
			IOException {
		ArrayList<TeacherVO> teacherList = new ArrayList<>();
		InputStream in = new FileInputStream(teacherListFile);
		Workbook workbook = Workbook.getWorkbook(in);
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int id=-1;
		int ins_id=-1;
		int name=-1;
		int password=-1;
		int gender=-1;
		int type = -1;
		int insName = -1;
		Cell[] cells = sheet.getRow(0);
		for (int i = 0; i < cells.length; i++){
			switch (cells[i].getContents()) {
			case "工号":
				id=i;
				break;
			case "院系号":
				ins_id=i;
				break;
			case "院系名":
				insName = i;
				break;
			case "姓名":
				name=i;
				break;
			case "性别":
				gender=i;
				break;
			case "密码":
				password = i;
				break;
			case "类别":
				type = i;
			default:
				break;
			}
		}
		if ((id+1)*(ins_id+1)*(name+1)*(gender+1)*(type+1)*(password+1)==0){
			return null;
		}
		for (int i = 1; i < rows; i++) {
			cells = sheet.getRow(i);
			int tea_id = Integer.parseInt(cells[id].getContents());
			int ins_idContent = Integer.parseInt(cells[ins_id].getContents());
			String tea_name = cells[name].getContents();
			String genderContent = cells[gender].getContents();
			String passwordContent = cells[password].getContents();
			int type_Id = Integer.parseInt(cells[type].getContents());
			String insString = cells[insName].getContents();
			TeacherPO teacher = new TeacherPO(tea_id, ins_idContent, tea_name,
					passwordContent.toCharArray(), insString, type_Id,genderContent);
			teacherList.add(new TeacherVO(teacher));
			teacherData.insert(teacher);
		}
		in.close();
		return teacherList;
	}
	/**
	 * 批量删除教师
	 * @param teachers
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteTeacher(int[] teachers) throws RemoteException {
		for (int i : teachers) {
			teacherData.delete(i);
		}
		return true;
	}
	/**
	 * 批量删除学生
	 * @param students
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteStudent(int[] students) throws RemoteException {
		for (int i : students) {
			studentData.delete(i);
		}
		return true;
	}

}
