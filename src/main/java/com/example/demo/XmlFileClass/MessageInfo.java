package com.example.demo.XmlFileClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
