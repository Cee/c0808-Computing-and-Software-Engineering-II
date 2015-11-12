package junit.display;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import junit.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.TeacherPO;

import businesslogic.displaybl.TeacherInfoDisplay;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;

import dataservice.DatabaseService;
import dataservice.Table;

public class TeacherInfoDisplayTest {
	DatabaseService teacherData;
	TeacherInfoDisplayService teacherDisplay;
	@Before
	public void setUp() throws Exception {
		teacherData = TestHelper.getDatabaseService(Table.teacher);
		teacherDisplay = new TeacherInfoDisplay(teacherData);
	}

	@After
	public void tearDown() throws Exception {
		teacherData =null;
		teacherDisplay = null;
	}


	@Test
	public void testGetTeacher() throws RemoteException {
		TeacherPO teacher = teacherDisplay.getTeacher(25014);
		assertTrue(teacher!=null);
	}

	@Test
	public void testGetTeacherList() throws RemoteException {
		ArrayList<TeacherPO> list = teacherDisplay.getTeacherOfIns(25);
		assertTrue(list!=null);
	}

}
