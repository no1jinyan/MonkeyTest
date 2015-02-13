package com.bankht.monkey.rmi.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bankht.monkey.rmi.entity.RmiTestEntity;
import com.bankht.monkey.rmi.service.IRmiSrevice;

public class Client {
	public static void main(String[] args){
		String url = "rmi://localhost/"; 
		
		try {
			Context namingContext = new InitialContext();
			IRmiSrevice service02 = (IRmiSrevice) namingContext.lookup(url + "service02");
			System.out.println(service02.serivce("ÄãºÃ£¡")); 
			
			//test entity
			testEntity(service02);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void testEntity(IRmiSrevice service){
		RmiTestEntity entity = new RmiTestEntity();
		entity.setName("monkey");
		try {
			entity = service.service2(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println(entity.getMsg());
		if(entity.getPassword() != null){
			System.out.println("ÃÜÂë£º" + entity.getPassword());
		}		
	}
}
