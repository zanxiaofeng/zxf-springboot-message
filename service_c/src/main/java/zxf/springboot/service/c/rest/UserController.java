package zxf.springboot.service.c.rest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zxf.springboot.service.c.rest.model.User;
import zxf.springboot.service.c.rest.model.UserCreateEvent;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/create")
    public void createUser(@RequestParam String id, @RequestParam String name) {
        amqpTemplate.convertAndSend("topic-user", "user.create",
                new UserCreateEvent(new User(id, name)));
    }
}
