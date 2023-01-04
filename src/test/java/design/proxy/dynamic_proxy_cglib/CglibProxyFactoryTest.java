package design.proxy.dynamic_proxy_cglib;

import org.junit.jupiter.api.Test;

class CglibProxyFactoryTest {

    @Test
    void getProxy() {
        Service service = (Service) CglibProxyFactory.getProxy(Service.class);
        service.send("hello");
    }
}