package xunshan.classloading;

public class CinitInheritantOrder {
    private static int i = 0;
    public static class A extends CinitInheritantOrder {
        private static int j = 5;
        static {
            j = 22222;
            System.out.println("init A");
        }
    }

    static {
        System.out.println("CinitInheritantOrder static block");
        i = 5;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("xunshan.classloading.CinitInheritantOrder");

        // TODO ClassNotFoundException
        // Class.forName("xunshan.classloading.CinitInheritantOrder.A");
        // when class instance load, static block execute
        A.class.newInstance();
    }
}
