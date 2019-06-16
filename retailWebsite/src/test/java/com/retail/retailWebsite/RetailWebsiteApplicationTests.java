package com.retail.retailWebsite;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.retail.retailWebsite.controller.NetAmountOnBillController;
import com.retail.retailWebsite.domain.UserBill;
import com.retail.retailWebsite.service.NetAmountOnBillService;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(value = NetAmountOnBillController.class, secure = false)
public class RetailWebsiteApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	NetAmountOnBillService netAmountOnBillService;
	

	UserBill mockCourse = new UserBill("Course1", new BigDecimal(10), "10 Steps");
	
	BigDecimal bill=new BigDecimal(1000);

	String exampleCourseJson = "{\"userType\":\"EMPLOYEE\",\"billAmount\":\"1000\",\"billType\":\"GROCERYY\"}";

	@SuppressWarnings("deprecation")
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				netAmountOnBillService.fetchBillAmount(Mockito.anyObject()/*Mockito.any(BigDecimal.class))*/)).thenReturn(bill);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/index").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		//String expected = "{userType:EMPLOYEE,billAmount:1000,billType:GROCERY}";
		String expected="1000";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}


}
