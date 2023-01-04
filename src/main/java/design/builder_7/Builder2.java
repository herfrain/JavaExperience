package design.builder_7;

public class Builder2 extends AbstractBuilder{


	@Override
	public void buildName() {
		// TODO Auto-generated method stub
		product.setName("builder2");
	}

	@Override
	public void buildSex() {
		// TODO Auto-generated method stub
		product.setSex("sex2");
	}

	@Override
	public void buildHight() {
		// TODO Auto-generated method stub
		product.setHight(2);
	}

	@Override
	public void buildWeight() {
		// TODO Auto-generated method stub
		product.setWeight(2);
	}

	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return product;
	}

}
