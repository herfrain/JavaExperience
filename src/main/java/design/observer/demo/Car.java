package design.observer.demo;

public class Car extends AbstractCar {

    public Car(Light light){
        this.light = light;
        this.light.attach(this);
    }

    @Override
    public void update() {
        if("Red".equals(light.getColor())){
            System.out.println("红灯停");
        }else if("Yellow".equals(light.getColor())){
            System.out.println("黄灯慢慢停");
        }else if("Green".equals(light.getColor())){
            System.out.println("绿灯行");
        }else{
            System.out.println("没有这个颜色的灯");
        }
    }
}
