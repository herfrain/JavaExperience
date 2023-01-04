package design.template;
/**
 * @author Herfrain
 * @date 2022/8/16 18:02
 * @description 模板方法抽象类
 * 模板方法：算法由一些步骤组成，不改变算法流程，自定义步骤的实现
 */
public abstract class AbstractTemplate {
    // 模板方法
    public final void templateMethod(){
        operation1();
        operation2();
        if(doOperation3()){
            operation3();
        }
    }

    protected void operation1(){ // 具体方法，对所有子类都相同的方法可以在父类中实现
        System.out.println("公共方法");
    }

    protected abstract void operation2(); // 抽象方法，由子类实现

    protected boolean doOperation3(){ // 钩子方法
        return true;
    }

    protected void operation3(){
        System.out.println("operation3");
    }
}
