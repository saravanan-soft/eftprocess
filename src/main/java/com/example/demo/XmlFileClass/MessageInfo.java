package com.example.demo.XmlFileClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
public class MessageInfo  {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int MsgInfoId;
	
    public int getMsgInfoId() {
		return MsgInfoId;
	}

	public void setMsgInfoId(int msgInfoId) {
		MsgInfoId = msgInfoId;
	}

	private int messageVersion;

    @XmlElement(name = "MessageVersion",namespace="http://www.progressoft.com/EFTRequest")
	public int getMessageVersion() {
		return messageVersion;
	}

	public void setMessageVersion(int messageVersion) {
		this.messageVersion = messageVersion;
	}

	@Override
	public String toString() {
		return "MessageInfo [messageVersion=" + messageVersion + "]";
	}
	
}
