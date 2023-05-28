package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void testBeginEnd(){
        //given
        HelloTraceV2 trace = new HelloTraceV2();

        //when //then
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");

        trace.end(status1);
        trace.end(status2);
    }

    @Test
    void testBeginException(){
        //given
        HelloTraceV2 trace = new HelloTraceV2();

        //when //then
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");

        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalArgumentException());
    }

}