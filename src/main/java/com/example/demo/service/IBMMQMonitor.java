package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("ibmmqmonitor")
public class IBMMQMonitor implements MonitorService{

	@Override
	public void startWatch() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopMonitor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

}
