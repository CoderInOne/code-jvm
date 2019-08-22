package xunshan;

/**
 * VM Args:
 * -verbose:gc
 * -Xms20M
 * -Xmx10M
 * -Xmn20M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 */
public class YoungGen {
    public static void main(String[] args) {
        byte[] a, a1;
        // young gen can't contain 9M, into old gen directly
        a = new byte[9 * Constants._1M];

        System.gc();

        // now [ParOldGen: 9661K->9641K(10240K)], no more space to >1M chunk
        // and [PSYoungGen: 560K->0K(9216K)], so we can still put objects in young gen
        // but no more 7.8M
        a1 = new byte[(int) (7.8 * Constants._1M)];

        System.gc();
    }
}
