package com.spring.me.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import com.spring.me.service.UltimaService;
import com.spring.me.slave.Slave;

public class MyHandlerTwo extends BaseHandler {

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		((UltimaService)obj).setSlave(getSlaveFromConfigFile());
		/*pre process*/
		System.out.println("处理器:开始工作!");
		
		method.invoke(obj, args);
		
		/*post process*/
		System.out.println("处理器:下班了!");
		
		return null;
	}

	private Slave getSlaveFromConfigFile() {
		final String CONFIG_FILE = "config.properties";
		final String KEY = "slave";
		Slave slave = null;
		Properties prop = new Properties();
		File file = new File(CONFIG_FILE);
		InputStream inStream;
		try {
			/*load config file*/
			inStream = new FileInputStream(file);
			prop.load(inStream);
			
			String objName = prop.getProperty(KEY);
			System.out.println("object slave:" + objName);
			
			slave = (Slave) Class.forName(objName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return slave;
	}
}
