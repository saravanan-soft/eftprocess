package com.example.demo.XmlFileClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@Entity
public class Receiver {
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int RecId;
	
	
	@Column(name="RecAccNum")
    private String accountNumber;    
	
	@Column(name="RecName")
    private String name;
	
	@Column(name="RecbankCode")
    private String bankCode;
	
	@Column(name="RecbranchCode")
    private String branchCode;
    @XmlElement(name = "AccountNumber",namespace="http://www.progressoft.com/EFTRequest")
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@XmlElement(name = "Name",namespace="http://www.progressoft.com/EFTRequest")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name = "BankCode",namespace="http://www.progressoft.com/EFTRequest")
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	@XmlElement(name = "BranchCode",namespace="http://www.progressoft.com/EFTRequest")
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	@Override
	public String toString() {
		return "Receiver [accountNumber=" + accountNumber + ", name=" + name + ", bankCode=" + bankCode
				+ ", branchCode=" + branchCode + "]";
	}
}
