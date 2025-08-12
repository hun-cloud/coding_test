package main.gc;
/**
 * VM Args: -Xlog:gc*
 *
 * */
public class ReferenceCountingGC {
    private Object instance = null;
    private static final int _1MB = 1024 * 1024;
    // 메모리를 많이 차지하여 GC 로그에서 회수 여부를 명확히 알아볼 수 있게 한다.
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        // 내부 필드로 서로를 참조
        objA.instance = objB;
        objB.instance = objA;
        // 참조 해제
        objA = null;
        objB = null;

        // 이 라인에서 GC를 수행한다면 objA와 objB가 회수될까 ?
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
