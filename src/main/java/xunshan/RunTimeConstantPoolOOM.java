package xunshan;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:
 * -XX:PermSize=10k
 * -XX:MaxPermSize=10k
 *
 * Deprecated in Java8
 * https://www.infoq.com/articles/Java-PERMGEN-Removed
 */
public class RunTimeConstantPoolOOM {
    public static void main(String[] args) {
        final List<String> list = new ArrayList<String>();
        int value = 0;
        while (true) {
            list.add(("1111111111333333333333344444444444" +
                    String.valueOf(value++)).intern());
        }
    }
}
