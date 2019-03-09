package cn.stive.java.proxy.jdk;

public class ProxyServiceImpl implements IProxyService {
    @Override
    public int doSomething(int a) {
        System.out.println("real process");
        return a;
    }
}
