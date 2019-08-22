package xunshan;

/**
 * VM Args:
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 * -XX:+UseSerialGC
 *
 * TODO 没有观察到书中所说的情况
 */
public class PretenureSizeThreshold {
    public static void main(String[] args) {
        byte a[];
        a = new byte[4 * Constants._1M];
    }
}
