package junit.display;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import junit.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataservice.DatabaseService;
import dataservice.Table;
import po.LessonRecordPO;
import po.PO;

public class LessonRecordDisplayTest {
	
	DatabaseService lessonRecordData;
	
	@Before
	public void setUp() throws RemoteException, MalformedURLException, NotBoundException{
		lessonRecordData = TestHelper.getDatabaseService(Table.lesson_record);
	}

	@After
	public void tearDown(){
		lessonRecordData = null;
	}
	
	@Test
	public void testGetLessonRecord() throws RemoteException {
		ArrayList<LessonRecordPO> recordList = new ArrayList<LessonRecordPO>();
		ArrayList<PO> list = lessonRecordData.find(1, 121250156);
		for (PO po : list) {
			recordList.add( (LessonRecordPO)po  );
		}
		assertTrue(recordList != null);
	}

	@Test
	public void testGetStudentOfLesson() throws RemoteException {
		ArrayList<LessonRecordPO> recordList = new ArrayList<LessonRecordPO>();
		ArrayList<PO> list = lessonRecordData.find(2, 0);
		for (PO po : list) {
			recordList.add( (LessonRecordPO) po);
		}
		assertTrue(recordList != null);
	}

}
