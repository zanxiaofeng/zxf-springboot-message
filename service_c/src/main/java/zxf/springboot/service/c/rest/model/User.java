package zxf.springboot.service.c.rest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String id;
    private final String name;
}
