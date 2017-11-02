package com.chenyue.worker.impl;

import com.chenyue.worker.ICooker;
import com.chenyue.worker.IProgrammer;

public class MyTest {

	public static void main(String[] args) {
		ICooker qjdCooker = new QjdCooker();
		IProgrammer jDProgrammer = new JDProgrammer();
		System.out.println(qjdCooker.cook());
		System.out.println(jDProgrammer.program());
		
	}

}
