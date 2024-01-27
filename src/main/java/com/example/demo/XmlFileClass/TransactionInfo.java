package com.example.demo.XmlFileClass;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Entity
public class TransactionInfo  {
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int TranInfoId;
	
	
	
    private int amount;
    private String currency;
    private String valueDate;
    private String initiatedBy;
    private String initiatedOn;
    private String checkedBy;
    private String checkedOn;
    @XmlElement(name = "Amount",namespace="http://www.progressoft.com/EFTRequest")
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@XmlElement(name = "Currency",namespace="http://www.progressoft.com/EFTRequest")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@XmlElement(name = "ValueDate",namespace="http://www.progressoft.com/EFTRequest")
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	@XmlElement(name = "InitiatedBy",namespace="http://www.progressoft.com/EFTRequest")
	public String getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	@XmlElement(name = "InitiatedOn",namespace="http://www.progressoft.com/EFTRequest")
	public String getInitiatedOn() {
		return initiatedOn;
	}
	public void setInitiatedOn(String initiatedOn) {
		this.initiatedOn = initiatedOn;
	}
	@XmlElement(name = "CheckedBy",namespace="http://www.progressoft.com/EFTRequest")
	public String getCheckedBy() {
		return checkedBy;
	}
	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}
	@XmlElement(name = "CheckedOn",namespace="http://www.progressoft.com/EFTRequest")
	public String getCheckedOn() {
		return checkedOn;
	}
	public void setCheckedOn(String checkedOn) {
		this.checkedOn = checkedOn;
	}
	@Override
	public String toString() {
		return "TransactionInfo [amount=" + amount + ", currency=" + currency + ", valueDate=" + valueDate
				+ ", initiatedBy=" + initiatedBy + ", initiatedOn=" + initiatedOn + ", checkedBy=" + checkedBy
				+ ", checkedOn=" + checkedOn + "]";
	}
    
	
    
}