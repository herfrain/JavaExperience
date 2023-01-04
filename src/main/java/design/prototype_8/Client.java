package design.prototype_8;

public class Client {


    public static void main(String args[]) {

        Prototype prototype = new ConcretePrototypeA();
        prototype.setName("A");
        prototype.setB(1);

        //浅克隆
        Prototype copy = (Prototype) prototype.clone();
        System.out.println(prototype == copy);//复制的新对象内存地址与原来不同，但内容相同
        System.out.println(copy.getName() == prototype.getName());//浅克隆，引用变量的地址相同
        System.out.println(copy.getB() == prototype.getB());//基本数据进行值传递，相同

        //深克隆
        Prototype d_copy = (Prototype) prototype.D_clone();
        System.out.println(prototype == d_copy);
        System.out.println(d_copy.getName() == prototype.getName());//深克隆，引用变量的地址不同
        System.out.println(copy.getB() == prototype.getB());
    }
}
