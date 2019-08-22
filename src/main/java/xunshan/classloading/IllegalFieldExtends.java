package xunshan.classloading;

/**
 * Seems ok in Java8
 */
public class IllegalFieldExtends {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 0;
    }

    static class ImplA implements Interface0 {
        public static int A = 0;
    }

    static class ImplB extends ImplA implements Interface0 {
        public static int A = 4;
    }

    public static void main(String[] args) {

    }
}
