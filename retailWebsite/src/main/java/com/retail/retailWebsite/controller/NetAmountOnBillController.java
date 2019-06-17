package com.retail.retailWebsite.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.retailWebsite.domain.UserBill;
import com.retail.retailWebsite.service.NetAmountOnBillService;

@RestController
public class NetAmountOnBillController {

	@Autowired
	NetAmountOnBillService netAmountOnBillService;
	
	@RequestMapping(value="/index",method=RequestMethod.POST,produces = "application/json",consumes = "application/json")
	public BigDecimal index(@RequestBody UserBill userBill) {
		
		
			BigDecimal billAmount=netAmountOnBillService.fetchBillAmount(userBill.getBillType(),userBill.getUserType(),userBill.getBillAmount());
						
			return billAmount;
		
		
		
	}
}
