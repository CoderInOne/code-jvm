package xunshan.classloading;

/**
 * Preparation Phase in JVM
 * @author XunShan
 */
public class PreparationFields {
    /**
     * bipush 123
     * putstatic xunshan/classloading/PreparationFields.value:I
     * iconst 4
     * putstatic xunshan/classloading/PreparationFields.value:I
     * return
     */
    private static int value = 123;
    static {
        value = 4;
    }

    private static final int CONST_VALUE = 456;


    public static void main(String[] args) {
        System.out.println(value);

        /* ConstantValue:
         * getstatic        get System.out
         * sipush           456
         * invokevirtual    invoke println method
         */
        System.out.println(CONST_VALUE);
    }
}
