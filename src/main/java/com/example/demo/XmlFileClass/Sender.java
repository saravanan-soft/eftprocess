package com.example.demo.XmlFileClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

//@XmlRootElement(name = "Sender")
@Entity
public class Sender {
    
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int SendId;
	
	@Column(name="SenderaccountNumber")
    private String accountNumber;
	@Column(name="Sendername")
    private String name;
	@Column(name="Senderemail")
    private String email;
	@Column(name="SendermobileNumber")
    private String mobileNumber;
	@Column(name="SenderbankCode")
    private String bankCode;
    @Column(name="SenderbranchCode")
    private String branchCode;
    @Column(name="SendercustomerId")
    private String customerId;
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
	@XmlElement(name = "Email",namespace="http://www.progressoft.com/EFTRequest")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name = "MobileNumber",namespace="http://www.progressoft.com/EFTRequest")
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	@XmlElement(name = "CustomerId",namespace="http://www.progressoft.com/EFTRequest")
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Sender [accountNumber=" + accountNumber + ", name=" + name + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", bankCode=" + bankCode + ", branchCode=" + branchCode + ", customerId=" + customerId
				+ "]";
	}
}
