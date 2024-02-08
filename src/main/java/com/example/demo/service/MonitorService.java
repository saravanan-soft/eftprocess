package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface MonitorService {
	
	public void startWatch();
	public void stopMonitor();
	public void cleanup();

}
