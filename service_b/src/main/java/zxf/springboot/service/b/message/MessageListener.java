package zxf.springboot.service.b.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import zxf.springboot.support.message.MessageDispatcher;
import zxf.springboot.support.message.MessageWrapper;

import java.util.Map;

@Component
public class MessageListener {
    @Autowired
    private MessageDispatcher messageDispatcher;

    @RabbitListener(queues = "service-b-queue", messageConverter = "jsonMessageConverter")
    public void onMessage(MessageWrapper wrapper, @Headers Map<String, String> headers) {
        messageDispatcher.onMessage("service-b-queue", wrapper, headers);
    }
}
