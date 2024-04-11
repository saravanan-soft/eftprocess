package com.example.demo.XmlFileClass;

import jakarta.persistence.Entity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.kafka.common.serialization.Serializer;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;



@Entity
@XmlRootElement(name = "Request",namespace="http://www.progressoft.com/EFTRequest")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ReqId;
	private String fileName;
	private LocalDateTime in_time;
	
	
    public LocalDateTime getIn_time() {
		return in_time;
	}

	public void setIn_time(LocalDateTime in_time) {
		this.in_time = in_time;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getReqId() {
		return ReqId;
	}

	public void setReqId(int reqId) {
		ReqId = reqId;
	}

	
	@OneToOne
	private MessageInfo messageInfo;
	
	@OneToOne
    private Sender sender;
	@OneToOne
    private Receiver receiver;
	@OneToOne
    private TransactionReference transactionReference;
	@OneToOne
    private TransactionInfo transactionInfo;
   
	@XmlElement(name = "MessageInfo",namespace="http://www.progressoft.com/EFTRequest")
    public MessageInfo getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(MessageInfo messageInfo) {
		this.messageInfo = messageInfo;
	}

	@XmlElement(name = "Sender",namespace="http://www.progressoft.com/EFTRequest")
	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	@XmlElement(name = "Receiver",namespace="http://www.progressoft.com/EFTRequest")
	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	@XmlElement(name = "TransactionReference",namespace="http://www.progressoft.com/EFTRequest")
	public TransactionReference getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(TransactionReference transactionReference) {
		this.transactionReference = transactionReference;
	}

	@XmlElement(name = "TransactionInfo",namespace="http://www.progressoft.com/EFTRequest")
	public TransactionInfo getTransactionInfo() {
		return transactionInfo;
	}

	public void setTransactionInfo(TransactionInfo transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	
	

	
		
		
	

	
}