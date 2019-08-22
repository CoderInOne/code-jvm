package xunshan.execution_model;

/**
 * VM options:
 * -verbose:gc
 * -XX:+UseSerialGC
 * -XX:+PrintGCDetails
 *
 * 1) variable is out of scope
 * 2) Slot operations
 */
public class WhenSlotRecycle {
    public static void main(String[] args) {
        {
            byte[] bs = new byte[64 * 1024 * 1024];
        }
        int a = 1;
        System.gc();
    }
}
