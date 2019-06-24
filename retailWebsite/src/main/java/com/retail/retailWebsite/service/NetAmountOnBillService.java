package com.retail.retailWebsite.service;

import java.math.BigDecimal;

import com.retail.retailWebsite.domain.bill.Bill;
import com.retail.retailWebsite.domain.user.User;

public interface NetAmountOnBillService {

	public BigDecimal fetchBillAmount(User user,Bill bill);
}
