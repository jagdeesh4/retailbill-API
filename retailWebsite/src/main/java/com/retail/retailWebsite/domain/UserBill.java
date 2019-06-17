package com.retail.retailWebsite.domain;

import java.math.BigDecimal;

public class UserBill {

	private String userType;
	private BigDecimal billAmount;
	private String billType;
		
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public BigDecimal getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	
	
	
	
}
