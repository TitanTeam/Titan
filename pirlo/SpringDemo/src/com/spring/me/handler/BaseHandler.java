package com.spring.me.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BaseHandler implements InvocationHandler{
	
	protected Object obj;

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
