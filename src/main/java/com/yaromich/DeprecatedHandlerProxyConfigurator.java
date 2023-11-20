package com.yaromich;

import net.sf.cglib.Enhancer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator{
    @Override
    public Object replaceWithProxyIFNeeded(Object t, Class implClass) {
        if(implClass.isAnnotationPresent(Deprecated.class)) {
            if(implClass.getInterfaces().length == 0) {
                return Enhancer.enhance(implClass, (o, method, objects, methodProxy) -> getInvocationHandlerLogic(method, objects, t));
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));
        } else {
            return t;
        }
    }

    private Object getInvocationHandlerLogic(Method method, Object[] args, Object t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("******** что ж ты делаешь урод!!");
        return method.invoke(method, args, t);
    }
}
