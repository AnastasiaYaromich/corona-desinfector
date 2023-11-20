package com.yaromich;

public interface ProxyConfigurator {
    Object replaceWithProxyIFNeeded(Object t, Class implClass);
}
