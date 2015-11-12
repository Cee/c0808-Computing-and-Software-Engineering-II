package junit.display;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import junit.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.ModulePO;
import po.PO;
import po.TypePO;
import businesslogic.displaybl.StudentInfoDisplay;
import dataservice.DatabaseService;
import dataservice.Table;

public class FrameInfoDisplayTest {
	
	DatabaseService ModuleData;
	DatabaseService typeData;

	@Before
	public void setUp() throws Exception {
		ModuleData = TestHelper.getDatabaseService(Table.module);
		typeData = TestHelper.getDatabaseService(Table.type);
	}

	@After
	public void tearDown() throws Exception {
		ModuleData = null;
		typeData = null;
	}

	@Test
	public void testGetTypeInt() throws RemoteException {
		assertTrue(typeData.find(1) != null);
	}

	@Test
	public void testGetType() throws RemoteException {
		ArrayList<TypePO> tList = new ArrayList<TypePO>();
		ArrayList<PO> list = typeData.findAll();
		for (PO po : list) {
			tList.add((TypePO) po);
		}
		assertTrue(tList != null);
	}

	@Test
	public void testGetModuleInt() throws RemoteException {
		assertTrue(ModuleData.find(1) != null);
	}

	@Test
	public void testGetModule() throws RemoteException {
		ArrayList<ModulePO> mList = new ArrayList<ModulePO>();
		ArrayList<PO> list = ModuleData.findAll();
		for (PO po : list) {
			mList.add((ModulePO) po);
		}
		assertTrue(mList != null);
	}

}
