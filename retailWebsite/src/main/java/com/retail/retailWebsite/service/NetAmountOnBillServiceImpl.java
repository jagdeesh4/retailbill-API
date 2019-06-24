package com.retail.retailWebsite.service;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.retailWebsite.domain.bill.Bill;
import com.retail.retailWebsite.domain.bill.Item;
import com.retail.retailWebsite.domain.bill.ItemType;
import com.retail.retailWebsite.domain.user.User;

@Service
public class NetAmountOnBillServiceImpl implements NetAmountOnBillService{

	@Override
	public BigDecimal fetchBillAmount(User user,Bill bill) {
		
		
		   BigDecimal groceryAmount = calculateItemsAmount(bill.getItems(), ItemType.GROCERY.toString());
	        BigDecimal totalAmount = calculateItemsAmount(bill.getItems(), null);
	        BigDecimal nonGroceryAmount = totalAmount.subtract(groceryAmount);
	        BigDecimal billsDiscount = calculateBillDiscount(totalAmount, 100, 5);

	        if(nonGroceryAmount.compareTo(BigDecimal.ZERO)!=0) {
	            nonGroceryAmount = calculateBillAfterDiscount(user.getType().toString(),nonGroceryAmount, user.getJoinDate());
	        }

	        BigDecimal finalAmount = (groceryAmount.add(nonGroceryAmount)).subtract(billsDiscount);

		return finalAmount;
		
	}
	
	public BigDecimal calculateBillDiscount(BigDecimal totalAmount, int amount , int discountAmount) {
	
		return totalAmount.divide(new BigDecimal(amount)).setScale(0,BigDecimal.ROUND_DOWN)
		.multiply(new BigDecimal(discountAmount));
		
	}

	public BigDecimal calculateItemsAmount(List<Item> items,String itemType) {
		
		BigDecimal amount=new BigDecimal(0);
		for (Item item : items) {
		
			if(itemType==null) {
				amount=amount.add(item.getPrice());
			}else {
				if(itemType.equals(item.getType().toString())) {
				
					amount=amount.add(item.getPrice());
				}
			}
		}
		
		
		return amount;
	}
	
	public BigDecimal calculateBillAfterDiscount(String userType,BigDecimal amount,Date customerJoinedDate) {
		
		if(userType.equals("EMPLOYEE")) {
			amount=amount.subtract(amount.multiply(new BigDecimal(30)).divide(new BigDecimal(100)));
			
		}else if (userType.equals("AFFILIATE")) {
			amount=amount.subtract(amount.multiply(new BigDecimal(10)).divide(new BigDecimal(100)));
		}else if (userType.equals("CUSTOMER")) {
			if(isOldCustomer(customerJoinedDate,2)) {
				amount=amount.subtract(amount.multiply(new BigDecimal(5)).divide(new BigDecimal(100)));
			}
		}
		
		return amount;
	}
	
	
	public boolean isOldCustomer(Date customerJoinedDate,int years) {
		Calendar currentDate=Calendar.getInstance();
		Calendar givenDate=Calendar.getInstance();
		givenDate.setTime(customerJoinedDate);
		return (currentDate.get(Calendar.YEAR)-givenDate.get(Calendar.YEAR))>=years;
	}
}
