package zxf.springboot.service.b.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zxf.springboot.support.message.MessageHandler;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCreatedMessageHandler implements MessageHandler {
    private final ObjectMapper objectMapper;

    @Override
    public String supportType() {
        return "USER_CREATED";
    }

    @Override
    public void handle(Map<String, Object> message, Map<String, String> headers) {
        UserCreatedMessage userCreatedMessage = objectMapper.convertValue(message, UserCreatedMessage.class);
        log.info("Receive USER_CREATED message, message = {}", userCreatedMessage);
    }
}
