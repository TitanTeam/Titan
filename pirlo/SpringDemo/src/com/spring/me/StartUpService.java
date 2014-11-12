package com.spring.me;

import com.spring.me.handler.ProxyTarget;
import com.spring.me.proxy.ProxyInstanceFactory;
import com.spring.me.service.UltimaServcieWithOutSpring;
import com.spring.me.service.UltimaService;
import com.spring.me.service.UltimaServiceIntf;

public class StartUpService {
	public static void main(String args[]){
		/*UltimaServiceIntf proxy = ProxyInstanceFactory.getProxyInstance();
		proxy.applyService();*/
		
		
		UltimaServiceIntf t = (UltimaServiceIntf)ProxyTarget.createProxy(
                new UltimaService());
		t.applyService();
/*		System.out.println("-------------------------------------------------");
		
		UltimaServiceIntf service = new UltimaServcieWithOutSpring();
		service.applyService();*/
	}
}
