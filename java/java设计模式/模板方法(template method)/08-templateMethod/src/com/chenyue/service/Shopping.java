package com.chenyue.service;

public abstract class Shopping {
	
	//ģ�巽��
	//servlet��doGet��doPost����
	public void byGoods(){
		userLogin();
		buy();
		pay();
	}
	
	//���಻����д�ķ���
	public final void userLogin(){
		System.out.println("�û���¼");
	}
	
	//�������ʵ��
	public abstract void buy();
	
	
	//���ӷ���
	public  void pay(){
		System.out.println("ʹ��������");
	}
		
}
