package reflect;

public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

    @Override
    public String toString() {
        return "TargetObject{" +
                "value='" + value + '\'' +
                '}';
    }
}

