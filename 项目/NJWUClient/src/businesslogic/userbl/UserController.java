package businesslogic.userbl;

import java.net.MalformedURLException;
import utility.Constant;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import po.InstitutePO;
import po.PO;
import po.StudentPO;
import po.SystemState;
import po.TeacherPO;
import utility.CurrentState;
import businesslogicservice.userblservice.BroadCastReceiverService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;
/**
 * UserControllerService实现
 * @author luck
 *
 */
public class UserController implements UserControllerService {
	Random random = new Random();

	/**
	 * 用户信息
	 */
	PO information;
	/**
	 * 数据层工厂
	 */
	DatabaseFactory databaseFactory;
	DatabaseService databaseService;
	/**
	 * 密码
	 */
	String password;
	/**
	 * 登录者姓名
	 */
	String name;

	/**
	 * 如果是管理员 返回管理员
	 * 否则返回姓名
	 * @return
	 */
	public String getName() {
		if (information == null)
			return "管理员";
		else if (information.UserType == Constant.UserType.STUDENT) {
			name = ((StudentPO) information).getName();
		} else {
			name = ((TeacherPO) information).getName();
		}
		return name;
	}
	BroadCastReceiverService broadCast;
	public BroadCastReceiverService getBroadCast() throws RemoteException, MalformedURLException, NotBoundException{
		if (databaseFactory == null) {
			databaseFactory = (DatabaseFactory) Naming
					.lookup(Constant.NetInfo.ADDRESS);
			/**
			 * 获取系统状态
			 */
			checkState();
			/**
			 * 获取院系信息
			 */
			loadInstitute();
		}
		if (broadCast==null){
			String mark = databaseFactory.getDataBase(Table.broadcast);
			DatabaseService broadCastData= (DatabaseService)Naming.lookup(mark);
			broadCast = new BroadCastReceiver(broadCastData);
		}
		return broadCast;
	}

	public DatabaseFactory getFactory() {
		return databaseFactory;
	}
	
	public void reConnect(){
		databaseFactory = null;
	}

	/**
	 * 登录
	 * @param id
	 * @param password
	 * @return
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	@Override
	public int login(int id, char[] password) throws RemoteException,
			MalformedURLException, NotBoundException {
		// RMI标记
		String mark = null;
		if (databaseFactory == null) {
			databaseFactory = (DatabaseFactory) Naming
					.lookup(Constant.NetInfo.ADDRESS);
			/**
			 * 获取系统状态
			 */
			checkState();
			/**
			 * 获取院系信息
			 */
			loadInstitute();
		}
		// 系统默认id为0的为管理员
		if (id == Constant.AdminInfo.ID) {
			String passwordString = String.valueOf(password);
			if (passwordString.equals(Constant.AdminInfo.PASSWORD)){
				return Constant.UserType.ADMIN;		
			} else {
				return Constant.UserType.WRONG_PASSWORD;
			}
		}
		// id>=1000000为学生
		else if (id >= 1000000) {
			mark = databaseFactory.getDataBase(Table.student);
		}
		// 否则为老师
		else {
			mark = databaseFactory.getDataBase(Table.teacher);
		}
		databaseService = (DatabaseService) Naming.lookup(mark);
		information = databaseService.find(id);
		if (information != null) {
			this.password = String.valueOf(password);
			if (information.UserType == Constant.UserType.STUDENT) {
				String truePassword = String.valueOf(((StudentPO) information)
						.getPassword());
				if (this.password.equals(truePassword)) {
					return information.UserType;
				}
			} else {
				String truePassword = String.valueOf(((TeacherPO) information)
						.getPassword());
				if (this.password.equals(truePassword))
					return information.UserType;
			}

		}
		return Constant.UserType.WRONG_PASSWORD;
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		if (information.UserType == Constant.UserType.STUDENT) {
			StudentPO student = (StudentPO) information;
			if (student.setPassword(old, newPassword)) {
				return databaseService.update(student);
			}
		} else if (information.UserType != Constant.UserType.STUDENT) {
			TeacherPO teacher = (TeacherPO) information;
			if (teacher.setPassword(old, newPassword)) {
				return databaseService.update(teacher);
			}
		}
		return false;
	}

	@Override
	public PO getInformation() {
		return information;
	}
	public void loadInstitute() throws MalformedURLException, RemoteException, NotBoundException{
		databaseService = (DatabaseService) Naming.lookup(databaseFactory
				.getDataBase(Table.institute));
		ArrayList<PO> pos = databaseService.findAll();
		ArrayList<InstitutePO> institutes = new ArrayList<>();
		for (PO po : pos){
			institutes.add((InstitutePO)po);
		}
		CurrentState.getInstitutes(institutes);
	}
	/**
	 * 获取系统状态
	 * 存储于CurrentState中
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public void checkState() throws RemoteException, MalformedURLException,
			NotBoundException {
		
		databaseService = (DatabaseService) Naming.lookup(databaseFactory
				.getDataBase(Table.system));
		SystemState state = (SystemState) databaseService.find(0);
		CurrentState.setState(state);
	}
	
}
