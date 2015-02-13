package com.bankht.monkey.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.bankht.monkey.rmi.entity.RmiTestEntity;

public interface IRmiSrevice extends Remote {
	//声明服务器端必须提供的服务 
	public String serivce(String content) throws RemoteException;
	
	public RmiTestEntity service2(RmiTestEntity entity) throws RemoteException;
}
