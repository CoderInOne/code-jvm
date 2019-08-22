package xunshan.classloading;

/**
 * When class will be initiated?
 * VM:
 *  -XX:+TraceClassLoading
 */
public class WhenClassInitTrigger {
    static class SuperClass {
        static {
            System.out.println("super class init");
        }

        static int value = 3;

        final static int VALUE = 5;
    }

    private static class SubClass extends SuperClass {
        static {
            System.out.println("sub class init");
        }

        // static int value = 4;
    }

    public static class ToReflClass {}

    public static void main(String[] args) throws ClassNotFoundException {
        // trigger reason: getstatic
        // System.out.println(SuperClass.value);

        // trigger reason: initiating super class before sub class
        // System.out.println(SubClass.value);

        // trigger reason: reflection calling
        // Class clz = ToReflClass.class;
        // Class cls = Class.forName("xunshan.classloading.WhenClassInitTrigger$ToReflClass");

        // trigger reason: main entry method

        // not trigger reason: array create instruction newarray not in {new, get/putstatic, invokestatic}
        // SuperClass[] arr = new SuperClass[3];

        // not trigger reason: constant value store in class file constant pool
        // SuperClass even not be loaded
        // System.out.println(SuperClass.VALUE);
    }
}
