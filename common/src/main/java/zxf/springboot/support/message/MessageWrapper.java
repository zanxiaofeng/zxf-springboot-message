package zxf.springboot.support.message;

import lombok.Data;

import java.util.Map;

@Data
public class MessageWrapper {
    private String type;
    private Map<String, Object> message;
}
