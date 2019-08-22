package xunshan.classloading;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * How to check a class loaded into JVM?
 */
public class CheckedClassLoaded {
    static class Inner {
        static {
            System.out.println("Inner");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // sun.misc.Launcher$AppClassLoader
        ClassLoader cl = CheckedClassLoaded.class.getClassLoader();

        System.out.println(cl.getClass());
        Class<? extends ClassLoader> clcls = cl.getClass();

        // use java.lang.ClassLoader.findLoadedClass to find loaded class
        // AppClassLoader extends URLClassLoader extends SecureClassLoader extends ClassLoader
        Method mFindLoadedCls = clcls.getSuperclass()
                .getSuperclass()
                .getSuperclass()
                .getDeclaredMethod("findLoadedClass", String.class);
        mFindLoadedCls.setAccessible(true);

        // null
        System.out.println(mFindLoadedCls.invoke(cl, "xunshan.classloading.CheckedClassLoaded.Inner"));

        // class xunshan.classloading.CheckedClassLoaded
        System.out.println(mFindLoadedCls.invoke(cl, "xunshan.classloading.CheckedClassLoaded"));
    }
}
