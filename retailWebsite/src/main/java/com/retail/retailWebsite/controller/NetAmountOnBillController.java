package com.retail.retailWebsite.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.retail.retailWebsite.domain.UserBill;
import com.retail.retailWebsite.service.NetAmountOnBillService;

@RestController
public class NetAmountOnBillController {

	@Autowired
	NetAmountOnBillService netAmountOnBillService;
	
	@RequestMapping(value="/getNetBillAmount",method=RequestMethod.POST,produces = "application/json",consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public BigDecimal fetchNetAmount(@RequestBody UserBill userBill) {
		
		
			BigDecimal billAmount=netAmountOnBillService.fetchBillAmount(userBill.getUser(),userBill.getBill());
						
			return billAmount;
		
		
		
	}
}
