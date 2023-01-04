package design.abstractFactory_6;

public class FactoryB extends AbstractFactory{
	String name="FactoryB";
	
	public FactoryB() {
		System.out.println(this.name);
	}

	@Override
	AbstractProduct1 createProduct1() {
		// TODO Auto-generated method stub
		return new ProductB1();
	}

	@Override
	AbstractProduct2 createProduct2() {
		// TODO Auto-generated method stub
		return new ProductB2();
	}
	
}
