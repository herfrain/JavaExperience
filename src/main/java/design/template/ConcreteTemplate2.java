package design.template;

public class ConcreteTemplate2 extends AbstractTemplate{

    @Override
    protected void operation2() {
        System.out.println("ConcreteTemplate2 operation2");
    }

    @Override
    protected boolean doOperation3(){
        return false;
    }
}
