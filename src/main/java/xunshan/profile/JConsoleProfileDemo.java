package xunshan.profile;

import java.util.ArrayList;
import java.util.List;

public class JConsoleProfileDemo {
    private static class MyObject {
        private final byte[] obj = new byte[64 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap();
    }

    private static void fillHeap() throws InterruptedException {
        Thread.sleep(5000);
        List<MyObject> list = new ArrayList<MyObject>();
        for (int i = 0; i < 1000; i++) {
            list.add(new MyObject());
            Thread.sleep(100);
        }
        System.gc();
        Thread.sleep(5000);
    }
}
