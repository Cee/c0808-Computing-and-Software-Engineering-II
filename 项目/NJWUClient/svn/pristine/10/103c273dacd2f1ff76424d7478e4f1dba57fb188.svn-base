package presentation.mainui;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.studentbl.Student;
import businesslogic.userbl.UserController;
import businesslogicservice.studentblservice.StudentBlService;
import businesslogicservice.userblservice.UserControllerService;

public class TestSelection {
	static int id ;
	static UserControllerService[] controllerServices = new UserController[100];
	static Thread[] threads = new Thread[100];
	public static void main(String[] args){
		for (id = 121250001; id<121250100; id++){
			threads[id-121250001]= new Thread(new MyRunaable());
			controllerServices[id-121250001] = new UserController();		
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (id = 121250001; id<121250100; id++){
			threads[id-121250001].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	static class MyRunaable implements Runnable{
		@Override
		public void run() {
			test(id);
		}
		
	}
	public static void test(int id){
	
		UserControllerService userController =controllerServices[id-121250001];
		char[] password = (id+"").toCharArray();
		try {
			userController.login(id, password);
			StudentBlService student = new Student(userController);
			student.setLessonType(1);
			if (student.by_select(16)){
				System.out.println(id+"选课成功！");
				if (student.by_cancel(16)){
					System.out.println(id+"退选成功");
				}
			}else {
				System.out.println(id+"选课失败，课程已满");
			}
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
