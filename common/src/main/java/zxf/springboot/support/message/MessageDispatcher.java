package zxf.springboot.support.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageDispatcher {
    private final List<MessageHandler> messageHandlers;

    public void onMessage(String queueName, MessageWrapper wrapper, @Headers Map<String, String> headers) {
        log.info("Receive message from {}, message = {}, header = {}", queueName, wrapper, headers);

        List<MessageHandler> typeHandlers = getHandlers(wrapper.getType());
        if (CollectionUtils.isEmpty(typeHandlers)) {
            log.error("No corresponding handlers for message = {}", wrapper);
            return;
        }

        typeHandlers.forEach(handler -> handler.handle(wrapper.getMessage(), headers));
    }

    public List<MessageHandler> getHandlers(String type) {
        if (CollectionUtils.isEmpty(messageHandlers)) {
            return Collections.emptyList();
        }
        return messageHandlers.stream()
                .filter(handler -> handler.canHandle(type))
                .collect(Collectors.toList());
    }
}
