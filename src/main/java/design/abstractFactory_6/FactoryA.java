package design.abstractFactory_6;

public class FactoryA extends AbstractFactory{
	
	public FactoryA() {
		this.name="FactoryA";
		System.out.println(this.name);
	}

	@Override
	AbstractProduct1 createProduct1() {
		// TODO Auto-generated method stub
		return new ProductA1();
	}

	@Override
	AbstractProduct2 createProduct2() {
		// TODO Auto-generated method stub
		return new ProductA2();
	}
	
}
