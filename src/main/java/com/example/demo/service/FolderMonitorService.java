package com.example.demo.service;



import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.FileStatusRep;
import com.example.demo.Dao.MessageInfoRep;
import com.example.demo.Dao.ReceiverRep;
import com.example.demo.Dao.RequestRep;
import com.example.demo.Dao.SenderRep;
import com.example.demo.Dao.TransactionInfoRep;
import com.example.demo.Dao.TransactionReferenceRep;
import com.example.demo.XmlFileClass.MessageInfo;
import com.example.demo.XmlFileClass.Request;
import com.example.demo.XmlFileClass.Sender;
import com.example.demo.XmlFileClass.fileStatus;
import com.example.demo.util.panaceaFileutils;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FolderMonitorService implements MonitorService {
	
	 private static final Logger logger = LoggerFactory.getLogger(FolderMonitorService.class);

    @Value("${folder.path}")
    private String folderPath;
    private WatchService watchService ;
    private MessageInfoRep msgInfoRep;
    private ReceiverRep receiveRep;
    private SenderRep senderRep;
    private TransactionInfoRep tranInfoRep;
    private RequestRep ReqRep;
    private TransactionReferenceRep tranRefRep;
    private FileStatusRep fileStatusRep;
    private  ExecutorService executorService;
    String data;
    
    
    public FolderMonitorService(MessageInfoRep msgInfoRep,ReceiverRep receiveRep,SenderRep senderRep,TransactionInfoRep tranInfoRep,RequestRep ReqRep,TransactionReferenceRep tranRefRep,ExecutorService executorService,FileStatusRep fileStatusRep)
    {
    	this.msgInfoRep=msgInfoRep;
    	this.receiveRep=receiveRep;
    	this.senderRep=senderRep;
    	this.tranInfoRep=tranInfoRep;
    	this.ReqRep=ReqRep;
    	this.tranRefRep=tranRefRep;
    	this.executorService=executorService;
    	this.fileStatusRep=fileStatusRep;
    }
     
    
    public void startWatch() {
        this.executorService.submit(() -> {
			try {
				startMonitoring();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
    }
 
    private  void startMonitoring() throws URISyntaxException {
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path path = Path.of(folderPath);
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                	for (WatchEvent<?> event : key.pollEvents()) {
                        if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                            Path newFilePath = (Path) event.context();
                            String pathName=folderPath+""+newFilePath;
                            System.out.println("New file detected: " + pathName);
                            this.XMLConvetToObject(pathName);
                        }
                }
                boolean reset = key.reset();
                if (!reset) {
                    System.err.println("WatchKey could not be reset, exiting monitoring.");
                    break;
                }
            }
        } catch (IOException e) {
        	
        	System.out.println("test");
            e.printStackTrace();
        } catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void stopMonitor() {
    	 try {
             // Stop the watch service
             if (watchService != null) {
                 watchService.close();
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    @PreDestroy
    public void cleanup() {
        try {
            // Stop the watch service
            if (watchService != null) {
                watchService.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void XMLConvetToObject(String fileName) throws JAXBException {
    	
    	File file = new File(fileName);
    	fileStatus fs=new fileStatus();
        fs.setFileName(fileName);
        fs.setStage(1); 
        
        logger.info(fileName+" stage 1 completed");
    	try {
		        String data=panaceaFileutils.readFileContent(fileName);
		        fs.setMsgContent(data);
		        JAXBContext jaxbContext;
				
				jaxbContext = JAXBContext.newInstance(Request.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Request eftRequest = (Request) jaxbUnmarshaller.unmarshal(file);
				 fs.setStage(2);
				 logger.info(fileName+" stage 2 completed");
				eftRequest.setFileName(fileName);
				eftRequest.setIn_time(LocalDateTime.now());
				eftRequest.setMessageInfo(eftRequest.getMessageInfo());
				eftRequest.setSender(eftRequest.getSender());
				eftRequest.setReceiver(eftRequest.getReceiver());
				eftRequest.setTransactionInfo(eftRequest.getTransactionInfo());
				eftRequest.setTransactionReference(eftRequest.getTransactionReference());
				fs.setStage(3);
				logger.info(fileName+" stage 3 completed");
				msgInfoRep.save(eftRequest.getMessageInfo());
				senderRep.save(eftRequest.getSender());
				receiveRep.save(eftRequest.getReceiver());
				tranInfoRep.save(eftRequest.getTransactionInfo());
				tranRefRep.save(eftRequest.getTransactionReference());
				ReqRep.save(eftRequest);
				fs.setStage(4);
				logger.info(fileName+" stage 4 completed");
				fs.setStatus('S');
				panaceaFileutils.deleteFile(fileName);
			} catch (JAXBException e) {
				logger.error(""+e.getClass());
				fs.setStatus('F');
				fs.setError(""+e.getClass());
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			catch(Exception ee) {
				logger.error(ee.getMessage());
				ee.printStackTrace();
			}
			
			fileStatusRep.save(fs); 
    	
    }

}