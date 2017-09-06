package com.chenyue.adapters.imp;

import com.chenyue.adapters.IWorkerAdapter;
import com.chenyue.worker.ICooker;

public class CookerAdapterImp implements IWorkerAdapter {

	@Override
	public String work(Object worker) {

		return (((ICooker) worker).cook());
	}

	@Override
	public boolean supports(Object worker) {
		return (worker instanceof ICooker);
	}

}
