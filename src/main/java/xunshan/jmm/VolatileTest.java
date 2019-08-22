package xunshan.jmm;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    private static int counter = 0;
    private static final int THREAD_COUNT = 20;
    private static final int ITERATE_COUNT = 10000;

    private static void inc() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < ITERATE_COUNT; j++) {
                        inc();
                    }
                    latch.countDown();
                }
            });
            t.start();
        }

        latch.await();

        System.out.println(counter);
    }
}
