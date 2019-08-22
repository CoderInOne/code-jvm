package xunshan;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * VM Args:
 * -Xss20M
 * Result:
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 * 	at java.lang.Thread.start0(Native Method)
 * 	at java.lang.Thread.start(Thread.java:717)
 * 	at xunshan.JavaVMStackOOM.main(JavaVMStackOOM.java:18)
 *
 * Java HotSpot(TM) 64-Bit Server VM warning: Exception java.lang.OutOfMemoryError
 * occurred dispatching signal SIGINT to handler-
 * the VM may need to be forcibly terminated
 */
public class JavaVMStackOOM {
    private static final AtomicInteger counter = new AtomicInteger();

    private static void doNoneStop() {
        while (true) {}
    }

    public static void main(String[] args) {
        try {
            while (true) {
                new Thread(new Runnable() {
                    public void run() {
                        counter.getAndIncrement();
                        doNoneStop();
                    }
                }).start();
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("thread size:" + counter.get());
        }
    }
}
