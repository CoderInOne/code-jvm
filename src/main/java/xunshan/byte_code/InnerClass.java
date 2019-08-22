package xunshan.byte_code;

public class InnerClass {
    static class IA {}

    class IB {}

    static void callRun(Runnable r) {

    }

    public static void main(String[] args) {
        callRun(new Runnable() {
            public void run() {

            }
        });
    }
}
