package xunshan.byte_code;

public class ObjectReference {
    private Object fObj = new Object();

    private void foo() {
        Object lObj = new Object();
    }

    private void foo(Object aObj) {
        System.out.println(aObj);
    }

    private void bar() {
        Object lObj = fObj;
        System.out.println(lObj);
    }

    public static void main(String[] args) {
        new ObjectReference().foo();
    }
}
