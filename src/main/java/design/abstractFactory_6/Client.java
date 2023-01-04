package design.abstractFactory_6;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory factoryA=new FactoryA();
		AbstractFactory factoryB=new FactoryB();
		
		factoryA.createProduct1();
		factoryA.createProduct2();
		
		factoryB.createProduct1();
		factoryB.createProduct2();
	}

}
