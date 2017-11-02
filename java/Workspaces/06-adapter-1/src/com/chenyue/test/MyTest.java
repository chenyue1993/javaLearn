package com.chenyue.test;

import com.chenyue.adapter.IWorkerAdapter;
import com.chenyue.adapter.imp.WorkAdapterImp;
import com.chenyue.worker.ICooker;
import com.chenyue.worker.IProgrammer;
import com.chenyue.worker.impl.JDProgrammer;
import com.chenyue.worker.impl.QjdCooker;

public class MyTest {

	public static void main(String[] args) {
		ICooker qjdCooker = new QjdCooker();
		IProgrammer jDProgrammer = new JDProgrammer();
		Object[] workers = {qjdCooker,jDProgrammer};
		
		//�������������� 
		IWorkerAdapter workerAdapter = new WorkAdapterImp();
	    //ѭ������ÿ�����ֶ��� ����ÿ����������������ƥ�� 
		for (Object worker : workers) {
			String workContent = workerAdapter.work(worker);
			System.out.println(workContent);
		}
		
	}

}