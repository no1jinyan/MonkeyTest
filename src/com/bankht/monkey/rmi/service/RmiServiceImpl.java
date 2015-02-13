package com.bankht.monkey.rmi.service;

import java.rmi.RemoteException;
//UnicastRemoteObject���ڵ�����Զ�̶���ͻ�����Զ�̶���ͨ�ŵĴ���� 
import java.rmi.server.UnicastRemoteObject;

import com.bankht.monkey.rmi.entity.RmiTestEntity;

public class RmiServiceImpl extends UnicastRemoteObject implements IRmiSrevice {
	private String name;
	
	protected RmiServiceImpl(String name) throws RemoteException {
		super();
		this.name = name;
	}

	private static final long serialVersionUID = 8241606835836725250L;

	@Override
	public String serivce(String content) throws RemoteException {
		return "Serivce >> " + content + ". ����" + this.name;
	}

	@Override
	public RmiTestEntity service2(RmiTestEntity entity) throws RemoteException {
		if(entity.getName().equals("jinyan")){
			entity.setPassword("jinyan's password");
			entity.setMsg("����password");
		} else {
			entity.setMsg("�û�����������ûϷ");
		}
		return entity;
	}

}
