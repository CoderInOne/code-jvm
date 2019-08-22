package xunshan.profile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTraceTest {
    public int add(int a, int b) {
        System.out.println("a=" + a + ",b=" + b);
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BTraceTest bt = new BTraceTest();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            r.readLine();
            int a = (int) (Math.random() * 10);
            int b = (int) (Math.random() * 10);
            int c = bt.add(a, b);
        }
    }
}
