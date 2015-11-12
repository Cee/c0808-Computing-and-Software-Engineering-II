package mock.display_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ModulePO;
import po.TypePO;
import businesslogicservice.displayblservice.FrameInfoDisplayService;

public class FrameInfoDisplay_Mock implements FrameInfoDisplayService{
	TypePO type =  new TypePO(1, 1, "通识通修课程", "通识研讨课程", 3, 1, 8, 14, 14);
	ModulePO module = new ModulePO(1, "通识通修课程", 56, 65);
	@Override
	public TypePO getType(int id) throws RemoteException {
		return type;
	}

	@Override
	public ArrayList<TypePO> getType() throws RemoteException {
		ArrayList<TypePO> list = new ArrayList<>();
		list.add(type);
		return list;
	}

	@Override
	public ModulePO getModule(int id) throws RemoteException {
		return module;
	}

	@Override
	public ArrayList<ModulePO> getModule() throws RemoteException {
		ArrayList<ModulePO> list = new ArrayList<>();
		list.add(module);
		return list;
	}

}
