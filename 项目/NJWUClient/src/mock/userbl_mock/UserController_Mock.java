package mock.userbl_mock;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.PO;
import utility.Constant;
import utility.CurrentState;
import businesslogicservice.userblservice.BroadCastReceiverService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;

public class UserController_Mock implements UserControllerService{
	int usertype;
	public UserController_Mock(){
		String[] list = new String[2];
		list[0]= "公共课程";
		list[1]= "软件学院";
		CurrentState.institutes = list;
	}
	@Override
	public int login(int id, char[] password) throws RemoteException,
			MalformedURLException, NotBoundException {
		switch (id) {
		case 0:
			usertype = Constant.UserType.ADMIN;
			return Constant.UserType.ADMIN;
		case 121250151:
			usertype = Constant.UserType.STUDENT;
			return Constant.UserType.STUDENT;
		case 100:
			usertype = Constant.UserType.SCH_TEACHER;
			return Constant.UserType.SCH_TEACHER;
		case 25014:
			usertype = Constant.UserType.TEACHER;
			return Constant.UserType.TEACHER;
		case 25041:
			usertype = Constant.UserType.INS_TEACHER;
			return Constant.UserType.INS_TEACHER;
		default:
			break;
		}
		return Constant.UserType.NO_LOGIN;
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return true;
	}

	@Override
	public PO getInformation() {
		return null;
	}

	@Override
	public String getName() {
		switch (usertype) {
		case Constant.UserType.ADMIN:
			return "管理员";
		case Constant.UserType.STUDENT:
			return "王琨";
		case Constant.UserType.TEACHER:
			return "刘钦";
		case Constant.UserType.INS_TEACHER:
			return "王东霞";
		case Constant.UserType.SCH_TEACHER:
			return "学校教务老师";
		default:
			break;
		}
		return  null;
	}

	@Override
	public DatabaseFactory getFactory() {
		return null;
	}
	@Override
	public void reConnect() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public BroadCastReceiverService getBroadCast() throws RemoteException,
			MalformedURLException, NotBoundException {
		// TODO 自动生成的方法存根
		return null;
	}

}
