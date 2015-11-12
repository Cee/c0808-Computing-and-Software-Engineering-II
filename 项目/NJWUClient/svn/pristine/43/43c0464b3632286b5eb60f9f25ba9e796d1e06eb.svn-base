package junit.display;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import junit.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.LessonUniquePO;
import po.PO;
import businesslogic.displaybl.LessonDisplay;
import businesslogicservice.displayblservice.LessonDisplayService;
import dataservice.DatabaseService;
import dataservice.Table;

public class LessonDisplayTest {

	DatabaseService lessonDisplayData;
	LessonDisplayService lessonDisplay;
	
	@Before
	public void setUp() throws Exception {
		lessonDisplayData = TestHelper.getDatabaseService(Table.Lesson_unique);
		lessonDisplay = new LessonDisplay(lessonDisplayData);
	}

	@After
	public void tearDown() throws Exception {
		lessonDisplayData = null;
		lessonDisplay = null;
	}

	@Test
	public void testGetByChooseLesson() throws RemoteException {
		ArrayList<LessonUniquePO> choosenList = new ArrayList<LessonUniquePO>();
		ArrayList<PO> list = lessonDisplayData.find(0, 25);
		for (PO po : list) {
			LessonUniquePO lesson = (LessonUniquePO) po;
			if (lesson.getState()==0)
				choosenList.add(lesson);
		}
		assertTrue(choosenList != null);
	}
	
	@Test
	public void testGetLessonsOfIns() throws RemoteException {
		ArrayList<LessonUniquePO> iList = new ArrayList<LessonUniquePO>();
		ArrayList<PO> list = lessonDisplayData.find(-1, 25);
		for (PO po : list) {
			iList.add((LessonUniquePO) po);
		}
		assertTrue(iList != null);
	}

	@Test
	public void testGetLessonOfTeacher() throws RemoteException {
		ArrayList<LessonUniquePO> tList = new ArrayList<LessonUniquePO>();
		ArrayList<PO> list = lessonDisplayData.find(0, 25014);
		for (PO po : list) {
			LessonUniquePO lesson = (LessonUniquePO)po;
			if (lesson.getState()==0)
				tList.add(lesson);
		}
		assertTrue(tList != null);
	}

	@Test
	public void testGetLessonInfo() throws RemoteException {
		assertTrue(lessonDisplayData.find(0) == null);
	}

}