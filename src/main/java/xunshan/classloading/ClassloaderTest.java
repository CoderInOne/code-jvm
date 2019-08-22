package xunshan.classloading;

import java.io.IOException;
import java.io.InputStream;

public class ClassloaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final ClassLoader myCl = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                /**
                 * MyClassLoader loading xunshan.classloading.ClassloaderTest
                 * MyClassLoader loading java.lang.Object
                 * MyClassLoader loading java.lang.ClassLoader
                 * MyClassLoader loading xunshan.classloading.ClassloaderTest$1
                 */
                System.out.println("MyClassLoader loading " + name);
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream in = ClassloaderTest.class.getResourceAsStream(fileName);
                    if (in == null) {
                        System.out.println("return super loadClass when loading " + name);
                        return super.loadClass(name);
                    }

                    byte[] bs = new byte[in.available()];
                    int read = in.read(bs);
                    return defineClass(name, bs, 0, read);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        Object mobj = myCl.loadClass("xunshan.classloading.ClassloaderTest").newInstance();
        Object obj = new ClassloaderTest();
        System.out.println(mobj instanceof ClassloaderTest);
        System.out.println(obj instanceof ClassloaderTest);
    }
}
