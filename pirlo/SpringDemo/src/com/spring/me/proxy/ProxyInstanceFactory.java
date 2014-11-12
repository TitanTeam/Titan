package com.spring.me.proxy;

import java.lang.reflect.Proxy;

import com.spring.me.handler.BaseHandler;
import com.spring.me.handler.MyHandler;
import com.spring.me.handler.MyHandlerTwo;
import com.spring.me.service.UltimaService;
import com.spring.me.service.UltimaServiceIntf;

public class ProxyInstanceFactory {
	
	public static UltimaServiceIntf getProxyInstance(){
		BaseHandler handler;
		handler = new MyHandler();
		//handler = new MyHandlerTwo();
		
		UltimaServiceIntf obj = new UltimaService();
		handler.setObj(obj);
		
		Class cls = obj.getClass();
		UltimaServiceIntf proxy = (UltimaServiceIntf) Proxy.newProxyInstance(cls
				.getClassLoader(), cls.getInterfaces(), handler);
		return proxy;
	}
}
