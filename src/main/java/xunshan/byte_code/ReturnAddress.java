package xunshan.byte_code;

public class ReturnAddress {
    private static boolean even(int i) {
        if (i % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(even(2));
    }
}
