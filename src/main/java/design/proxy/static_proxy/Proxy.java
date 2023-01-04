package design.proxy.static_proxy;

public class Proxy implements Service{
    private final Service service; // 代理目标

    public Proxy(Service service){
        this.service = service;
    }

    @Override
    public void send(String message) {
        // 可以在代理目标方法前后新增额外的功能
        System.out.println("before");
        service.send(message);
        System.out.println("after");
    }
}
