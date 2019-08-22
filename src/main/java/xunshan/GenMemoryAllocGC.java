package xunshan;

/**
 * VM Args:
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:SurvivorRatio=6
 * -XX:PrintGCDetails
 */
public class GenMemoryAllocGC {
    public static void main(String[] args) {
        byte[][] bs = new byte[32][];
        int maxChunk = 5;
        for (int i = 0; i < maxChunk; i++) {
            bs[i] = new byte[Constants._1M];
        }
    }
}
