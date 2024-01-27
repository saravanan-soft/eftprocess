package com.example.demo.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class panaceaFileutils {
	
	
	 public static String readFileContent(String fileName) {
		
		
	    String str="";
        try {
            Path path = Paths.get(fileName);
            List<String> lines = Files.readAllLines(path);
            // Process the lines or do whatever you need with them
            for (String line : lines) {
                str=str+line+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly
        }
		
		return str;
	}

	 public static boolean deleteFile(String fileName) {
		boolean res=false;
		  File file = new File(fileName);
	        if (file.exists()) {
	            if (file.delete()) {
	            	res=true;
	                System.out.println("File deleted successfully: " + fileName);
	            } else {
	            	res=false;
	                System.out.println("Failed to delete the file: " + fileName);
	            }
	        } else {
	            System.out.println("File does not exist: " + fileName);
	        }
	        
	        return res;
	}
}
