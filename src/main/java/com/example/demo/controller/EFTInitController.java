package com.example.demo.controller;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FolderMonitorService;

@RestController
@RequestMapping("/api/v1")
public class EFTInitController {
	
	private FolderMonitorService folderMonitorService;
	public EFTInitController(FolderMonitorService folderMonitorService)
	{
		this.folderMonitorService=folderMonitorService;
	}
	
	
	@GetMapping("/start")
	public ResponseEntity<String> startProcess(){
		this.folderMonitorService.startWatch();
		 return new ResponseEntity<>("Watch service has been started", HttpStatus.OK);
	}
	
	@GetMapping("/stop")
	public ResponseEntity<String> stopProcess(){
		this.folderMonitorService.stopMonitor();
		 return new ResponseEntity<>("Watch service has been stopped", HttpStatus.OK);
	}
	
	@ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<URISyntaxException> handleValidationErrors(URISyntaxException ex) {
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }
    

}
