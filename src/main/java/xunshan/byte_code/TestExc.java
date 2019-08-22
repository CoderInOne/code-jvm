package xunshan.byte_code;

public class TestExc {
    static void throwExc(int i) throws TestException {
        if (i == 0) {
            throw new TestException();
        }
    }

    static void catchOne() {
        try {
            doAction();
        } catch (Exception e) {
            handleExc();
        }
    }

    static void get() {
        try {
            doAction();
        }
        catch (Exception e) {
            handleExc();
        }
        finally {
            postAction();
        }
    }

    private static void postAction() {

    }

    private static void handleExc() {

    }

    private static void doAction() {

    }

    public static void main(String[] args) {
        get();
    }
}
