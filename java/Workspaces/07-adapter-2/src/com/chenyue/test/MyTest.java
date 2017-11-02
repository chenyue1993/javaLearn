package com.chenyue.test;

import java.util.ArrayList;
import java.util.List;

import com.chenyue.adapters.IWorkerAdapter;
import com.chenyue.adapters.imp.CookerAdapterImp;
import com.chenyue.adapters.imp.ProgramerAdapterImp;
import com.chenyue.worker.ICooker;
import com.chenyue.worker.IProgrammer;
import com.chenyue.worker.impl.JDProgrammer;
import com.chenyue.worker.impl.QjdCooker;

public class MyTest {
	
	private static List<IWorkerAdapter> adapters = getAllAdapters();

	public static void main(String[] args) {
		ICooker qjdCooker = new QjdCooker();
		IProgrammer jDProgrammer = new JDProgrammer();
		Object[] workers = {qjdCooker,jDProgrammer};
		
	    //ѭ������ÿ�����ֶ��� ����ÿ����������������ƥ�� 
		for (Object worker : workers) {
			IWorkerAdapter adapter = getAdapter(worker);
			System.out.println(adapter.work(worker));
		}
		
	}

	//����worker��ȡ��Ӧ�������� 
	private static IWorkerAdapter getAdapter(Object worker) {
		//List<IWorkerAdapter> adapters = getAllAdapters();
		for(IWorkerAdapter adapter : adapters){
			if (adapter.supports(worker)) {
				return adapter;
			}
		}
		return null;
	}

	//��ȡ���Ե������� 
	private static List<IWorkerAdapter> getAllAdapters() {
		List<IWorkerAdapter> adapters = new ArrayList<IWorkerAdapter>();
		adapters.add(new CookerAdapterImp());
		adapters.add(new ProgramerAdapterImp());
		return adapters;
	}

}
