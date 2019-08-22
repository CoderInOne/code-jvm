package xunshan;

/**
 * VM Args:
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:SurvivorRatio=6
 * -XX:MaxTenuringThreshold=15
 * -XX:+PrintTenuringDistribution
 * -XX:UseSerialGC
 *
 * 1. make sure a1 only consume <50%
 * 2. comment a2 and uncomment a2 will give result
 */
public class TenuringThredshold {
    public static void main(String[] args) {
        byte[] a1, a2, a3, a4;
        a1 = new byte[Constants._1M / 8];
//        a2 = new byte[Constants._1M / 4];
        a3 = new byte[4 * Constants._1M];
        a4 = new byte[4 * Constants._1M];

        // from space 72%
//        def new generation   total 8960K, used 5177K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//        eden space 7680K,  55% used [0x00000007bec00000, 0x00000007bf026868, 0x00000007bf380000)
//        from space 1280K,  72% used [0x00000007bf4c0000, 0x00000007bf5a7d38, 0x00000007bf600000)
//        to   space 1280K,   0% used [0x00000007bf380000, 0x00000007bf380000, 0x00000007bf4c0000)
//        tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//        the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00010, 0x00000007bfa00200, 0x00000007c0000000)

        a4 = null;
        a4 = new byte[4 * Constants._1M];
    }
}
