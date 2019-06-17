package com.retail.retailWebsite;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.retailWebsite.service.NetAmountOnBillService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailWebsiteServiceTest {

	
	@Autowired
	NetAmountOnBillService netAmountOnBillService;

	@Test
	public void testForEmployeeCategory() {		
		assertThat(netAmountOnBillService.fetchBillAmount("GROCERY","EMPLOYEE",new BigDecimal(100)).equals(new BigDecimal(70)));
	}
	
	@Test
	public void testForaffliateCategory() {		
		assertThat(netAmountOnBillService.fetchBillAmount("GROCERY","AFFILIATE",new BigDecimal(100)).equals(new BigDecimal(90)));
	}
	
	@Test
	public void testForPriviligedCategory() {		
		assertThat(netAmountOnBillService.fetchBillAmount("GROCERY","PRIVILIGEDCUSTOMER",new BigDecimal(100)).equals(new BigDecimal(95)));
	}
	
	@Test
	public void testForOtherCategory() {		
		assertThat(netAmountOnBillService.fetchBillAmount("GROCERY","OTHERCUSTOMER",new BigDecimal(199)).equals(new BigDecimal(194)));
	}
	
	@Test
	public void testForNonGroceryCategory() {		
		assertThat(netAmountOnBillService.fetchBillAmount("NONGROCERY","EMPLOYEE",new BigDecimal(100)).equals(new BigDecimal(100)));
	}


}
