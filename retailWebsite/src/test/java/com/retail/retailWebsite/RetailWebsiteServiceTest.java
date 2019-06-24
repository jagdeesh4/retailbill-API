package com.retail.retailWebsite;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.retailWebsite.domain.bill.Bill;
import com.retail.retailWebsite.domain.bill.Item;
import com.retail.retailWebsite.domain.bill.ItemType;
import com.retail.retailWebsite.domain.user.User;
import com.retail.retailWebsite.service.NetAmountOnBillServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailWebsiteServiceTest {

	
	@Autowired
	NetAmountOnBillServiceImpl netAmountOnBillService;
	
	@Test
    public void testCalculateMixItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(BigDecimal.valueOf(100), "Banana", ItemType.GROCERY));
        items.add(new Item(BigDecimal.valueOf(100), "Apple", ItemType.GROCERY));
        items.add(new Item(BigDecimal.valueOf(100), "Orange", ItemType.GROCERY));
        items.add(new Item(BigDecimal.valueOf(100), "Tshirt", ItemType.CLOTHING));
        items.add(new Item(BigDecimal.valueOf(100), "Jeans", ItemType.CLOTHING));
        
        BigDecimal total = netAmountOnBillService.calculateItemsAmount(items, null);
        assertEquals(0, BigDecimal.valueOf(500).compareTo(total));
    }

	@Test
    public void testCalculateOnlyGroceryItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(BigDecimal.valueOf(100), "Banana", ItemType.GROCERY));
        items.add(new Item(BigDecimal.valueOf(100), "Apple", ItemType.GROCERY));
        items.add(new Item(BigDecimal.valueOf(100), "Orange", ItemType.GROCERY));
        
        BigDecimal total = netAmountOnBillService.calculateItemsAmount(items, null);
        assertEquals(0, BigDecimal.valueOf(300).compareTo(total));
    }
	
	@Test
    public void testCalculateNonGroceryItems() {
        List<Item> items = new ArrayList<Item>();

        items.add(new Item(BigDecimal.valueOf(100), "Pen", ItemType.STATIONARY));
        items.add(new Item(BigDecimal.valueOf(100), "Paper", ItemType.STATIONARY));
        items.add(new Item(BigDecimal.valueOf(100), "Tshirt", ItemType.CLOTHING));
        items.add(new Item(BigDecimal.valueOf(100), "Jeans", ItemType.CLOTHING));
        
        BigDecimal total = netAmountOnBillService.calculateItemsAmount(items, null);
        assertEquals(0, BigDecimal.valueOf(400).compareTo(total));
    }
	

	 @Test
	    public void testCalculateBillDiscountSample1() {
		 BigDecimal amount = netAmountOnBillService.calculateBillDiscount(BigDecimal.valueOf(100), 100, 5);
		 assertEquals(0, BigDecimal.valueOf(5).compareTo(amount));
	    }
	    
	   @Test
	    public void testCalculateBillDiscountSample2() {

		   BigDecimal amount = netAmountOnBillService.calculateBillDiscount(BigDecimal.valueOf(280), 100, 5);
		   assertEquals(0, BigDecimal.valueOf(10).compareTo(amount));
	    }
	   
	   @Test
	    public void testCalculateItemsAmountSample1() {
		   List<Item> items = new ArrayList<Item>();
		    items.add(new Item(BigDecimal.valueOf(100), "Banana", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Apple", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Orange", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Tshirt", ItemType.CLOTHING));
	        items.add(new Item(BigDecimal.valueOf(100), "Jeans", ItemType.CLOTHING));
		   BigDecimal amount = netAmountOnBillService.calculateItemsAmount(items,null);
		   assertEquals(0, BigDecimal.valueOf(500).compareTo(amount));
	    }
	   
	   @Test
	    public void testCalculateItemsAmountSample2() {
		   List<Item> items = new ArrayList<Item>();
		    items.add(new Item(BigDecimal.valueOf(100), "Banana", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Apple", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Orange", ItemType.GROCERY));
		   BigDecimal amount = netAmountOnBillService.calculateItemsAmount(items,"GROCERY");
		   assertEquals(0, BigDecimal.valueOf(300).compareTo(amount));
	    }
	   
	   @Test
	    public void testcalculateBillAfterDiscountSample1() {;
		   BigDecimal amount = netAmountOnBillService.calculateBillAfterDiscount("EMPLOYEE",BigDecimal.valueOf(500),null);
		   assertEquals(0, BigDecimal.valueOf(350).compareTo(amount));
	    }
	   
	   @Test
	    public void testcalculateBillAfterDiscountSample2() {
		   BigDecimal amount = netAmountOnBillService.calculateBillAfterDiscount("AFFILIATE",BigDecimal.valueOf(500),null);
		   assertEquals(0, BigDecimal.valueOf(450).compareTo(amount));
	    }
	   
	   @Test
	    public void testcalculateBillAfterDiscountSample3() {
		   try {
		   DateFormat format = new SimpleDateFormat("dd/MM/yyyy");	
			Date date = format.parse("26/10/2015");
			  BigDecimal amount = netAmountOnBillService.calculateBillAfterDiscount("CUSTOMER",BigDecimal.valueOf(500),date);
			  assertEquals(0, BigDecimal.valueOf(475).compareTo(amount));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
	    }
	   
	   @Test
	    public void testisOldCustomerSample1() {
		   try {
		   DateFormat format = new SimpleDateFormat("dd/MM/yyyy");	
		   Date date = format.parse("26/10/2015");
		   boolean years = netAmountOnBillService.isOldCustomer(date,2);
		   assertEquals(true, years);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    }
	   
	   @Test
	    public void testisOldCustomerSample2() {
		   try {
		   DateFormat format = new SimpleDateFormat("dd/MM/yyyy");	
		   Date date = format.parse("26/01/2019");
		   boolean years = netAmountOnBillService.isOldCustomer(date,2);
		   assertEquals(false, years);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    }
	   
	   

	   @Test
	    public void testfetchBillAmount() {
		   	User user=new User(1L,"Jagdeesh","Jagadeesh","L","EMPLOYEE",null);
		   	List<Item> items = new ArrayList<Item>();
		    items.add(new Item(BigDecimal.valueOf(100), "Banana", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Apple", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Orange", ItemType.GROCERY));
	        items.add(new Item(BigDecimal.valueOf(100), "Tshirt", ItemType.CLOTHING));
	        items.add(new Item(BigDecimal.valueOf(100), "Jeans", ItemType.CLOTHING));
	        Bill bill=new Bill(100L,"Retail Store",items);   
	        BigDecimal finalAmount = netAmountOnBillService.fetchBillAmount(user, bill);
	        assertEquals(0, BigDecimal.valueOf(415).compareTo(finalAmount));
		  }
}
