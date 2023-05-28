package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    void begin_end(){
        //given
        HelloTraceV1 trace = new HelloTraceV1();

        //when //then
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception(){
        //given
        HelloTraceV1 trace = new HelloTraceV1();

        //when //then
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalArgumentException());
    }

}