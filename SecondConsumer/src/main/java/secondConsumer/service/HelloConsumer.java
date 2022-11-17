package secondConsumer.service;

public interface HelloConsumer {
    void bindToHelloQueue(String payload);
}
