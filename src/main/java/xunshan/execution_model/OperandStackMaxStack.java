package xunshan.execution_model;

public class OperandStackMaxStack {
    /**
     *       stack=2, locals=5, args_size=2
     *          0: iconst_5
     *          1: istore_2
     *          2: bipush        100
     *          4: istore_3
     *          5: iload_0
     *          6: iload_1
     *          7: iadd          value1, value2 → result
     *          8: iload_2
     *          9: iadd
     *         10: iload_3
     *         11: iadd
     *         12: istore        4
     *         14: iload         4
     *         16: ireturn

     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0      17     0     i   I
     *             0      17     1     j   I
     *             2      15     2     k   I
     *             5      12     3     t   I
     *            14       3     4     r   I
     */
    static int add(int i, int j) {
        int k = 5;
        int t = 100;
        int r = i + j + k + t;
        return r;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }
}
