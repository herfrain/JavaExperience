package design.builder_7;

public class Director {
	AbstractBuilder builder;
	
	public Director(AbstractBuilder builder){
		this.builder=builder;
	}
	
	public Product getProduct(){
		builder.buildName();
		builder.buildSex();
		builder.buildHight();
		builder.buildWeight();
		return builder.createProduct();
	}
}
