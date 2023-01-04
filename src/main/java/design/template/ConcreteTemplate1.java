package design.template;

public class ConcreteTemplate1 extends AbstractTemplate{

    @Override
    protected void operation2() {
        System.out.println("ConcreteTemplate1 operation2");
    }

    @Override
    protected boolean doOperation3(){
        return true;
    }
}
