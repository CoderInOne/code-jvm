package xunshan;

/**
 * VM Args:
 * -verbose:gc
 * -Xms20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 *
 * [Full GC (System.gc() [ParOldGen: 204808K->445K(216064K)] 205328K->205245K(225280K) ...
 * ~200Mb GC
 *
 * Reference Counting can't solve cyclic referencing:
 * a.instance = b; b.instance = a;
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1M = 1024 * 1024;
    private byte[] bigSize = new byte[100 * _1M];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();
        a.instance = b;
        b.instance = a;

        a = null; // help GC
        b = null;

        System.gc();
    }
}
