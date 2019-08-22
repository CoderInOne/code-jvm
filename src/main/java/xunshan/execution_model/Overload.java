package xunshan.execution_model;

import java.io.Serializable;

public class Overload {
//    void print(char c) {
//        System.out.println("char:" + c);
//    }

//    void print(int c) {
//        System.out.println("int:" + c);
//    }

//    void print(long c) {
//        System.out.println("long:" + c);
//    }

//    void print(double c) {
//        System.out.println("double:" + c);
//    }

//    void print(Character c) {
//        System.out.println("Charactor:" + c);
//    }

    // 如果这两个方法同时存在报引用不明确
//    void print(Serializable s) {
//        System.out.println("Serializable:" + s);
//    }
//    void print(Comparable c) {
//        System.out.println("Comparable:" + c);
//    }

//    void print(Object o) {
//        System.out.println("Object:" + o);
//    }

    void print(Object... args) {
        System.out.println("Object...:" + args);
    }

    public static void main(String[] args) {
        Overload o = new Overload();
        o.print('c');
    }
}
