package com.chenyue.adapter.imp;

import com.chenyue.adapter.IWorkerAdapter;
import com.chenyue.worker.ICooker;
import com.chenyue.worker.IProgrammer;

public class WorkAdapterImp implements IWorkerAdapter{
	
	String workContent = "";
	
	@Override
	public String work(Object worker) {
		if (worker instanceof ICooker) {
			workContent = ((ICooker) worker).cook();
		}
		if (worker instanceof IProgrammer){
			workContent = ((IProgrammer) worker).program();
		}
		return workContent;
	}
	
}
