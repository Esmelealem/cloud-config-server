package firstConsumer.service;

public interface HelloConsumer {
    void bindToHelloQueue(String payload);
}
