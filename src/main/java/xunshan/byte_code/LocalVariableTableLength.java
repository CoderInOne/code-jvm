package xunshan.byte_code;

public class LocalVariableTableLength {
    private void foo() {
        int i = 0;
        i += 1;
        i += 2;

        {
            int j = 4;
            j += 2;
        }

        i += 3;
    }

    public static void main(String[] args) {

    }
}
