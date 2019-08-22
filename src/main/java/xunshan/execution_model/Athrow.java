package xunshan.execution_model;

public class Athrow {
    /**
     * static void athrow();
     *   descriptor: ()V
     *   flags: ACC_STATIC
     *   Code:
     *     stack=2, locals=0, args_size=0
     *        0: new           #2  // create RuntimeException object
     *        3: dup               // duplicate top operand stack: 1 for calling init method; 2 for throw
     *        4: invokespecial #3  // Method java/lang/RuntimeException."<init>":()V
     *        7: athrow            // throw top operand stack
     */
    static void athrow() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        athrow();
    }
}
