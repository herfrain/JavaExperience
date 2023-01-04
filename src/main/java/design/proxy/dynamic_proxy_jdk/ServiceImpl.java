package design.proxy.dynamic_proxy_jdk;

public class ServiceImpl implements Service{
    @Override
    public void send(String message) {
        System.out.println("发送信息：" + message);
    }

    @Override
    public void poll() {
        System.out.println("拉取信息");
    }
}
