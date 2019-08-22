package xunshan;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:
 * -verbose:gc
 * -Xms20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
        final Object[] array = new Object[1024];
    }
    public static void main(String[] args) {
        final List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
