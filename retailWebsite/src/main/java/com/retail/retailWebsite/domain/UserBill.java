package com.retail.retailWebsite.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retail.retailWebsite.domain.bill.Bill;
import com.retail.retailWebsite.domain.user.User;

public class UserBill {

	@JsonProperty
	private User user=null;
	
	@JsonProperty
	private Bill bill=null;
	
	public UserBill() {
		
	}
	
	public UserBill(User user, Bill bill) {
		this.user=user;
		this.bill=bill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
	
	
}
