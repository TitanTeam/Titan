package com.spring.me.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.spring.me.slave.impl.SlaveImplOne;

public class ProxyTarget  implements InvocationHandler{
	public static Object createProxy(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), new ProxyTarget(obj));
	}

	private Object target;

	private ProxyTarget(Object target) {
		this.target = target;
		/*scan all the dependecies in config and find the setter by param type*/
		inject(target, new SlaveImplOne());
	}

	public void inject(Object source,Object inject) {
		try {
			Method[] methods = source.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				Method m = methods[i];
				String mname = m.getName();
				Class[] types = m.getParameterTypes();
				if (mname.startsWith("set") && types.length == 1
						&& m.getReturnType() == Void.TYPE) {
					if(types[0].isInstance(inject))
					m.invoke(source,
							new Object[] { inject });
				}
			}
		} catch (Exception ex) {
			String msg = "Initialization error";
			throw new RuntimeException(msg, ex);

		}
	}
	
	// Implements the method of InvocationHandler interface
	// This method will catch all the calls to the target class
	// and redispatch them
	public Object invoke(Object proxy, Method method, Object[] args)
    {
             Object result = null;
             try{
                    //add function before redispatching
                    System.out.println("Before "+method.getName());
                    //redispatch the call
                    result = method.invoke(target,args);
                    //add function after redispatching
                    System.out.println("After "+method.getName());
             }catch(Exception e){
                    System.out.println(e.getMessage());
             }
             return result;
      }
}
