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

import po.PO;
import po.SelectRecordPO;
import dataservice.DatabaseService;
import dataservice.Table;

public class SelectRecordDisplayTest {
	
	DatabaseService selectRecordData;
	
	@Before
	public void setUp() throws RemoteException, MalformedURLException, NotBoundException{
		selectRecordData = TestHelper.getDatabaseService(Table.select_record);
	}

	@After
	public void tearDown(){
		selectRecordData = null;
	}
	
	@Test
	public void testGetRecordOfLesson() throws RemoteException {
		ArrayList<SelectRecordPO> cList = new ArrayList<SelectRecordPO>();
		ArrayList<PO> list = selectRecordData.find(0, 0);
		for (PO po : list) {
			cList.add((SelectRecordPO) po);
		}
		assertTrue(cList != null);
	}

	@Test
	public void testGetAll() throws RemoteException {
		ArrayList<SelectRecordPO> cList = new ArrayList<SelectRecordPO>();
		ArrayList<PO> list = selectRecordData.findAll();
		for (PO po : list) {
			cList.add((SelectRecordPO) po);
		}
		assertTrue(cList != null);
	}

	@Test
	public void testGetChooseList() throws RemoteException {
		ArrayList<SelectRecordPO> cList = new ArrayList<SelectRecordPO>();
		ArrayList<PO> list = selectRecordData.find(121250151, 0);
		for (PO po : list) {
			cList.add((SelectRecordPO) po);
		}
		assertTrue(cList != null);
	}

}
