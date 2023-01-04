package design.builder_7;

public class Builder1 extends AbstractBuilder{


	@Override
	public void buildName() {
		// TODO Auto-generated method stub
		product.setName("builder1");
	}

	@Override
	public void buildSex() {
		// TODO Auto-generated method stub
		product.setSex("sex1");
	}

	@Override
	public void buildHight() {
		// TODO Auto-generated method stub
		product.setHight(1);
	}

	@Override
	public void buildWeight() {
		// TODO Auto-generated method stub
		product.setWeight(1);
	}

	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return product;
	}

}
