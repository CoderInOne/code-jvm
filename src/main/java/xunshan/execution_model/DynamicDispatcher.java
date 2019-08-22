package xunshan.execution_model;

public class DynamicDispatcher {
    static abstract class Human {
        protected abstract void sayHi();
    }

    static class Man extends Human {
        @Override
        protected void sayHi() {
            System.out.println("Man sayHi");
        }
    }

    static class Women extends Human {
        @Override
        protected void sayHi() {
            System.out.println("Women sayHi");
        }
    }

    public static void main(String[] args) {
        Human m = new Man();
        m.sayHi();
        Human w = new Women();
        w.sayHi();
        m = new Women();
        m.sayHi();
    }
}
