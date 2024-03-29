package xunshan.gc;

/**
 * in G1 OOM very fast
 */
class GCTest2 {
    static MyList objList = null;
    /**
     in milliseconds: 1 second
     */
    static int wait = 1000;
    /**
     * in KB, default = 1.25 M
     */
    static int objSize = 512;
    /**
     * # of initial objects
     */
    static int initSteps = 480;
    /**
     * # of added objects
     */

    static int testSteps = 64;

    public static void main(String[] arg) {
        handleArgs(arg);
        System.out.println("Test parameters:");
        System.out.println("   Object size: " + objSize + "KB");
        System.out.println("   Initial objects and data size: "
                + initSteps + ", " + (initSteps * objSize) + "KB");
        System.out.println("   Added objects and data size: "
                + testSteps + ", " + (testSteps * objSize) + "KB");
        objList = new MyList();
        myTest();
    }

    private static void handleArgs(String[] arg) {
        if (arg.length > 0) {
            objSize = Integer.parseInt(arg[0]);
        }
        if (arg.length > 1) {
            initSteps = Integer.parseInt(arg[1]);
        }
        if (arg.length > 2) {
            testSteps = Integer.parseInt(arg[2]);
        }
    }

    public static void myTest() {
        for (int m = 0; m < initSteps; m++) {
            objList.add(new MyObject());
        }

        Runtime rt = Runtime.getRuntime();
        System.out.println(
                "Time  Total  Free  Used  Free  Total  Act.  Dead  Over");
        System.out.println(
                "sec.   Mem.  Mem.  Mem.    %.   Obj.  Obj.  Obj.  Head");
        long dt0 = System.currentTimeMillis() / 1000;
        while (true) {
            for (int m = 0; m < testSteps; m++) {
                objList.add(new MyObject());
            }
            for (int m = 0; m < testSteps; m++) {
                objList.removeTail();
            }

            mySleep(wait);
            long tm = rt.totalMemory() / 1024;
            long fm = rt.freeMemory() / 1024;
            long ratio = (100 * fm) / tm;
            long dt = System.currentTimeMillis() / 1000 - dt0;
            long to = MyObject.getCount() * objSize;
            long ao = MyList.getCount() * objSize;
            System.out.println(dt
                    + "  " + tm + "  " + fm + "  " + (tm - fm) + "  " + ratio + "%"
                    + "  " + to + "  " + ao + "  " + (to - ao)
                    + "  " + (tm - fm - to));
        }
    }

    static void mySleep(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.out.println("Interreupted...");
        }
    }

    static class MyObject {
        private static long count = 0;
        private long[] obj = null;
        public MyObject next = null;
        public MyObject prev = null;

        public MyObject() {
            count++;
            /**
             * 128*8=1024 bytes
             */
            obj = new long[objSize * 128];
        }

        @Override
        protected final void finalize() {
            count--;
        }

        static long getCount() {
            return count;
        }
    }

    static class MyList {
        static long count = 0;
        MyObject head = null;
        MyObject tail = null;

        static long getCount() {
            return count;
        }

        void add(MyObject o) {
            // add the new object to the head;
            if (head == null) {
                head = o;
                tail = o;
            } else {
                o.prev = head;
                head.next = o;
                head = o;
            }
            count++;
        }

        void removeTail() {
            if (tail != null) {
                if (tail.next == null) {
                    tail = null;
                    head = null;
                } else {
                    tail = tail.next;
                    tail.prev = null;
                }
                count--;
            }
        }

        void removeHead() {
            if (head != null) {
                if (head.prev == null) {
                    tail = null;
                    head = null;
                } else {
                    head = head.prev;
                    head.next = null;
                }
                count--;
            }
        }
    }
}
