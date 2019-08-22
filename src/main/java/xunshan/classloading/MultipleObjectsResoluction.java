package xunshan.classloading;

public class MultipleObjectsResoluction {
    private class MyObj {}

    MyObj objA = new MyObj();

    MyObj objB = new MyObj();

    public MyObj getObjA() {
        return objA;
    }

    public static void main(String[] args) {

    }
}
