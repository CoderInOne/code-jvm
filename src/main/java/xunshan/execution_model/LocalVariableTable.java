package xunshan.execution_model;

public class LocalVariableTable {
    /**
     *int foo(int);
     *  descriptor: (I)I
     *  flags:
     *  Code:
     *    stack=1, locals=8, args_size=2
     *       0: iconst_0                load const 0
     *       1: istore_2                store 0 into Slot 2
     *       2: iconst_1                load const 1
     *       3: istore_3                store 1 into Slot 3
     *       4: iconst_5                load const 5
     *       5: istore        4         store 5 into Slot 4
     *       7: iconst_5                ...
     *       8: istore        5
     *      10: bipush        100       push 100 into operand stack
     *      12: istore        6         pop 100 from operand stack and store to Slot 6
     *      14: bipush        44        push 44 into operand stack
     *      16: istore        7         pop 44 from operand stack and store to Slot 7
     *      18: iload         7         load Slot 7 value into operand stack
     *      20: ireturn                 pop 44 from operand stack and return [TODO synchronized details]
     *    LocalVariableTable:
     *      Start  Length  Slot  Name   Signature
     *          0      21     0  this   Lxunshan/execution_model/LocalVariableTable;
     *          0      21     1     j   I
     *          2      19     2     i   I
     *          4      17     3     k   I
     *          7      14     4     g   I
     *         10      11     5     y   I
     *         14       7     6     o   I
     *         18       3     7     t   I
     *
     * Structure: Slot(32 or 64bits), and access by index
     *
     * Layout:
     * 1) instance method: LocalVariableTable[0] = this
     * 2) args
     * 3) local variables
     *
     * Lifecycle:
     * 1) TODO when create
     * 2) out of scope: Slot is reused
     */
    int foo(int j) {
        int i = 0;
        int k = 1;
        int g = 5;
        int y = 5;
        int o = 100;
        int t = 44;
        return t;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
