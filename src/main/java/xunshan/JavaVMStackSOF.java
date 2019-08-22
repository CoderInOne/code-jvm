package xunshan;

/**
 * VM Args:
 * -Xss64k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (StackOverflowError t) {
            System.err.println("StackLength:" + sof.stackLength);
        }
    }
}
