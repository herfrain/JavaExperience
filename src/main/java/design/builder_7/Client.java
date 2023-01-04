package design.builder_7;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractBuilder builder1=new Builder1();
		AbstractBuilder builder2=new Builder2();
		
		Director director=new Director(builder1);
		Product product1=director.getProduct();
		
		director=new Director(builder2);
		Product product2=director.getProduct();
		
		System.out.println(product1.toString());
		System.out.println(product2.toString());
	}

}
