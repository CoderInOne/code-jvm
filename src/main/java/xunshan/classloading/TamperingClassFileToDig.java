package xunshan.classloading;

/**
 * Make Verification Phase fail:
 * 1. compile and run
 * 2. vim xunshan.TamperingClassFileToDig.class
 * 3. edit as hex:% ! xxd
 * 4. change any hex number like magic number, version number
 * 5. save:% ! xxd -r
 * 6. java xunshan.TamperingClassFileToDig
 * 7. read error and check error msg in classFileParser.cpp of HotSpot code
 *
 * More evil things:
 * java -Xverify:none malicious_class
 * JVM got kill
 */
public class TamperingClassFileToDig {
    public static void main(String[] args) {
        System.out.println("hi");
    }
}
