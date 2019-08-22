package xunshan;

/**
 * VM Args:
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:SurvivorRatio=8
 * -XX:-HandlePromotionFailure
 *
 * Observe Step-by-Step
 */
public class HandlePromotion {
    public static void main(String[] args) {
        byte[] a1, a2, a3, a4, a5, a6, a7;
        a1 = new byte[4 * Constants._1M];
        a2 = new byte[4 * Constants._1M];
        a3 = new byte[4 * Constants._1M];
        a1 = null;

        a4 = new byte[2 * Constants._1M];
        a5 = new byte[2 * Constants._1M];
        a6 = new byte[2 * Constants._1M];

        a4 = null;
        a5 = null;
        a6 = null;
        a7 = new byte[2 * Constants._1M];
    }
}
