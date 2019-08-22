package xunshan.classloading;

public class CinitOrder {
    static int a = 0;

    static {
        // illegal forward ref
        // a = b;
        a = 3;

        // ok
        b = 5;
    }

    static int b = 4;

    public static void main(String[] args) {

    }
}
