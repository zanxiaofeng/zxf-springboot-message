package zxf.springboot.support.trace;

import java.util.UUID;

public class TraceIdGenerator {
    public static String generateTraceId(String prefix) {
        return String.format("%s_%s", prefix, UUID.randomUUID().toString());
    }
}
