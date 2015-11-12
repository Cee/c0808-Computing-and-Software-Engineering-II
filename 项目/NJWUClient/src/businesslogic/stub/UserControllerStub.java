package businesslogic.stub;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.userblservice.BroadCastReceiverService;
import businesslogicservice.userblservice.UserControllerService;
import po.PO;
import po.StudentPO;
import po.TeacherPO;
import po.User;
import databaseutility.DatabaseFactory;
import databaseutility.DatabaseFactory_Stub;
import dataservice.DatabaseService;
import dataservice.Table;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.17
 * 用户控制类的桩
 */
public class UserControllerStub implements UserControllerService{
	DatabaseFactory_Stub databaseFactory = new DatabaseFactory_Stub();
	DatabaseService databaseService;
	PO information;
	@Override
	public int login(int id, char[] password) throws RemoteException {
		if (id==0){
			System.out.println("验证身份为管理员");
			return -1;
		}
		if (id>=100000000){
			databaseService = databaseFactory.getDataBase_Stub(Table.student);
			System.out.println("验证身份为学生");
			information = databaseService.find(id);	
		} else {
			databaseService = databaseFactory.getDataBase_Stub(Table.teacher);
			System.out.println("验证身份为教师");
			information=databaseService.find(id);
		}
		System.out.println("id与密码核对成功,fromUserController");
		return information.UserType;
	}
	@Override
	public boolean changePassword(char[] old, char[] newPassword) throws RemoteException {
		User user;
		if (information!=null){
			if (information.UserType==0){
				user = (StudentPO)information;
				user.setPassword(old, newPassword);
			
			}
				else {
				user = (TeacherPO)information;
				user.setPassword(old, newPassword);
				
			}
			databaseService.update(information);
			System.out.println("密码修改成功");
			return true;				
		}
		return false;
		
		
	}
	@Override
	public PO getInformation() {
		return information;
	}
	@Override
	public String getName() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public DatabaseFactory getFactory() {
		// TODO 自动生成的方法存根
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
