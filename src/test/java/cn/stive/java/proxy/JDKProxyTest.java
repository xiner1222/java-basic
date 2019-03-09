package cn.stive.java.proxy;

import cn.stive.java.proxy.jdk.DynamicProxy;
import cn.stive.java.proxy.jdk.IProxyService;
import cn.stive.java.proxy.jdk.JDKProxy;
import cn.stive.java.proxy.jdk.ProxyServiceImpl;
import org.junit.Test;
import org.mockito.Mock;

import javax.sql.rowset.JdbcRowSet;
import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;
import static org.mockito.Mockito.when;

public class JDKProxyTest {
    @Mock
    private IProxyService proxyService;

    @Test
    public void testJdkProxy(){

        when(proxyService.doSomething(1)).thenReturn(2);

        IProxyService proxyService = (IProxyService) Proxy.newProxyInstance(
                JDKProxy.class.getClassLoader(),
                new Class[]{IProxyService.class},
                new DynamicProxy(new ProxyServiceImpl()));
         proxyService.doSomething(1);
    }

}
