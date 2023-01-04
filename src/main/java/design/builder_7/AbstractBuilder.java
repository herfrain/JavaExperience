package design.builder_7;


public abstract class AbstractBuilder {
	
	Product product=new Product();
	
	public abstract void buildName();
	public abstract void buildSex();
	public abstract void buildHight();
	public abstract void buildWeight();
	public abstract Product createProduct();
}
