package xunshan.byte_code;

public class BlockWait {
    synchronized void s1() {

    }

    synchronized void s2() throws InterruptedException {
        wait();
    }

    public static void main(String[] args) {

    }
}
