package zxf.springboot.service.a.message;

import lombok.Data;

@Data
public class UserCreatedMessage {
    private String id;
    private String name;

    public String toString() {
        return String.format("UserCreatedMessage(%s, %s)", id, name);
    }
}
