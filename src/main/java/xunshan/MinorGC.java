package xunshan;

/**
 * VM Args:
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:SurvivorRatio=8
 * -XX:+PrintGCDetails
 *
 * Minor GC: for Young age, very fast
 * Full GC: slower
 *
 * a4 = new byte[2 * _1MB] -> cause GC
 * [GC (Allocation Failure) [PSYoungGen: 8068K->560K(9216K)] 8068K->6712K(19456K), 0.0032230 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 560K->0K(9216K)] [ParOldGen: 6152K->6589K(10240K)] 6712K->6589K(19456K), [Metaspace: 3307K->3307K(1056768K)], 0.0044237 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 *
 * Heap
 *  PSYoungGen      total 9216K, used 2130K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *   8M -> eden space 8192K, 26% used [0x00000007bf600000,0x00000007bf814930,0x00000007bfe00000)
 *   1M -> from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 *   1M -> to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *  ParOldGen       total 10240K, used 6589K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   10M -> object space 10240K, 64% used [0x00000007bec00000,0x00000007bf26f580,0x00000007bf600000)
 *  Metaspace       used 3314K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 369K, capacity 388K, committed 512K, reserved 1048576K
 */
public class MinorGC {
    public static final int _1MB = 1024 * 1024;

    private static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[2 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
