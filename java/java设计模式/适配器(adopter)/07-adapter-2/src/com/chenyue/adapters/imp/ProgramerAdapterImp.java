package com.chenyue.adapters.imp;

import com.chenyue.adapters.IWorkerAdapter;
import com.chenyue.worker.IProgrammer;

public class ProgramerAdapterImp implements IWorkerAdapter {

	@Override
	public String work(Object worker) {
		
		return (((IProgrammer)worker).program());
	}

	@Override
	public boolean supports(Object worker) {
		return (worker instanceof IProgrammer);
	}

}
