package xunshan.byte_code;

public class OpcodeIndexByte {
    public static void main(String[] args) {
        // b4 00 03
        // getfield #3
        System.out.println((0x03 << 8) | 0x0b);
        System.out.println(Integer.toBinaryString(0x03 << 8));
        System.out.println(Integer.toBinaryString(0x0b));
        System.out.println(Integer.toBinaryString((0x03 << 8) | 0x0b));
    }
}
