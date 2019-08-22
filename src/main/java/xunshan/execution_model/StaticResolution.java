package xunshan.execution_model;

public class StaticResolution {
    static class Human {

    }
    static class Man extends Human {

    }
    static class Women extends Human {

    }

    void sayHi(Human h) {
        System.out.println("SayHi to human");
    }

    void sayHi(Man m) {
        System.out.println("SayHi to man");
    }

    void sayHi(Women w) {
        System.out.println("SayHi to women");
    }

    public static void main(String[] args) {
        StaticResolution sr = new StaticResolution();
        Man m = new Man();
        Human w = new Women();
        sr.sayHi(m);
        sr.sayHi(w);
    }
}
