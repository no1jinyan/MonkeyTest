package com.bankht.monkey.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.bankht.monkey.rmi.entity.RmiTestEntity;

public interface IRmiSrevice extends Remote {
	//�����������˱����ṩ�ķ��� 
	public String serivce(String content) throws RemoteException;
	
	public RmiTestEntity service2(RmiTestEntity entity) throws RemoteException;
}
