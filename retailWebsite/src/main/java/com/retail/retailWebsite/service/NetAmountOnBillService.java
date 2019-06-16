package com.retail.retailWebsite.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.retail.retailWebsite.domain.UserBill;

@Service
public class NetAmountOnBillService {

	public BigDecimal fetchBillAmount(UserBill userBill) {
		
		BigDecimal bill=new BigDecimal(0);
		if(userBill.getBillType().equals("EMPLOYEE")) {
			bill=userBill.getBillAmount().subtract(userBill.getBillAmount().multiply(new BigDecimal(30)).divide(new BigDecimal(100)));
		}else if(userBill.getBillType().equals("AFFILIATE")) {
			bill=userBill.getBillAmount().multiply(new BigDecimal(10)).divide(new BigDecimal(100));
		}else if(userBill.getBillType().equals("PRIVILIGEDCUSTOMER")) {
			bill=userBill.getBillAmount().multiply(new BigDecimal(5)).divide(new BigDecimal(100));
		}else {
			bill=userBill.getBillAmount().multiply(new BigDecimal(0)).divide(new BigDecimal(100));
		}
		return bill;
	}
}
