package com.example.demo.utiltest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.example.demo.service.FolderMonitorService;
import com.example.demo.util.panaceaFileutils;

import jakarta.xml.bind.JAXBException;

public class FilfolderTest {
	
	@InjectMocks
    private FolderMonitorService panaceaeutils;
	
	@Test
    public void testContent() throws JAXBException {
		//panaceaeutils=new FolderMonitorService();
        String content = null;
        String filepath="D:\\project\\task\\eft\\test2.xml";
        panaceaeutils.XMLConvetToObject(filepath);
        System.out.println(content);
        Assertions.assertNotNull(content);
        }
     

}
