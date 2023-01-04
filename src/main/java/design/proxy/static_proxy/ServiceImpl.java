package design.proxy.static_proxy;

public class ServiceImpl implements Service{
    @Override
    public void send(String message) {
        System.out.println("发送信息：" + message);
    }
}
