package design.proxy.static_proxy;

import org.junit.jupiter.api.Test;

class ProxyTest {

    @Test
    void send() {
        Service proxy = (Service) new Proxy(new ServiceImpl());
        proxy.send("hello");
    }
}