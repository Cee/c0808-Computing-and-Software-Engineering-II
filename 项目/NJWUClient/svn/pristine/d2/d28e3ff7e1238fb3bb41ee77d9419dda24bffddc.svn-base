package junit.admin;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import junit.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.StudentPO;
import po.TeacherPO;
import businesslogic.adminbl.AdminMassManager;
import businesslogic.displaybl.StudentInfoDisplay;
import businesslogic.displaybl.TeacherInfoDisplay;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class AdminTest {
	
	DatabaseService studentData;
	DatabaseService teacherData;
	StudentInfoDisplayService studentDisplay;
	TeacherInfoDisplayService teacherDisplay;
	AdminMassManager massManager;

	@Before
	public void setUp() throws Exception {
		studentData = TestHelper.getDatabaseService(Table.student);
		teacherData = TestHelper.getDatabaseService(Table.teacher);
		studentDisplay = new StudentInfoDisplay(studentData);
		teacherDisplay = new TeacherInfoDisplay(teacherData);
		massManager = new AdminMassManager(studentData, teacherData); 
	}

	@After
	public void tearDown() throws Exception {
		studentData = null;
		teacherData = null;
		studentDisplay = null;
		teacherDisplay = null;
		massManager = null; 
	}

	@Test
	public void testAddStudentStudentVO() throws RemoteException {
		char[] password = {1,2,3,4,5};
		assertTrue(studentData.insert(new StudentPO(121250151, "wangkun", password , 0, "111", "boy", 1)) == true);
	}

	@Test
	public void testAddTeacherTeacherVO() throws RemoteException {
		char[] password = {1,2,3,4,5};
		assertTrue(teacherData.insert(new TeacherPO(10001, 1, "123", password, "123", 0, "boy")) == true);
	}

	@Test
	public void testDelStudentInt() throws RemoteException {
		assertTrue(studentData.delete(121250151) == true);
	}

	@Test
	public void testDelTeacherInt() throws RemoteException {
		assertTrue(teacherData.delete(10001) == true);
	}

	@Test
	public void testModifyStudent() throws RemoteException {
		char[] password = {1,2,3,4,5};
		assertTrue(studentData.update(new StudentPO(121250151, "wangkun", password , 0, "111", "boy", 1)) == true);
	}

	@Test
	public void testModifyTeacher() throws RemoteException {
		char[] password = {1,2,3,4,5};
		assertTrue(teacherData.update(new TeacherPO(10001, 1, "123", password, "123", 0, "boy")) == true);
	}

	@Test
	public void testShowStudent() throws RemoteException {
		assertTrue(studentDisplay.getStudent(121250151) != null);
	}

	@Test
	public void testShowStudentofins() throws RemoteException {
		assertTrue(studentDisplay.getStudentList(25,1) != null);
	}

	@Test
	public void testShowTeacher() throws RemoteException {
		assertTrue(teacherDisplay.getTeacher(10001) != null);
	}

	@Test
	public void testShowTeacherofins() throws RemoteException {
		assertTrue(teacherDisplay.getTeacherOfIns(25) != null);
	}

}
