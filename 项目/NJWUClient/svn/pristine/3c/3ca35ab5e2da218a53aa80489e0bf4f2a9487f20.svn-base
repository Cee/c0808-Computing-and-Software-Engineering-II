package junit.display;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import junit.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.LessonAbstractPO;
import po.PO;
import dataservice.DatabaseService;
import dataservice.Table;

public class PlanDisplayTest {
	
	DatabaseService lesAbData;

	@Before
	public void setUp() throws Exception {
		lesAbData = TestHelper.getDatabaseService(Table.lesson_abstract);
	}

	@After
	public void tearDown() throws Exception {
		lesAbData = null;
	}

	@Test
	public void testGetPlan() throws RemoteException {
		assertTrue(lesAbData.find(0) == null);
	}

	@Test
	public void testGetPlanofIns() throws RemoteException {
		ArrayList<LessonAbstractPO> pList = new ArrayList<LessonAbstractPO>();

		ArrayList<PO> list = lesAbData.find(1, 25);
		for (PO po : list) {
			pList.add((LessonAbstractPO) po);
		}
		assertTrue(pList != null);
	}

}
