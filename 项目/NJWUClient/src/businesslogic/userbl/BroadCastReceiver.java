package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BroadCastPO;
import po.PO;
import businesslogicservice.userblservice.BroadCastReceiverService;
import dataservice.DatabaseService;

public class BroadCastReceiver implements BroadCastReceiverService{
	DatabaseService broadcastData;
	public BroadCastReceiver(DatabaseService broadcastData){
		this.broadcastData = broadcastData;
	}
	@Override
	public String[] receiveBroadCast() throws RemoteException {
		ArrayList<PO> list = broadcastData.findAll();
		String[] messages = new String[list.size()];
		for (int i = 0 ; i < list.size(); i++){
			BroadCastPO po = (BroadCastPO)list.get(i);
			messages[i] = po.getMessage()+"    发布时间:"+po.getDate();
		}
		return messages;
	}

}
