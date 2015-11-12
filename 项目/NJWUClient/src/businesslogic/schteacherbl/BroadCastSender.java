package businesslogic.schteacherbl;

import java.rmi.RemoteException;

import po.BroadCastPO;
import dataservice.DatabaseService;

public class BroadCastSender {
	DatabaseService broadCast;
	public BroadCastSender(DatabaseService broadCast){
		this.broadCast = broadCast;
	}
	public boolean  sendBroadCast(String message) throws RemoteException{
		return broadCast.insert(new BroadCastPO(message));
	}
}
