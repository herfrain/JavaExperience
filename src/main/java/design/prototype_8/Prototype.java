package design.prototype_8;

public abstract class Prototype implements Cloneable {

    private String name;
    private int a[];
    private int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    //浅克隆
    @Override
    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return object;
    }

    //深克隆
    public Object D_clone() {
        Prototype object = null;
        try {
            object = (Prototype) super.clone();
            object.name = new String(name);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int a[]) {
        this.a = a;
    }

    public void showA() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
}
