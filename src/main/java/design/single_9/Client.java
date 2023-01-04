package design.single_9;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton_LanHan singleton_LanHan1=Singleton_LanHan.getSingleton();
		Singleton_LanHan singleton_LanHan2=Singleton_LanHan.getSingleton();
		System.out.println(singleton_LanHan1==singleton_LanHan2);
		
		Singleton_EHan singleton_EHan1=Singleton_EHan.getSingleton();
		Singleton_EHan singleton_EHan2=Singleton_EHan.getSingleton();
		System.out.println(singleton_EHan1==singleton_EHan2);
	}

}
