package com.bankht.monkey.rmi.service;

/*
* Context�ӿڱ�ʾһ�����������ģ�����һ�����Ƶ�����İ���ɡ�
* ���������͸�����Щ�󶨵�һЩ������
*/
import javax.naming.Context;
/*
* InitialContext����ִ�����������ĳ�ʼ�����ġ�    
* �ó�ʼ������ʵ�� Context �ӿڲ��ṩ�������Ƶ���ʼ�㡣
*/
import javax.naming.InitialContext;

public class Service {
  public static void main(String[] args) {
    try {
      //ʵ����ʵ����IService�ӿڵ�Զ�̷���ServiceImpl����
      IRmiSrevice service02 = new RmiServiceImpl("service02");
      //��ʼ�������ռ�
      Context namingContext = new InitialContext();
      //�����ư󶨵�����,���������ռ�ע���Ѿ�ʵ������Զ�̷������
      namingContext.rebind("rmi://localhost/service02", service02);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("��������������ע����1��Զ�̷������");
  }
}