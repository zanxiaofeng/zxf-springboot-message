package zxf.springboot.support.trace;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;


@Slf4j
@Aspect
@Component
public class TraceAspect {

    @Around("execution(public * zxf.springboot.service.*.message.MessageListener.*(..))")
    public Object aroundNewMessage(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            MDC.put(TraceConstant.TRACE_ID, TraceIdGenerator.generateTraceId(TraceConstant.NEW_MESSAGE));
            log.info("===> New message {}, Parameters : {}", getSignature(joinPoint), Arrays.toString(joinPoint.getArgs()));
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            log.info("<=== End message {} in {}", getSignature(joinPoint), getTime(end - start));
            MDC.clear();
        }
    }

    private String getSignature(JoinPoint joinPoint) {
        return joinPoint.getSignature().toShortString();
    }

    private String getTime(long mills) {
        return mills <= TraceConstant.MILLIS_PER_SECOND ? String.format("%s ms", mills)
                : String.format("%s s", mills / TraceConstant.MILLIS_PER_SECOND);
    }
}