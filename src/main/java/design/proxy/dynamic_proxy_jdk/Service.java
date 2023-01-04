package design.proxy.dynamic_proxy_jdk;

public interface Service {
    void send(String message);
    void poll();
}
