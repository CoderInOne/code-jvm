package xunshan.byte_code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("Hello");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        private Object target;
        Object bind(Object target) {
            this.target = target;
            return Proxy.newProxyInstance(getClass().getClassLoader(),
                    target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome");
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {
        /*
         * output generated class
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        DynamicProxy dynamicProxy = new DynamicProxy();
        IHello proxy = (IHello) dynamicProxy.bind(new Hello());
        proxy.sayHello();
    }
}
