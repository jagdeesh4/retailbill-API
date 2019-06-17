package com.retail.retailWebsite.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class NetAmountOnBillService {

	public BigDecimal fetchBillAmount(String billType,String userType,BigDecimal bill) {
		
		BigDecimal discountedBill=new BigDecimal(0);

		if(!billType.equals("GROCERY")) {
		if(userType.equals("EMPLOYEE")) {
			discountedBill=bill.subtract(bill.multiply(new BigDecimal(30)).divide(new BigDecimal(100)));
		}else if(userType.equals("AFFILIATE")) {
			discountedBill=bill.multiply(new BigDecimal(10)).divide(new BigDecimal(100));
		}else if(userType.equals("PRIVILIGEDCUSTOMER")) {
			discountedBill=bill.multiply(new BigDecimal(5)).divide(new BigDecimal(100));
		}else {
			discountedBill=bill.subtract(bill.divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_DOWN)
					.multiply(new BigDecimal(5)));	
		}
		System.out.println("Discounted Bill "+discountedBill);
		return discountedBill;
		}else {
			return bill;	
		}
	}
}
