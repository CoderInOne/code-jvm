package xunshan.execution_model;

public class FourMethodCallInstructions implements Runnable {
    /**
     * invokestatic
     */
    static void staticMehtod() {}

    /**
     * invokespecial
     */
    FourMethodCallInstructions() {}
    private void privateMethod() {}

    /**
     * invokevirtual
     */
    void virtualMethod() {}

    /**
     * invokeinterface
     */
    @Override
    public void run() {}

    public static void main(String[] args) {
        staticMehtod();

        Runnable app = new FourMethodCallInstructions();
        app.run();

        FourMethodCallInstructions app1 = (FourMethodCallInstructions) app;
        app1.privateMethod();

        app1.virtualMethod();
    }

}
