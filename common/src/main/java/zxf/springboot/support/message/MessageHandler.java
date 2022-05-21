package zxf.springboot.support.message;

import java.util.Map;

public interface MessageHandler {
    String supportType();

    void handle(Map<String, Object> message, Map<String, String> headers);

    default boolean canHandle(String type) {
        return supportType().equals(type);
    }
}
