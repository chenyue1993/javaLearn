package com.chenyue.service;

public abstract class Shopping {
	
	//模板方法
	//servlet中doGet和doPost方法
	public void byGoods(){
		userLogin();
		buy();
		pay();
	}
	
	//子类不能重写的方法
	public final void userLogin(){
		System.out.println("用户登录");
	}
	
	//子类必须实现
	public abstract void buy();
	
	
	//钩子方法
	public  void pay(){
		System.out.println("使用银联卡");
	}
		
}
