package zxf.springboot.service.c.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    //Declaration by java(or terraform)
    @Bean
    public Exchange userTopic() {
        return new TopicExchange("topic-user", false, false);
    }

    @Bean
    public Binding serviceABinding() {
        return BindingBuilder.bind(new Queue("service-a-queue"))
                .to(userTopic()).with("user.*")
                .noargs();
    }

    @Bean
    public Binding serviceBBinding() {
        return BindingBuilder.bind(new Queue("service-b-queue"))
                .to(userTopic()).with("user.*")
                .noargs();
    }
}
