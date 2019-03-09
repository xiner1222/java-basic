package cn.stive.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private IProxyService proxyService;

    public DynamicProxy(IProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "proxy process");
        return method.invoke(proxyService, args);
    }
}
