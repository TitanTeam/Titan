package com.spring.me.service;

import com.spring.me.slave.Slave;
import com.spring.me.slave.impl.SlaveImplOne;
import com.spring.me.slave.impl.SlaveImplTwo;

public class UltimaServcieWithOutSpring implements UltimaServiceIntf {
	private Slave slave ;
	private static final String user = "zhangwuhui";
	
	public void applyService() {
		if(user.equals("zhangwuhui")){
			slave = new SlaveImplOne();
		}
		else{
			slave = new SlaveImplTwo();
		}//if there is 100 slaves?
		System.out.println("before dowork");//using log4j?
		slave.doWork();
		System.out.println("after dowork");
	}
	
	
}
