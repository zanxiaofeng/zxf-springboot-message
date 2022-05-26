package zxf.springboot.service.c.rest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserCreateEvent {
    private String type = "USER_CREATED";
    private final User message;
}
