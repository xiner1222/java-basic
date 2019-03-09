package cn.stive.java.proxy.jdk.btye.buddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteBuddyDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        Class<?> dynamicType = new ByteBuddy().subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World"))
                .make()
                .load(ByteBuddyDemo.class.getClassLoader())
                .getLoaded();

        System.out.println(dynamicType.newInstance().toString());
        byte[] bytes = ProxyGenerator.generateProxyClass("ByteBuddy", new Class[]{dynamicType});
        File file = new File("/tmp/ByteBuddy.class");
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(bytes);
    }
}
