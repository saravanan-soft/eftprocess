package com.example.demo.utiltest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.example.demo.util.panaceaFileutils;

public class panaceaFileUtilsTest {

	@InjectMocks
    private panaceaFileutils panaceaeutils;
	
	@Test
    public void testContent() {
        String content = null;
        String filepath="D:\\project\\task\\eft\\test2.xml";
        content=panaceaeutils.readFileContent(filepath);
        System.out.println(content);
        Assertions.assertNotNull(content);
        }
        
        
        
    
	
	/*@Test
    public void delContent() {
        boolean content = false;
        String filepath="D:\\project\\task\\eft\\test.xml";
        content=panaceaeutils.deleteFile(filepath);
        System.out.println(content);
        Assertions.assertTrue(content);
        
        
    }*/
}
