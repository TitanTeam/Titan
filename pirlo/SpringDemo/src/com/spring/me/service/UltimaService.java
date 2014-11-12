package com.spring.me.service;

import com.spring.me.slave.Slave;

public class UltimaService implements UltimaServiceIntf{
	private Slave slave;
	
	public void applyService(){
		slave.doWork();
	}

	public void setSlave(Slave slave) {
		System.out.println("UltimaService:slave set by handler");
		this.slave = slave;
	}
}
