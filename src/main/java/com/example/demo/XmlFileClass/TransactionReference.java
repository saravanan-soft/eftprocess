package com.example.demo.XmlFileClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;


@Entity
public class TransactionReference {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int TranRefId;
    
    
    private String senderReference;
    private String systemReference;
    private String source;
    @XmlElement(name = "SenderReference",namespace="http://www.progressoft.com/EFTRequest")
	public String getSenderReference() {
		return senderReference;
	}
	public void setSenderReference(String senderReference) {
		this.senderReference = senderReference;
	}
	@XmlElement(name = "SystemReference",namespace="http://www.progressoft.com/EFTRequest")
	public String getSystemReference() {
		return systemReference;
	}
	public void setSystemReference(String systemReference) {
		this.systemReference = systemReference;
	}
	@XmlElement(name = "Source",namespace="http://www.progressoft.com/EFTRequest")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Override
	public String toString() {
		return "TransactionReference [senderReference=" + senderReference + ", systemReference=" + systemReference
				+ ", source=" + source + "]";
	}
}