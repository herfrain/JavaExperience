package design.proxy.dynamic_proxy_jdk;

import org.junit.jupiter.api.Test;

class ProxyFactoryTest {

    @Test
    void getProxy() {
        Service service = (Service) ProxyFactory.getProxy(new ServiceImpl());
        service.send("hello");
        service.poll();
    }
}