package com.bankht.monkey.rmi.service;

import java.rmi.RemoteException;
//UnicastRemoteObject用于导出的远程对象和获得与该远程对象通信的存根。 
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
		return "Serivce >> " + content + ". 我是" + this.name;
	}

	@Override
	public RmiTestEntity service2(RmiTestEntity entity) throws RemoteException {
		if(entity.getName().equals("jinyan")){
			entity.setPassword("jinyan's password");
			entity.setMsg("给你password");
		} else {
			entity.setMsg("用户名错误，密码没戏");
		}
		return entity;
	}

}
